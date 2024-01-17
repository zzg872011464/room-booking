package com.example.roombooking.common.validate;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.HibernateValidator;

import java.util.*;

public class ValidateUtil {

    /**
     * 开启快速结束模式 failFast (true)
     */
    private final static Validator VALIDATOR = Validation
            .byProvider(HibernateValidator.class)
            .configure()
            .failFast(false)
            .buildValidatorFactory()
            .getValidator();

    /**
     * 校验对象
     *
     * @param data 被校验的数据对象
     * @param groups 所用校验规则所在的组
     * @return 校验数据的结果
     */
    public static <T> ValidateResult<T> validateBean(T data, Class<?> ... groups) {
        ValidateResult<T> result = new ValidateResult<T>();
        // 验证对象每个属性和其对应不合法信息的存储
        Map<String, ValidateMessage> dataIllegalMessagesMap = new HashMap<>();

        Set<ConstraintViolation<T>> violationSet = VALIDATOR.validate(data, groups);

        boolean hasIllegalData = violationSet != null && violationSet.size() > 0;

        result.setBeValidateData(data);
        result.setInvalid(hasIllegalData);

        if (hasIllegalData) {
            for (ConstraintViolation<T> violation : violationSet) {
                String name = violation.getPropertyPath().toString();
                Object value = violation.getInvalidValue();
                String message = violation.getMessage();

                if (!dataIllegalMessagesMap.containsKey(name)) {
                    ValidateMessage validateMessage = new ValidateMessage();
                    Set<String> msgSet = new HashSet<>();

                    validateMessage.setName(name);
                    validateMessage.setValue(value);

                    msgSet.add(message);
                    validateMessage.setMessages(msgSet);

                    dataIllegalMessagesMap.put(name, validateMessage);
                } else {
                    ValidateMessage validateMessage = dataIllegalMessagesMap.get(name);

                    Set<String> msgSet = validateMessage.getMessages();

                    msgSet.add(message);

                    validateMessage.setMessages(msgSet);

                    dataIllegalMessagesMap.remove(name);
                    dataIllegalMessagesMap.put(name, validateMessage);
                }
            }
        }

        result.setIllegalDataMessagesMap(dataIllegalMessagesMap);

        return result;
    }

    public static <T> ListValidateResult<T> validateListBean(List<T> dataList, Class<?> ...groups) {
        ListValidateResult<T> result = new ListValidateResult<>();

        List<T> validatePassDataList = new ArrayList<>();
        List<ValidateResult<T>> invalidDataList = new ArrayList<>();

        for (T data : dataList) {
            ValidateResult<T> vr = validateBean(data, groups);

            if (vr.isInvalid()) {
                invalidDataList.add(vr);
            } else {
                validatePassDataList.add(vr.getBeValidateData());
            }
        }

        result.setCorrectResult(validatePassDataList);
        result.setErrorResult(invalidDataList);

        return result;
    }
}
