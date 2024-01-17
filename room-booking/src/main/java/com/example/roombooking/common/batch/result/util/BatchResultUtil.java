package com.example.roombooking.common.batch.result.util;



import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.constant.ConstantFields;
import com.example.roombooking.common.data.result.DataResult;

import java.util.ArrayList;
import java.util.List;

public class BatchResultUtil {

    // todo 参数中传code，不一定都是创建错误
    public static <T> BatchResult<T> oneBeanError(T bean, String message) {
        List<T> errorList = new ArrayList<>();
        errorList.add(bean);

        List<DataResult<T>> errorBeanDataResults = new ArrayList<>();

        DataResult<T> oneBeanDataResult = new DataResult<>();
        oneBeanDataResult.setCode(ConstantFields.BATCH_CREATE_DATA_NOT_OK);
        oneBeanDataResult.setMsg(message);
        oneBeanDataResult.setDatas(errorList);
        errorBeanDataResults.add(oneBeanDataResult);

        BatchResult<T> oneBeanBatchResult = new BatchResult<>();
        oneBeanBatchResult.setOk(false);
        oneBeanBatchResult.setResultMsg(message);
        oneBeanBatchResult.setDataResults(errorBeanDataResults);

        return oneBeanBatchResult;
    }

    public static <T> BatchResult<T> listBeanError(List<T> bean, String message) {
        List<DataResult<T>> errorListDataResults = new ArrayList<>();

        DataResult<T> listDataResult = new DataResult<>();
        listDataResult.setCode(ConstantFields.BATCH_CREATE_DATA_NOT_OK);
        listDataResult.setMsg(message);
        listDataResult.setDatas(bean);
        errorListDataResults.add(listDataResult);

        BatchResult<T> listBatchResult = new BatchResult<>();
        listBatchResult.setOk(false);
        listBatchResult.setResultMsg(ConstantFields.OPERATION_BATCH_ERROR);
        listBatchResult.setDataResults(errorListDataResults);

        return listBatchResult;
    }

    private BatchResultUtil() {}
}