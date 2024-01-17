package com.example.roombooking.arc.api;


import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;

import java.util.List;
import java.util.Map;

public interface BaseApiController<T extends EntityPOJO> {
    // 添加
    R<Object> create(T t);

    R<BatchResult<T>> createBatch(List<T> list);

    // 更新
    R<Object> update(T t);

    R<BatchResult<T>> updateBatch(List<T> list);

    // 逻辑删除
    R<Boolean> delete(T t);

    R<BatchResult<T>> deleteBatch(List<T> list);

    // 查询
    R<List<T>> readList(T t);

    R<T> readOne(T t);

    R<Map<String, T>> read4MapByIds(List<String> ids);

    // 物理删除
    R<Boolean> deleteDbData(T t);

    R<BatchResult<T>> deleteDbDataBatch(List<T> list);
}
