package Mapper;

import Bean.RoomType;

import java.io.IOException;
import java.util.List;

public interface RoomTypeIFS {
    public int insertRoomType(RoomType roomType)throws IOException;
    public List<RoomType> selectAllRoomType()throws IOException;
}
