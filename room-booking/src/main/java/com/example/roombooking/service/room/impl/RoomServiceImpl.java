package com.example.roombooking.service.room.impl;

import com.example.roombooking.common.batch.result.BatchResult;
import com.example.roombooking.common.util.mp.QueryWrapperUtils;
import com.example.roombooking.exception.todo.TodoException;
import com.example.roombooking.mapper.room.RoomMapper;
import com.example.roombooking.pojo.room.Room;
import com.example.roombooking.service.room.RoomServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomServiceI {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public boolean create(Room room) {
        return roomMapper.insert(room) == 1;
    }

    @Override
    public BatchResult<Room> createBatch(List<Room> list,
                                            BatchResult<Room> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean update(Room room) {
        return roomMapper.updateById(room) == 1;
    }

    @Override
    public BatchResult<Room> updateBatch(List<Room> list,
                                            BatchResult<Room> batchResult) {
        throw new TodoException();
    }

    @Override
    public boolean delete(Room room) {
        return roomMapper.deleteById(room) == 1;
    }

    @Override
    public BatchResult<Room> deleteBatch(List<Room> list,
                                            BatchResult<Room> batchResult) {
        throw new TodoException();
    }

    @Override
    public List<Room> readList(Room room) {
        return roomMapper.selectList(QueryWrapperUtils.buildQueryWrapper(room));
    }

    @Override
    public Room readOne(Room room) {
        if (null == room.getRoomId()) {
            return new Room();
        }

        return roomMapper.selectById(room.getRoomId());
    }

    @Override
    public Map<String, Room> read4MapByIds(List<String> ids) {
        throw new TodoException();
    }

    @Override
    public boolean deleteDbData(Room room) {
        throw new TodoException();
    }

    @Override
    public BatchResult<Room> deleteDbDataBatch(List<Room> list,
                                                  BatchResult<Room> batchResult) {
        throw new TodoException();
    }
}
