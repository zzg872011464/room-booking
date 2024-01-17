package com.example.roombooking.api.student;

import com.example.roombooking.arc.api.BaseApiController;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.util.primary.key.PrimaryKeyUtil;
import com.example.roombooking.common.validate.ValidateResult;
import com.example.roombooking.common.validate.ValidateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.example.roombooking.pojo.student.Student;
import com.example.roombooking.service.student.StudentServiceI;
import com.example.roombooking.service.student.impl.StudentServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentApiController implements BaseApiController<Student> {

    @Autowired
    private StudentServiceI studentService;

    @Override
    @PostMapping("/jichu/create")
    public R<Object> create(Student student) {
        ValidateResult<Student> result = ValidateUtil.validateBean(student, CreateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = studentService.create(student);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<Student>> createBatch(List<Student> list) {
        BatchResult<Student> batch = studentService.createBatch(list, new BatchResult<>());

        return R.ok(batch);
    }

    @Override
    @PostMapping("/jichu/update")
    public R<Object> update(Student student) {
        ValidateResult<Student> result = ValidateUtil.validateBean(student, UpdateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = studentService.update(student);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<Student>> updateBatch(List<Student> list) {
        BatchResult<Student> result = studentService.updateBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/jichu/delete")
    public R<Boolean> delete(Student student) {
        boolean delete = studentService.delete(student);

        return R.ok(delete);
    }

    @Override
    public R<BatchResult<Student>> deleteBatch(List<Student> list) {
        BatchResult<Student> result = studentService.deleteBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/list")
    public R<List<Student>> readList(Student student) {
        List<Student> result = studentService.readList(student);

        return R.ok(result);
    }

    @Override
    @PostMapping("/one")
    public R<Student> readOne(Student student) {
        Student one = studentService.readOne(student);

        return R.ok(one);
    }

    @Override
    @PostMapping("/map")
    public R<Map<String, Student>> read4MapByIds(List<String> ids) {
        Map<String, Student> map = studentService.read4MapByIds(ids);

        return R.ok(map);
    }

    @Override
    public R<Boolean> deleteDbData(Student student) {
        boolean result = studentService.deleteDbData(student);

        return R.ok(result);
    }

    @Override
    public R<BatchResult<Student>> deleteDbDataBatch(List<Student> list) {
        BatchResult<Student> result = studentService.deleteDbDataBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    public R<Object> test() {
        Student student = new Student();
        student.setStudentId(PrimaryKeyUtil.getPrimaryKey());
        student.setStudentName("zzg");
        student.setStudentNumber("211xxx");
        student.setStudentEmail("8720.xxx");

        boolean b = studentService.create(student);

        return R.ok(b);
    }

    public void testReadById() {
        Student student = new Student();
        student.setStudentId("1");

        Student one = studentService.readOne(student);

        System.out.println(one);
    }
}
