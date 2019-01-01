package Dao;

import Dao.Tools.getSqlSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.ibatis.session.SqlSession;

import Bean.RoomType;
import Mapper.RoomTypeIFS;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class RoomTypeDao {
    private SqlSession session;
    private RoomTypeIFS roomTypeIFS;

    //插入一个房间类型
    @Test
    public int insertRoomType(RoomType roomType) throws IOException {
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roomTypeIFS = session.getMapper(RoomTypeIFS.class);
        int result = 0;
        result =  roomTypeIFS.insertRoomType(roomType);
        session.commit();
        session.close();
        return result;
    }

    /**
     *
     * @param offset 偏移量
     * @param typename 房间类型的名字
     * @return 符合条件的数据
     * @throws IOException
     */
    @Test
    public List<RoomType> selectAllRoomType(int offset, String typename) throws IOException {
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roomTypeIFS = session.getMapper(RoomTypeIFS.class);
        List<RoomType> roomTypeList = null;
        try {
           roomTypeList =  roomTypeIFS.selectAllRoomType(offset,typename);
        } catch (Exception e){
            System.out.println("选择房间类型出错-->selectAllRoomType-->RoomTypeDao");
            e.printStackTrace();
        }
        session.close();
        return roomTypeList;
    }

    // 删除某个房间类型
    public int DeleteRoomType(int R_typename)throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roomTypeIFS = session.getMapper(RoomTypeIFS.class);
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

    /**
     *
     * @param R_roomtype 房间类型编号
     * @return 根据房间类型编号获得的房间类型
     */
    public RoomType SelectRoomTypeByTB(int R_roomtype)throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roomTypeIFS = session.getMapper(RoomTypeIFS.class);
        RoomType roomType = null;
        try {
            roomType =  roomTypeIFS.SelectRoomTypeByTB(R_roomtype);
        } catch (Exception e){
            System.out.println("选择房间类型出错-->selectAllRoomType-->RoomTypeDao");
            e.printStackTrace();
        }
        session.close();
        return roomType;
    }

    /**
     *
     * @param roomType 需要更新的数据
     * @return 更新结果
     * @throws IOException
     */
    public int UpdateRoomType(RoomType roomType) throws IOException {
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roomTypeIFS = session.getMapper(RoomTypeIFS.class);
        int result = 0;
        result =  roomTypeIFS.UpdateRoomType(roomType);
        session.commit();
        session.close();
        return result;
    }

    public int GetTotalDatas(String typename) throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roomTypeIFS = session.getMapper(RoomTypeIFS.class);
        int total = 0;
        try {
            total =  roomTypeIFS.GetTotalDatas(typename);
        } catch (Exception e){
            System.out.println("选择房间类型总数-->selectAllRoomType-->RoomTypeDao");
           // e.printStackTrace();
        }
        session.close();
        return total;
    }

    public static void main(String[] args) {
        try {
            RoomTypeDao rtd = new RoomTypeDao();
            int i = rtd.GetTotalDatas("-1");
            System.out.println("sdfsdf" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
