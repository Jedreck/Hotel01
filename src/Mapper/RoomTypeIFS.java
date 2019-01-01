package Mapper;

import Bean.RoomType;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface RoomTypeIFS {
    public int insertRoomType(RoomType roomType)throws IOException;
    public List<RoomType> selectAllRoomType(@Param(value="offset")int offset, @Param(value="typename") String typename)throws IOException;
    public int deleteRoomType(int R_roomtype)throws IOException;
    public RoomType SelectRoomTypeByTB(int R_roomtype)throws IOException;
    public int UpdateRoomType(RoomType roomType)throws IOException;
    public int GetTotalDatas(@Param(value="typename") String typename)throws IOException;
}
