package com.example.roombooking.api.course;

import com.example.roombooking.arc.api.BaseApiController;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.validate.ValidateResult;
import com.example.roombooking.common.validate.ValidateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.example.roombooking.pojo.course.Course;
import com.example.roombooking.service.course.CourseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseApiController implements BaseApiController<Course> {

    @Autowired
    private CourseServiceI courseService;

    @Override
    @PostMapping("/jichu/create")
    public R<Object> create(Course course) {
        ValidateResult<Course> result = ValidateUtil.validateBean(course, CreateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = courseService.create(course);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<Course>> createBatch(List<Course> list) {
        BatchResult<Course> batch = courseService.createBatch(list, new BatchResult<>());

        return R.ok(batch);
    }

    @Override
    @PostMapping("/jichu/update")
    public R<Object> update(Course course) {
        ValidateResult<Course> result = ValidateUtil.validateBean(course, UpdateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = courseService.update(course);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<Course>> updateBatch(List<Course> list) {
        BatchResult<Course> result = courseService.updateBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/jichu/delete")
    public R<Boolean> delete(Course course) {
        boolean delete = courseService.delete(course);

        return R.ok(delete);
    }

    @Override
    public R<BatchResult<Course>> deleteBatch(List<Course> list) {
        BatchResult<Course> result = courseService.deleteBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/list")
    public R<List<Course>> readList(Course course) {
        List<Course> result = courseService.readList(course);

        return R.ok(result);
    }

    @Override
    @PostMapping("/one")
    public R<Course> readOne(Course course) {
        Course one = courseService.readOne(course);

        return R.ok(one);
    }

    @Override
    @PostMapping("/map")
    public R<Map<String, Course>> read4MapByIds(List<String> ids) {
        Map<String, Course> map = courseService.read4MapByIds(ids);

        return R.ok(map);
    }

    @Override
    public R<Boolean> deleteDbData(Course course) {
        boolean result = courseService.deleteDbData(course);

        return R.ok(result);
    }

    @Override
    public R<BatchResult<Course>> deleteDbDataBatch(List<Course> list) {
        BatchResult<Course> result = courseService.deleteDbDataBatch(list, new BatchResult<>());

        return R.ok(result);
    }
}
