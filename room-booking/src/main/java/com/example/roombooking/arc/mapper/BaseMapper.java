package com.example.roombooking.arc.mapper;

import com.example.roombooking.arc.pojo.EntityPOJO;

import java.util.List;

public interface BaseMapper<T extends EntityPOJO> {
    // insert select update delete page batch (insert update delete)
    // delete <=> update deleteFlag = 1

    // 添加
    int insert(T t);

    int insertBatch(List<T> list);

    // 更新
    int update(T t);

    int updateBatch(List<T> list);

    // 逻辑删除
    int delete(T t);

    int deleteBatch(List<T> list);

    // 查询
    List<T> selectList(T t);

    T selectOne(T t);

    // 物理删除
    int deleteDbData(T t);

    int deleteDbDataBatch(List<T> list);

    // 查询number
    T selectOne4MaxNumber(); // select .... From .... ORDER BY number DESC LIMIT 0,1

    // 计数
    long count();

    //名字唯一性验证
    int selectNameUnique(T t);
}
