package Mapper;

import Bean.RoomType;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface RoomTypeIFS {
    public int insertRoomType(RoomType roomType)throws IOException;
    public List<RoomType> selectAllRoomType(@Param(value="offset")int offset, @Param(value="typename") String typename)throws IOException;
    public int deleteRoomType(int R_roomtype)throws IOException;
    public RoomType SelectRoomTypeByTB(int R_roomtype)throws IOException;
    public int UpdateRoomType(RoomType roomType)throws IOException;
    public void UpdateRoomNum(@Param(value="R_roomtype")int R_roomtype, @Param(value="increment")int increment)throws IOException;
    public int GetTotalDatas(@Param(value="typename") String typename)throws IOException;
    public List<Map<String,Object>> SelectTN()throws IOException;
    public List<RoomType> selectRoomtypeForBookSearch(RoomType roomType)throws IOException;

}
