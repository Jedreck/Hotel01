package Mapper;

import Bean.Roomtypeordercheck;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.sql.Date;

public interface RoomtypeordercheckIFS {
    public int selectNowToFuture(@Param("roomType") int roomType
            , @Param("startDate") Date startDate
            , @Param("endDate") Date endDate
    ) throws IOException;
}
