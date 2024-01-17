package com.example.roombooking.service.student.impl;

import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.util.mp.QueryWrapperUtils;
import com.example.roombooking.exception.todo.TodoException;
import com.example.roombooking.mapper.student.StudentMapper;
import com.example.roombooking.pojo.student.Student;
import com.example.roombooking.service.student.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentServiceI {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean create(Student student) {
        return studentMapper.insert(student) == 1;
    }

    @Override
    public BatchResult<Student> createBatch(List<Student> list,
                                            BatchResult<Student> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean update(Student student) {
        return studentMapper.updateById(student) == 1;
    }

    @Override
    public BatchResult<Student> updateBatch(List<Student> list,
                                            BatchResult<Student> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean delete(Student student) {
        return studentMapper.deleteById(student) == 1;
    }

    @Override
    public BatchResult<Student> deleteBatch(List<Student> list,
                                            BatchResult<Student> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<Student> readList(Student student) {
        return studentMapper.selectList(QueryWrapperUtils.buildQueryWrapper(student));
    }

    @Override
    public Student readOne(Student student) {
        if (null == student.getStudentId()) {
            return new Student();
        }

        return studentMapper.selectById(student.getStudentId());
    }

    @Override
    public Map<String, Student> read4MapByIds(List<String> ids) {
        throw new TodoException();
    }

    @Override
    public boolean deleteDbData(Student student) {
        throw new TodoException();
    }

    @Override
    public BatchResult<Student> deleteDbDataBatch(List<Student> list,
                                                  BatchResult<Student> batchResult) {
        throw new TodoException();
    }
}
