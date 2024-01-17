package com.example.roombooking.api.student.course;

import com.example.roombooking.arc.api.BaseApiController;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.validate.ValidateResult;
import com.example.roombooking.common.validate.ValidateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.example.roombooking.pojo.student.course.StudentCourse;
import com.example.roombooking.service.student.course.StudentCourseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student/courses")
public class StudentCourseApiController implements BaseApiController<StudentCourse> {

    @Autowired
    private StudentCourseServiceI studentCourseService;

    @Override
    @PostMapping("/jichu/create")
    public R<Object> create(StudentCourse studentCourse) {
        ValidateResult<StudentCourse> result = ValidateUtil.validateBean(studentCourse, CreateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = studentCourseService.create(studentCourse);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<StudentCourse>> createBatch(List<StudentCourse> list) {
        BatchResult<StudentCourse> batch = studentCourseService.createBatch(list, new BatchResult<>());

        return R.ok(batch);
    }

    @Override
    @PostMapping("/jichu/update")
    public R<Object> update(StudentCourse studentCourse) {
        ValidateResult<StudentCourse> result = ValidateUtil.validateBean(studentCourse, UpdateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = studentCourseService.update(studentCourse);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<StudentCourse>> updateBatch(List<StudentCourse> list) {
        BatchResult<StudentCourse> result = studentCourseService.updateBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/jichu/delete")
    public R<Boolean> delete(StudentCourse studentCourse) {
        boolean delete = studentCourseService.delete(studentCourse);

        return R.ok(delete);
    }

    @Override
    public R<BatchResult<StudentCourse>> deleteBatch(List<StudentCourse> list) {
        BatchResult<StudentCourse> result = studentCourseService.deleteBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/list")
    public R<List<StudentCourse>> readList(StudentCourse studentCourse) {
        List<StudentCourse> result = studentCourseService.readList(studentCourse);

        return R.ok(result);
    }

    @Override
    @PostMapping("/one")
    public R<StudentCourse> readOne(StudentCourse studentCourse) {
        StudentCourse one = studentCourseService.readOne(studentCourse);

        return R.ok(one);
    }

    @Override
    @PostMapping("/map")
    public R<Map<String, StudentCourse>> read4MapByIds(List<String> ids) {
        Map<String, StudentCourse> map = studentCourseService.read4MapByIds(ids);

        return R.ok(map);
    }

    @Override
    public R<Boolean> deleteDbData(StudentCourse studentCourse) {
        boolean result = studentCourseService.deleteDbData(studentCourse);

        return R.ok(result);
    }

    @Override
    public R<BatchResult<StudentCourse>> deleteDbDataBatch(List<StudentCourse> list) {
        BatchResult<StudentCourse> result = studentCourseService.deleteDbDataBatch(list, new BatchResult<>());

        return R.ok(result);
    }
}
