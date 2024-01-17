package com.example.roombooking.common.validate;

import java.util.List;

public class ListValidateResult<T> {

    // 验证通过的数据
    List<T> correctResult;

    // 验证未通过的数据
    List<ValidateResult<T>> errorResult;

    public List<T> getCorrectResult() {
        return correctResult;
    }

    public void setCorrectResult(List<T> correctResult) {
        this.correctResult = correctResult;
    }

    public List<ValidateResult<T>> getErrorResult() {
        return errorResult;
    }

    public void setErrorResult(List<ValidateResult<T>> errorResult) {
        this.errorResult = errorResult;
    }
}
