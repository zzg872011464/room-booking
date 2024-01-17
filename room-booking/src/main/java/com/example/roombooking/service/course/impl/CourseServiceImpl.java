package com.example.roombooking.service.course.impl;

import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.util.mp.QueryWrapperUtils;
import com.example.roombooking.exception.todo.TodoException;
import com.example.roombooking.mapper.course.CourseMapper;
import com.example.roombooking.pojo.course.Course;
import com.example.roombooking.service.course.CourseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseServiceI {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public boolean create(Course course) {
        return courseMapper.insert(course) == 1;
    }

    @Override
    public BatchResult<Course> createBatch(List<Course> list,
                                           BatchResult<Course> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean update(Course course) {
        return courseMapper.updateById(course) == 1;
    }

    @Override
    public BatchResult<Course> updateBatch(List<Course> list,
                                           BatchResult<Course> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean delete(Course course) {
        return courseMapper.deleteById(course) == 1;
    }

    @Override
    public BatchResult<Course> deleteBatch(List<Course> list,
                                           BatchResult<Course> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<Course> readList(Course course) {
        return courseMapper.selectList(QueryWrapperUtils.buildQueryWrapper(course));
    }

    @Override
    public Course readOne(Course course) {
        if (null == course.getCourseId()) {
            return new Course();
        }

        return courseMapper.selectById(course.getCourseId());
    }

    @Override
    public Map<String, Course> read4MapByIds(List<String> ids) {
        throw new TodoException();
    }

    @Override
    public boolean deleteDbData(Course course) {
        throw new TodoException();
    }

    @Override
    public BatchResult<Course> deleteDbDataBatch(List<Course> list,
                                                 BatchResult<Course> batchResult) {
        throw new TodoException();
    }
}
