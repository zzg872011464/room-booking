package com.example.roombooking.api.room.booking.history;

import com.example.roombooking.arc.api.BaseApiController;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.validate.ValidateResult;
import com.example.roombooking.common.validate.ValidateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.example.roombooking.pojo.room.booking.history.RoomBookingHistory;
import com.example.roombooking.service.room.booking.history.RoomBookingHistoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room/booking/histories")
public class RoomBookingHistoryApiController implements BaseApiController<RoomBookingHistory> {

    @Autowired
    private RoomBookingHistoryServiceI roomBookingHistoryService;

    @Override
    @PostMapping("/jichu/create")
    public R<Object> create(RoomBookingHistory roomBookingHistory) {
        ValidateResult<RoomBookingHistory> result = ValidateUtil.validateBean(roomBookingHistory, CreateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = roomBookingHistoryService.create(roomBookingHistory);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<RoomBookingHistory>> createBatch(List<RoomBookingHistory> list) {
        BatchResult<RoomBookingHistory> batch = roomBookingHistoryService.createBatch(list, new BatchResult<>());

        return R.ok(batch);
    }

    @Override
    @PostMapping("/jichu/update")
    public R<Object> update(RoomBookingHistory roomBookingHistory) {
        ValidateResult<RoomBookingHistory> result = ValidateUtil.validateBean(roomBookingHistory, UpdateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = roomBookingHistoryService.update(roomBookingHistory);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<RoomBookingHistory>> updateBatch(List<RoomBookingHistory> list) {
        BatchResult<RoomBookingHistory> result = roomBookingHistoryService.updateBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/jichu/delete")
    public R<Boolean> delete(RoomBookingHistory roomBookingHistory) {
        boolean delete = roomBookingHistoryService.delete(roomBookingHistory);

        return R.ok(delete);
    }

    @Override
    public R<BatchResult<RoomBookingHistory>> deleteBatch(List<RoomBookingHistory> list) {
        BatchResult<RoomBookingHistory> result = roomBookingHistoryService.deleteBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/list")
    public R<List<RoomBookingHistory>> readList(RoomBookingHistory roomBookingHistory) {
        List<RoomBookingHistory> result = roomBookingHistoryService.readList(roomBookingHistory);

        return R.ok(result);
    }

    @Override
    @PostMapping("/one")
    public R<RoomBookingHistory> readOne(RoomBookingHistory roomBookingHistory) {
        RoomBookingHistory one = roomBookingHistoryService.readOne(roomBookingHistory);

        return R.ok(one);
    }

    @Override
    @PostMapping("/map")
    public R<Map<String, RoomBookingHistory>> read4MapByIds(List<String> ids) {
        Map<String, RoomBookingHistory> map = roomBookingHistoryService.read4MapByIds(ids);

        return R.ok(map);
    }

    @Override
    public R<Boolean> deleteDbData(RoomBookingHistory roomBookingHistory) {
        boolean result = roomBookingHistoryService.deleteDbData(roomBookingHistory);

        return R.ok(result);
    }

    @Override
    public R<BatchResult<RoomBookingHistory>> deleteDbDataBatch(List<RoomBookingHistory> list) {
        BatchResult<RoomBookingHistory> result = roomBookingHistoryService.deleteDbDataBatch(list, new BatchResult<>());

        return R.ok(result);
    }
}
