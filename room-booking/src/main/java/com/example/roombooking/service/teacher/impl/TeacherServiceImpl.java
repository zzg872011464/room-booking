package com.example.roombooking.service.teacher.impl;

import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.util.mp.QueryWrapperUtils;
import com.example.roombooking.exception.todo.TodoException;
import com.example.roombooking.mapper.teacher.TeacherMapper;
import com.example.roombooking.pojo.teacher.Teacher;
import com.example.roombooking.service.teacher.TeacherServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherServiceI {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public boolean create(Teacher teacher) {
        return teacherMapper.insert(teacher) == 1;
    }

    @Override
    public BatchResult<Teacher> createBatch(List<Teacher> list,
                                            BatchResult<Teacher> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean update(Teacher teacher) {
        return teacherMapper.updateById(teacher) == 1;
    }

    @Override
    public BatchResult<Teacher> updateBatch(List<Teacher> list,
                                            BatchResult<Teacher> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean delete(Teacher teacher) {
        return teacherMapper.deleteById(teacher) == 1;
    }

    @Override
    public BatchResult<Teacher> deleteBatch(List<Teacher> list,
                                            BatchResult<Teacher> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<Teacher> readList(Teacher teacher) {
        return teacherMapper.selectList(QueryWrapperUtils.buildQueryWrapper(teacher));
    }

    @Override
    public Teacher readOne(Teacher teacher) {
        if (null == teacher.getTeacherId()) {
            return new Teacher();
        }

        return teacherMapper.selectById(teacher.getTeacherId());
    }

    @Override
    public Map<String, Teacher> read4MapByIds(List<String> ids) {
        throw new TodoException();
    }

    @Override
    public boolean deleteDbData(Teacher teacher) {
        throw new TodoException();
    }

    @Override
    public BatchResult<Teacher> deleteDbDataBatch(List<Teacher> list,
                                                  BatchResult<Teacher> batchResult) {
        throw new TodoException();
    }
}
