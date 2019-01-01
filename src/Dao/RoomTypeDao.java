package Dao;

import Dao.Tools.getSqlSession;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import Bean.RoomType;
import Mapper.RoomTypeIFS;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class RoomTypeDao {

    //插入一个房间类型
    @Test
    public int insertRoomType(RoomType roomType) throws IOException {
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        RoomTypeIFS roomTypeIFS = session.getMapper(RoomTypeIFS.class);

        //调用userMapper的方法
        int result = 0;
        result =  roomTypeIFS.insertRoomType(roomType);
        session.commit();
        session.close();
        return result;
    }

    // 选择某页的所有房间类型
    @Test
    public List<RoomType> selectAllRoomType(int offset) throws IOException {
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        RoomTypeIFS roomTypeIFS = session.getMapper(RoomTypeIFS.class);
        List<RoomType> roomTypeList = null;
        try {
           roomTypeList =  roomTypeIFS.selectAllRoomType(offset);
        } catch (Exception e){
            System.out.println("选择房间出错-->selectAllRoomType-->RoomTypeDao");
            e.printStackTrace();
        }
        session.close();
        return roomTypeList;
    }

    // 删除某个房间类型
    public int DeleteRoomType(int R_typename)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        RoomTypeIFS roomTypeIFS = session.getMapper(RoomTypeIFS.class);

        //调用userMapper的方法
        int result = 0;
        try {
            result =  roomTypeIFS.deleteRoomType(R_typename);
            session.commit();
        } catch (Exception e){
            System.out.println("删除出错--DeleteRoomType--RoomTypeDao");
            //e.printStackTrace();
        }
        session.close();
        return result;
    }

    public static void main(String[] args) {
        try {
            RoomTypeDao rtd = new RoomTypeDao();
            List<RoomType> list = rtd.selectAllRoomType(0);
            System.out.println(new Gson().toJson(list).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
