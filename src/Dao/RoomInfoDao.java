package Dao;

import Bean.Roominfo;
import Dao.Tools.getSqlSession;
import Mapper.RoominfoIFS;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 操作房间表
 */
public class RoomInfoDao {
    private SqlSession session;
    private RoominfoIFS roominfoIFS;

    /**
     * 增加一个房间
     * @param roominfo 房间的信息
     * @param increment 增量
     * @return 插入结果
     * @throws IOException
     */
    public int InsertRoom(Roominfo roominfo,int increment)throws IOException{
        session = getSqlSession.getSession().openSession();
        roominfoIFS = session.getMapper(RoominfoIFS.class);
        int result = 0;
        result =  roominfoIFS.InsertRoom(roominfo);
        // 增加相应类型的房间数量
        session.commit();
        session.close();
        new RoomTypeDao().UpdateRoomNum(roominfo.getR_roomtype(),increment);
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
    public List<Map<String,Object>> SelectAllRooms(int offset, String typename) throws IOException {
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roominfoIFS = session.getMapper(RoominfoIFS.class);
        List<Map<String,Object>> roomTypeList = null;
        try {
            roomTypeList =  roominfoIFS.SelectAllRooms(offset,typename);
        } catch (Exception e){
            System.out.println("选择房间出错-->SelectAllRooms-->RoomInfoDao");
            e.printStackTrace();
        }
        session.close();
        return roomTypeList;
    }

    /**
     * 根据房间号删除房间类型
     * @param R_num
     * @return
     * @throws IOException
     */
    public int DeleteRoomByNum(String R_num)throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roominfoIFS = session.getMapper(RoominfoIFS.class);
        int result = 0;
        try {
            result =  roominfoIFS.DeleteRoomByNum(R_num);
            session.commit();
        } catch (Exception e){
            System.out.println("删除出错--DeleteRoom--RoomInfoDao");
            //e.printStackTrace();
        }
        session.close();
        return result;
    }

    /**
     * 根据房间号选择房间
     * @param R_num 房间类型编号
     * @return 根据房间类型编号获得的房间类型
     */
    public Roominfo SelectRoomByNum(String R_num)throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roominfoIFS = session.getMapper(RoominfoIFS.class);
        Roominfo roominfo = null;
        try {
            roominfo =  roominfoIFS.SelectRoomByNum(R_num);
        } catch (Exception e){
            System.out.println("选择房间出错-->SelectRoomByNum-->RoomInfoDao");
            e.printStackTrace();
        }
        session.close();
        return roominfo;
    }

    /**
     * 更新房间信息
     * @param roominfo 需要更新的数据
     * @return 更新结果
     * @throws IOException
     */
    public int UpdateRoom(Roominfo roominfo) throws IOException {
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        roominfoIFS = session.getMapper(RoominfoIFS.class);
        int result = 0;
        result =  roominfoIFS.UpdateRoom(roominfo);
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
        roominfoIFS = session.getMapper(RoominfoIFS.class);
        int total = 0;
        try {
            total =  roominfoIFS.GetTotalDatas(typename);
        } catch (Exception e){
            System.out.println("异常：选择房间类型总数-->GetTotalDatas-->RoomInfoDao");
            e.printStackTrace();
        }
        session.close();
        return total;
    }


    public static void main(String[] args) {
        try {
//            Roominfo roominfo = new Roominfo();
//            roominfo.setDuetime("1970-08-31");
//            roominfo.setR_floor(1);
//            roominfo.setR_num("101");
//            roominfo.setR_roomtype(25);
              List<Map<String,Object>> roomList = null;
              RoomInfoDao rid = new RoomInfoDao();
             // roomList = rid.SelectAllRooms(0,"");
              //System.out.println(roomList.toString() + "sdfsdfsdf");
              //System.out.println("jjjjj" + rid.GetTotalDatas("单人间"));
            //System.out.println(rid.SelectRoomByNum("101"));

            File file=new File("./web/img/myImage/25");
            if(!file.exists()){//如果文件夹不存在
                System.out.println(file.getAbsolutePath());
                file.mkdir();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
