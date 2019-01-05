package Dao;

import Bean.Roomtypeordercheck;
import Dao.Tools.LogOut;
import Dao.Tools.getSqlSession;
import Mapper.RoomtypeordercheckIFS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RoomtypeordercheckDao {
    public static int CheckRoomtypeAndDate(@Param("roomType") int roomType
            , @Param("startDate") Date startDate
            , @Param("endDate") Date endDate
    ) throws IOException {
        SqlSession session = getSqlSession.getSession().openSession();
        RoomtypeordercheckIFS roomtypeordercheckIFS = session.getMapper(RoomtypeordercheckIFS.class);

        int num = roomtypeordercheckIFS.selectNowToFuture(roomType, startDate, endDate);

        session.commit();
        session.close();

        return num;
    }

    private static Date getMaxDateOfType(int roomtype) throws IOException {
        SqlSession session = getSqlSession.getSession().openSession();
        RoomtypeordercheckIFS roomtypeordercheckIFS = session.getMapper(RoomtypeordercheckIFS.class);

        Date date = roomtypeordercheckIFS.selectMaxDate(roomtype);

        session.commit();
        session.close();
        return date;
    }

    private static int insertDateOfTime(List<Roomtypeordercheck> list) throws IOException {
        SqlSession session = getSqlSession.getSession().openSession();
        RoomtypeordercheckIFS roomtypeordercheckIFS = session.getMapper(RoomtypeordercheckIFS.class);

        int num = roomtypeordercheckIFS.insertDateOfTime(list);

        session.commit();
        session.close();
        return num;
    }

    public static int checkMaxDate(int roomtype, java.util.Date selectDate) throws IOException {
        long ADATE = 1000 * 60 * 60 * 24;
        java.util.Date nowDate = new java.util.Date();
        java.util.Date endDate = new java.util.Date(nowDate.getTime() + (ADATE * 120));

        //先检查对应房型最高的date
        java.util.Date startDate = RoomtypeordercheckDao.getMaxDateOfType(roomtype);

        //信息输出
        LogOut.Info("startDate", startDate);
        LogOut.Info("selectDate", selectDate);
        LogOut.Info("endDate", endDate);

        java.util.Date tempDate = new java.util.Date();
        if (startDate == null) {
            //无记录，增加
            tempDate.setTime(nowDate.getTime());
        } else if (startDate.compareTo(selectDate) < 0) {
            //如果不够大，则增加
            tempDate.setTime(startDate.getTime() + ADATE);
        } else {
            //如果最高date够大，则返回
            return 0;
        }

        LogOut.Info("tempDate", tempDate);

        List<Roomtypeordercheck> list = new ArrayList<>();
        Roomtypeordercheck r;
        while (tempDate.compareTo(endDate) < 0) {
            r = new Roomtypeordercheck();
            r.setRRoomtype(roomtype);
            r.setOptime(new java.sql.Date(tempDate.getTime()));
            tempDate.setTime(tempDate.getTime() + ADATE);
            list.add(r);
        }
        LogOut.Info("list", list.size() + "--" + list);
        int success = RoomtypeordercheckDao.insertDateOfTime(list);
        LogOut.Info("result", success);

        return success;
    }

    public static int UpdateRoomtypeOfOrdernum(int roomType, Date startDate, Date endDate) throws IOException{
        SqlSession session = getSqlSession.getSession().openSession();
        RoomtypeordercheckIFS roomtypeordercheckIFS = session.getMapper(RoomtypeordercheckIFS.class);

        int num = roomtypeordercheckIFS.updateRoomtypeOfOrderNum(roomType, startDate, endDate);

        session.commit();
        session.close();
        return num;
    }

}
