package com.example.roombooking.service.student.course.impl;

import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.util.mp.QueryWrapperUtils;
import com.example.roombooking.common.util.primary.key.PrimaryKeyUtil;
import com.example.roombooking.exception.todo.TodoException;
import com.example.roombooking.mapper.student.course.StudentCourseMapper;
import com.example.roombooking.pojo.student.course.StudentCourse;
import com.example.roombooking.service.student.course.StudentCourseServiceI;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentCourseServiceImpl implements StudentCourseServiceI {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Override
    public boolean create(StudentCourse studentCourse) {
        if (Strings.isNullOrEmpty(studentCourse.getCourseId())) {
            studentCourse.setCorrelationId(PrimaryKeyUtil.getPrimaryKey());
        }

        return studentCourseMapper.insert(studentCourse) == 1;
    }

    @Override
    public BatchResult<StudentCourse> createBatch(List<StudentCourse> list,
                                            BatchResult<StudentCourse> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean update(StudentCourse studentCourse) {
        return studentCourseMapper.updateById(studentCourse) == 1;
    }

    @Override
    public BatchResult<StudentCourse> updateBatch(List<StudentCourse> list,
                                            BatchResult<StudentCourse> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean delete(StudentCourse studentCourse) {
        return studentCourseMapper.deleteById(studentCourse) == 1;
    }

    @Override
    public BatchResult<StudentCourse> deleteBatch(List<StudentCourse> list,
                                            BatchResult<StudentCourse> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<StudentCourse> readList(StudentCourse studentCourse) {
        return studentCourseMapper.selectList(QueryWrapperUtils.buildQueryWrapper(studentCourse));
    }

    @Override
    public StudentCourse readOne(StudentCourse studentCourse) {
        if (null == studentCourse.getCourseId()) {
            return new StudentCourse();
        }

        return studentCourseMapper.selectById(studentCourse.getStudentId());
    }

    @Override
    public Map<String, StudentCourse> read4MapByIds(List<String> ids) {
        throw new TodoException();
    }

    @Override
    public boolean deleteDbData(StudentCourse studentCourse) {
        throw new TodoException();
    }

    @Override
    public BatchResult<StudentCourse> deleteDbDataBatch(List<StudentCourse> list,
                                                  BatchResult<StudentCourse> batchResult) {
        throw new TodoException();
    }
}
