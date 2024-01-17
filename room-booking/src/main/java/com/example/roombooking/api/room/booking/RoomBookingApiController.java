package com.example.roombooking.api.room.booking;

import com.example.roombooking.arc.api.BaseApiController;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.rest.r.RCode;
import com.example.roombooking.common.validate.ValidateResult;
import com.example.roombooking.common.validate.ValidateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.example.roombooking.pojo.room.booking.RoomBooking;
import com.example.roombooking.pojo.room.booking.dto.RoomBookingDTO;
import com.example.roombooking.service.room.booking.RoomBookingServiceI;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/room/bookings")
public class RoomBookingApiController implements BaseApiController<RoomBooking> {

    @Autowired
    private RoomBookingServiceI roomBookingService;

    @Override
    @PostMapping("/jichu/create")
    public R<Object> create(RoomBooking roomBooking) {
        ValidateResult<RoomBooking> result = ValidateUtil.validateBean(roomBooking, CreateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = roomBookingService.create(roomBooking);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<RoomBooking>> createBatch(List<RoomBooking> list) {
        BatchResult<RoomBooking> batch = roomBookingService.createBatch(list, new BatchResult<>());

        return R.ok(batch);
    }

    @Override
    @PostMapping("/jichu/update")
    public R<Object> update(RoomBooking roomBooking) {
        ValidateResult<RoomBooking> result = ValidateUtil.validateBean(roomBooking, UpdateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = roomBookingService.update(roomBooking);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<RoomBooking>> updateBatch(List<RoomBooking> list) {
        BatchResult<RoomBooking> result = roomBookingService.updateBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/jichu/delete")
    public R<Boolean> delete(RoomBooking roomBooking) {
        boolean delete = roomBookingService.delete(roomBooking);

        return R.ok(delete);
    }

    @Override
    public R<BatchResult<RoomBooking>> deleteBatch(List<RoomBooking> list) {
        BatchResult<RoomBooking> result = roomBookingService.deleteBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/list")
    public R<List<RoomBooking>> readList(RoomBooking roomBooking) {
        List<RoomBooking> result = roomBookingService.readList(roomBooking);

        return R.ok(result);
    }

    @Override
    @PostMapping("/one")
    public R<RoomBooking> readOne(RoomBooking roomBooking) {
        RoomBooking one = roomBookingService.readOne(roomBooking);

        return R.ok(one);
    }

    @Override
    @PostMapping("/map")
    public R<Map<String, RoomBooking>> read4MapByIds(List<String> ids) {
        Map<String, RoomBooking> map = roomBookingService.read4MapByIds(ids);

        return R.ok(map);
    }

    @Override
    public R<Boolean> deleteDbData(RoomBooking roomBooking) {
        boolean result = roomBookingService.deleteDbData(roomBooking);

        return R.ok(result);
    }

    @Override
    public R<BatchResult<RoomBooking>> deleteDbDataBatch(List<RoomBooking> list) {
        BatchResult<RoomBooking> result = roomBookingService.deleteDbDataBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    // 教师预定房间
    @PostMapping("/teacher/create")
    public ModelAndView teacherBooking(RoomBookingDTO roomBookingDTO) {
        ModelAndView modelAndView = new ModelAndView();

        // 1.数据校验
        if (null == roomBookingDTO
                || Strings.isNullOrEmpty(roomBookingDTO.getTeacherId())
                || Strings.isNullOrEmpty(roomBookingDTO.getCourseId())
                || null == roomBookingDTO.getWeekDay()
                || null == roomBookingDTO.getCourseStart()
                || null == roomBookingDTO.getDeadline()) {

            modelAndView.setViewName("dataInvalid");
            modelAndView.addObject(R.dataInvalid(roomBookingDTO));

            return modelAndView;
        }

        R<Object> bookingResult = roomBookingService.teacherBooking(roomBookingDTO);

        modelAndView.addObject(bookingResult);

        if (RCode.SUCCESS.getCode() == bookingResult.getCode()) {
            modelAndView.setViewName("bookingSuccess");
        } else if (RCode.DATA_INVALID.getCode() == bookingResult.getCode()) {
            modelAndView.setViewName("dataInvalid");
        } else {
            modelAndView.setViewName("bookingBad");
        }

        return modelAndView;
    }

    @GetMapping("/teacher/request")
    public String V2() {
        return "request";
    }

    @GetMapping("/booking-success")
    public String bookingSuccess() {
        return "bookingSuccess";
    }

    @GetMapping("/booking-bad")
    public String bookingBad() {
        return "bookingBad";
    }

    @GetMapping("/booking-invalid")
    public String bookingInvalid() {
        return "dataInvalid";
    }
}
