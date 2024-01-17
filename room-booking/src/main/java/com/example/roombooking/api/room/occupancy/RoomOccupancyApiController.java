package com.example.roombooking.api.room.occupancy;

import com.example.roombooking.arc.api.BaseApiController;
import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.common.validate.ValidateResult;
import com.example.roombooking.common.validate.ValidateUtil;
import com.example.roombooking.common.validate.groups.CreateValidateGroup;
import com.example.roombooking.common.validate.groups.UpdateValidateGroup;
import com.example.roombooking.pojo.room.occupancy.RoomOccupancy;
import com.example.roombooking.service.room.occupancy.RoomOccupancyServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roomOccupancy/occupancies")
public class RoomOccupancyApiController implements BaseApiController<RoomOccupancy> {

    @Autowired
    private RoomOccupancyServiceI roomOccupancyService;

    @Override
    @PostMapping("/jichu/create")
    public R<Object> create(RoomOccupancy roomOccupancy) {
        ValidateResult<RoomOccupancy> result = ValidateUtil.validateBean(roomOccupancy, CreateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = roomOccupancyService.create(roomOccupancy);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<RoomOccupancy>> createBatch(List<RoomOccupancy> list) {
        BatchResult<RoomOccupancy> batch = roomOccupancyService.createBatch(list, new BatchResult<>());

        return R.ok(batch);
    }

    @Override
    @PostMapping("/jichu/update")
    public R<Object> update(RoomOccupancy roomOccupancy) {
        ValidateResult<RoomOccupancy> result = ValidateUtil.validateBean(roomOccupancy, UpdateValidateGroup.class);
        if (result.isInvalid()) return R.dataInvalid(result);

        boolean ops = roomOccupancyService.update(roomOccupancy);

        return R.ok(ops);
    }

    @Override
    public R<BatchResult<RoomOccupancy>> updateBatch(List<RoomOccupancy> list) {
        BatchResult<RoomOccupancy> result = roomOccupancyService.updateBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/jichu/delete")
    public R<Boolean> delete(RoomOccupancy roomOccupancy) {
        boolean delete = roomOccupancyService.delete(roomOccupancy);

        return R.ok(delete);
    }

    @Override
    public R<BatchResult<RoomOccupancy>> deleteBatch(List<RoomOccupancy> list) {
        BatchResult<RoomOccupancy> result = roomOccupancyService.deleteBatch(list, new BatchResult<>());

        return R.ok(result);
    }

    @Override
    @PostMapping("/list")
    public R<List<RoomOccupancy>> readList(RoomOccupancy roomOccupancy) {
        List<RoomOccupancy> result = roomOccupancyService.readList(roomOccupancy);

        return R.ok(result);
    }

    @Override
    @PostMapping("/one")
    public R<RoomOccupancy> readOne(RoomOccupancy roomOccupancy) {
        RoomOccupancy one = roomOccupancyService.readOne(roomOccupancy);

        return R.ok(one);
    }

    @Override
    @PostMapping("/map")
    public R<Map<String, RoomOccupancy>> read4MapByIds(List<String> ids) {
        Map<String, RoomOccupancy> map = roomOccupancyService.read4MapByIds(ids);

        return R.ok(map);
    }

    @Override
    public R<Boolean> deleteDbData(RoomOccupancy roomOccupancy) {
        boolean result = roomOccupancyService.deleteDbData(roomOccupancy);

        return R.ok(result);
    }

    @Override
    public R<BatchResult<RoomOccupancy>> deleteDbDataBatch(List<RoomOccupancy> list) {
        BatchResult<RoomOccupancy> result = roomOccupancyService.deleteDbDataBatch(list, new BatchResult<>());

        return R.ok(result);
    }
}
