package com.example.roombooking.arc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.roombooking.arc.pojo.EntityPOJO;
import com.example.roombooking.common.batch.result.BatchResult;

import java.util.List;
import java.util.Map;

public interface BaseService<T extends EntityPOJO>{
    //c r u d page batch (c u d) import excel(?)
    // delete <=> update deleteFlag = 1

    // 添加
    boolean create(T t);

    BatchResult<T> createBatch(List<T> list, BatchResult<T> batchResult);

    // 更新
    boolean update(T t);

    BatchResult<T> updateBatch(List<T> list, BatchResult<T> batchResult);

    // 逻辑删除
    boolean delete(T t);

    BatchResult<T> deleteBatch(List<T> list, BatchResult<T> batchResult);

    // 查询
    List<T> readList(T t);

    T readOne(T t);

    Map<String, T> read4MapByIds(List<String> ids);

    // 物理删除
    boolean deleteDbData(T t);

    BatchResult<T> deleteDbDataBatch(List<T> list, BatchResult<T> batchResult);
}
