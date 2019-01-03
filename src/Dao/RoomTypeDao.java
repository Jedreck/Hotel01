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
import java.util.Map;


public class RoomTypeDao {
    private SqlSession session;
    private RoomTypeIFS roomTypeIFS;

    /**
     * 插入一个房间类型
     * @param roomType
     * @return
     * @throws IOException
     */
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

    /**
     * 根据房间类型名删除房间类型
     * @param R_typename
     * @return
     * @throws IOException
     */
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
     * 根据房间类型编号选择房间类型
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
     * 更新房间类型信息
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

    /**
     * 获取类型名为typename的数据总数
     * @param typename 类型名
     * @return 数据总数
     * @throws IOException
     */
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

    /**
     * 选择所有的房间类型名称
     * @return 类型名List
     * @throws IOException
     */
    public List<Map<String,Object>> SelectTN()throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roomTypeIFS = session.getMapper(RoomTypeIFS.class);
        return roomTypeIFS.SelectTN();
    }


    /**
     * 当增加一个房间或删除一个房间时 改变roomnum的值
     * @param R_roomtype 房间类型编号
     * @param increment 增量，当为负数则减小；反之增加
     * @throws IOException
     */
    public void UpdateRoomNum(int R_roomtype, int increment)throws IOException{
        session = getSqlSession.getSession().openSession();
        roomTypeIFS = session.getMapper(RoomTypeIFS.class);
        roomTypeIFS.UpdateRoomNum(R_roomtype,increment);
        session.commit();
        session.close();
    }

    public static void main(String[] args) {
        try {
            RoomTypeDao rtd = new RoomTypeDao();
            System.out.println(rtd.SelectTN().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
