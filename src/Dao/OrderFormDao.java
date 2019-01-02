package Dao;

import Bean.Orderform;
import Mapper.OrderformIFS;
import org.apache.ibatis.session.SqlSession;
import Dao.Tools.getSqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OrderFormDao {

    //通过身份证号查询客户订单
    public static List<Map<String,Object>> selectOrderformByCID(int offset,String C_ID)throws IOException{

        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<Map<String,Object>> orderformlist = null;
        try{
            orderformlist = orderformIFS.selectOrderformByCID(offset,C_ID);
        }catch (IOException e){
            System.out.println("查询客户订单信息出错");
            e.printStackTrace();
        }
        //System.out.println(orderformlist);
        session.commit();
        session.close();
        return orderformlist;

    }

    //通过订单号查询某个客户订单
    public static Map<String,Object> selectOrderformByOnumber(String O_num)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        Map<String,Object> orderform = null;
        try{
            orderform = orderformIFS.selectOrderformByOnumber(O_num);
        }catch (IOException e){
            System.out.println("查询客户订单信息出错 - selectOrderformByOnumber");
            e.printStackTrace();
        }
        System.out.println(orderform);
        session.commit();
        session.close();
        return orderform;

    }

    public int GetTotalDatas(String C_ID) throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        int total = 0;
        try{
            total = orderformIFS.GetTotalDatas(C_ID);
        }catch (Exception e){
            System.out.println("选择房间类型总数-->OrderFormDao");
        }
        session.close();
        return total;
    }
    public static void main(String[] args) throws IOException{
        //OrderFormDao.selectOrderformByCID("145154199609093333");
        //OrderFormDao.selectOrderformByOnumber("001");
    }
}
