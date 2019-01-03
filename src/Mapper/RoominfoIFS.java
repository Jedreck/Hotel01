package Mapper;

import Bean.Roominfo;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface RoominfoIFS {
    public int InsertRoom(Roominfo roominfo)throws IOException;
    public int UpdateRoom(Roominfo roominfo)throws IOException;
    public List<Map<String,Object>> SelectAllRooms(@Param(value="offset")int offset, @Param(value="typename") String typename)throws IOException;
    public int DeleteRoom(String R_num)throws IOException;
    public Roominfo SelectRoomByNum(String R_num)throws IOException;
    public int GetTotalDatas(@Param(value="typename") String typename)throws IOException;
}
