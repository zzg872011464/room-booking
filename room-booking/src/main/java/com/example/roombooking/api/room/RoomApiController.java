package com.example.roombooking.api.room;

import com.example.roombooking.arc.api.BaseApiController;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.validate.ValidateResult;
import com.example.roombooking.common.validate.ValidateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.example.roombooking.pojo.room.Room;
import com.example.roombooking.service.room.RoomServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rooms")
public class RoomApiController implements BaseApiController<Room> {

    @Autowired
    private RoomServiceI roomService;

    @Override
    @PostMapping("/jichu/create")
    public R<Object> create(Room room) {
        ValidateResult<Room> result = ValidateUtil.validateBean(room, CreateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = roomService.create(room);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<Room>> createBatch(List<Room> list) {
        BatchResult<Room> batch = roomService.createBatch(list, new BatchResult<>());

        return R.ok(batch);
    }

    @Override
    @PostMapping("/jichu/update")
    public R<Object> update(Room room) {
        ValidateResult<Room> result = ValidateUtil.validateBean(room, UpdateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = roomService.update(room);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<Room>> updateBatch(List<Room> list) {
        BatchResult<Room> result = roomService.updateBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/jichu/delete")
    public R<Boolean> delete(Room room) {
        boolean delete = roomService.delete(room);

        return R.ok(delete);
    }

    @Override
    public R<BatchResult<Room>> deleteBatch(List<Room> list) {
        BatchResult<Room> result = roomService.deleteBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/list")
    public R<List<Room>> readList(Room room) {
        List<Room> result = roomService.readList(room);

        return R.ok(result);
    }

    @Override
    @PostMapping("/one")
    public R<Room> readOne(Room room) {
        Room one = roomService.readOne(room);

        return R.ok(one);
    }

    @Override
    @PostMapping("/map")
    public R<Map<String, Room>> read4MapByIds(List<String> ids) {
        Map<String, Room> map = roomService.read4MapByIds(ids);

        return R.ok(map);
    }

    @Override
    public R<Boolean> deleteDbData(Room room) {
        boolean result = roomService.deleteDbData(room);

        return R.ok(result);
    }

    @Override
    public R<BatchResult<Room>> deleteDbDataBatch(List<Room> list) {
        BatchResult<Room> result = roomService.deleteDbDataBatch(list, new BatchResult<>());

        return R.ok(result);
    }
}
