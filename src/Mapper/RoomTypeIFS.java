package Mapper;

import Bean.RoomType;

import java.io.IOException;
import java.util.List;

public interface RoomTypeIFS {
    public int insertRoomType(RoomType roomType)throws IOException;
    public List<RoomType> selectAllRoomType(int offset)throws IOException;
    public int deleteRoomType(int R_roomtype)throws IOException;
}
