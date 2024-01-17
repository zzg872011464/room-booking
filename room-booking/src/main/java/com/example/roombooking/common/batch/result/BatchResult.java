package com.example.roombooking.common.batch.result;

import com.example.roombooking.common.constant.ConstantFields;
import com.example.roombooking.common.data.result.DataResult;

import java.util.ArrayList;
import java.util.List;

public class BatchResult<T> {
    // 操作是否成功
    private boolean ok;
    // 操作返回信息
    private String resultMsg;
    // 返回数据
    private List<DataResult<T>> dataResults;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<DataResult<T>> getDataResults() {
        return dataResults;
    }

    public void setDataResults(List<DataResult<T>> dataResults) {
        this.dataResults = dataResults;
    }

    public int getSuccessAmount() {
        if (null == dataResults
                || dataResults.isEmpty()) {
            return 0;
        } else {
            List<DataResult<T>> successList = new ArrayList<>();
            dataResults.forEach(item -> {
                switch (item.getCode()) {
                    case ConstantFields.BATCH_CREATE_DATA_OK,
                            ConstantFields.BATCH_UPDATE_DATA_OK,
                            ConstantFields.BATCH_DELETE_DATA_OK,
                            ConstantFields.BATCH_DELETE_DB_DATA_OK -> {
                        successList.add(item);
                    }
                }
            });

            if (successList.size() != 1) {
                return 0;
            } else {
                DataResult<T> successDataResult = successList.get(0);

                if (null == successDataResult.getDatas()
                        || successDataResult.getDatas().isEmpty()) {
                    return 0;
                } else {
                    return successDataResult.getDatas().size();
                }
            }
        }
    }
}
