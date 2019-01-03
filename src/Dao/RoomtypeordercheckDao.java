package Dao;

import Bean.Roomtypeordercheck;
import Dao.Tools.getSqlSession;
import Mapper.RoomtypeordercheckIFS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Date;

public class RoomtypeordercheckDao {
    public static int CheckRoomtypeAndDate(@Param("roomType") int roomType
            , @Param("startDate") Date startDate
            , @Param("endDate") Date endDate
    )throws IOException {
        SqlSession session= getSqlSession.getSession().openSession();
        RoomtypeordercheckIFS roomtypeordercheckIFS = session.getMapper(RoomtypeordercheckIFS.class);

        int num = roomtypeordercheckIFS.selectNowToFuture(roomType,startDate,endDate);

        session.commit();
        session.close();

        return num;
    }
}
