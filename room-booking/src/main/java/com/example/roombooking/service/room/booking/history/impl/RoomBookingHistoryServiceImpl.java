package com.example.roombooking.service.room.booking.history.impl;

import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.util.mp.QueryWrapperUtils;
import com.example.roombooking.common.util.primary.key.PrimaryKeyUtil;
import com.example.roombooking.exception.todo.TodoException;
import com.example.roombooking.mapper.room.booking.history.RoomBookingHistoryMapper;
import com.example.roombooking.pojo.room.booking.history.RoomBookingHistory;
import com.example.roombooking.service.room.booking.history.RoomBookingHistoryServiceI;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoomBookingHistoryServiceImpl implements RoomBookingHistoryServiceI {

    @Autowired
    private RoomBookingHistoryMapper roomBookingHistoryMapper;

    @Override
    public boolean create(RoomBookingHistory roomBookingHistory) {
        if (Strings.isNullOrEmpty(roomBookingHistory.getHistoryId())) {
            roomBookingHistory.setHistoryId(PrimaryKeyUtil.getPrimaryKey());
        }

        return roomBookingHistoryMapper.insert(roomBookingHistory) == 1;
    }

    @Override
    public BatchResult<RoomBookingHistory> createBatch(List<RoomBookingHistory> list,
                                            BatchResult<RoomBookingHistory> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean update(RoomBookingHistory roomBookingHistory) {
        return roomBookingHistoryMapper.updateById(roomBookingHistory) == 1;
    }

    @Override
    public BatchResult<RoomBookingHistory> updateBatch(List<RoomBookingHistory> list,
                                            BatchResult<RoomBookingHistory> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean delete(RoomBookingHistory roomBookingHistory) {
        return roomBookingHistoryMapper.deleteById(roomBookingHistory) == 1;
    }

    @Override
    public BatchResult<RoomBookingHistory> deleteBatch(List<RoomBookingHistory> list,
                                            BatchResult<RoomBookingHistory> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<RoomBookingHistory> readList(RoomBookingHistory roomBookingHistory) {
        return roomBookingHistoryMapper.selectList(QueryWrapperUtils.buildQueryWrapper(roomBookingHistory));
    }

    @Override
    public RoomBookingHistory readOne(RoomBookingHistory roomBookingHistory) {
        if (null == roomBookingHistory.getTeacherId()) {
            return new RoomBookingHistory();
        }

        return roomBookingHistoryMapper.selectById(roomBookingHistory.getTeacherId());
    }

    @Override
    public Map<String, RoomBookingHistory> read4MapByIds(List<String> ids) {
        throw new TodoException();
    }

    @Override
    public boolean deleteDbData(RoomBookingHistory roomBookingHistory) {
        throw new TodoException();
    }

    @Override
    public BatchResult<RoomBookingHistory> deleteDbDataBatch(List<RoomBookingHistory> list,
                                                  BatchResult<RoomBookingHistory> batchResult) {
        throw new TodoException();
    }
}
