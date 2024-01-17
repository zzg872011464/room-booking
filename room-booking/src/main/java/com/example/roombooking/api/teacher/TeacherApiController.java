package com.example.roombooking.api.teacher;

import com.example.roombooking.arc.api.BaseApiController;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.util.primary.key.PrimaryKeyUtil;
import com.example.roombooking.common.validate.ValidateResult;
import com.example.roombooking.common.validate.ValidateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.example.roombooking.pojo.teacher.Teacher;
import com.example.roombooking.service.teacher.TeacherServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teachers")
public class TeacherApiController implements BaseApiController<Teacher> {

    @Autowired
    private TeacherServiceI teacherService;

    @Override
    @PostMapping("/jichu/create")
    public R<Object> create(Teacher teacher) {
        ValidateResult<Teacher> result = ValidateUtil.validateBean(teacher, CreateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = teacherService.create(teacher);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<Teacher>> createBatch(List<Teacher> list) {
        BatchResult<Teacher> batch = teacherService.createBatch(list, new BatchResult<>());

        return R.ok(batch);
    }

    @Override
    @PostMapping("/jichu/update")
    public R<Object> update(Teacher teacher) {
        ValidateResult<Teacher> result = ValidateUtil.validateBean(teacher, UpdateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = teacherService.update(teacher);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<Teacher>> updateBatch(List<Teacher> list) {
        BatchResult<Teacher> result = teacherService.updateBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/jichu/delete")
    public R<Boolean> delete(Teacher teacher) {
        boolean delete = teacherService.delete(teacher);

        return R.ok(delete);
    }

    @Override
    public R<BatchResult<Teacher>> deleteBatch(List<Teacher> list) {
        BatchResult<Teacher> result = teacherService.deleteBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/list")
    public R<List<Teacher>> readList(Teacher teacher) {
        List<Teacher> result = teacherService.readList(teacher);

        return R.ok(result);
    }

    @Override
    @PostMapping("/one")
    public R<Teacher> readOne(Teacher teacher) {
        Teacher one = teacherService.readOne(teacher);

        return R.ok(one);
    }

    @Override
    @PostMapping("/map")
    public R<Map<String, Teacher>> read4MapByIds(List<String> ids) {
        Map<String, Teacher> map = teacherService.read4MapByIds(ids);

        return R.ok(map);
    }

    @Override
    public R<Boolean> deleteDbData(Teacher teacher) {
        boolean result = teacherService.deleteDbData(teacher);

        return R.ok(result);
    }

    @Override
    public R<BatchResult<Teacher>> deleteDbDataBatch(List<Teacher> list) {
        BatchResult<Teacher> result = teacherService.deleteDbDataBatch(list, new BatchResult<>());

        return R.ok(result);
    }
}
