package Mapper;

import Bean.Roomtypeordercheck;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public interface RoomtypeordercheckIFS {
    public int selectNowToFuture(@Param("roomType") int roomType
            , @Param("startDate") Date startDate
            , @Param("endDate") Date endDate
    ) throws IOException;

    public Date selectMaxDate(int roomtype) throws IOException;

    public int insertDateOfTime(List<Roomtypeordercheck> list)throws IOException;

    public int updateRoomtypeOfOrderNum(@Param("roomType") int roomType
            , @Param("startDate") Date startDate
            , @Param("endDate") Date endDate
    ) throws IOException;
}
