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
    public  List<Map<String,Object>> selectOrderformByCID(int offset,String C_ID)throws IOException{

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
    public  Map<String,Object> selectOrderformByOnumber(String O_num)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        Map<String,Object> orderform = null;
        try{
            orderform = orderformIFS.selectOrderformByOnumber(O_num);
            //System.out.println(orderform);
        }catch (IOException e){
            System.out.println("查询客户订单信息出错 - selectOrderformByOnumber");
            e.printStackTrace();
        }
        System.out.println(orderform);
        session.commit();
        session.close();
        return orderform;

    }

    //获取某个客户订单总数
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

    //通过身份证号查询客户可以取消的订单
    public  List<Map<String,Object>> selectOrderCanCancelByCID(int offset,String C_ID)throws IOException{

        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<Map<String,Object>> orderformlist = null;
        try{
            orderformlist = orderformIFS.selectOrderCanCancelByCID(offset,C_ID);
        }catch (IOException e){
            System.out.println("查询客户订单信息出错");
            e.printStackTrace();
        }
        System.out.println(orderformlist);
        session.commit();
        session.close();
        return orderformlist;

    }

    //获取某个客户订单总数
    public int GetTotalCancelDatas(String C_ID) throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        int total = 0;
        try{
            total = orderformIFS.GetTotalCancelDatas(C_ID);
        }catch (Exception e){
            System.out.println("客户可以取消的房间总数->GetTotalCancelDatas");
        }
        session.close();
        return total;
    }

    //取消订单
    public  void CancelOrderByOnumber(String O_num) throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        try{
            orderformIFS.CancleOrderByOnumberRTOC(O_num);
            orderformIFS.CancleOrderByOnumberOF(O_num);
        }catch (Exception e){
            System.out.println("取消订单-->OrderFormDao");
        }
        //提交
        session.commit();
        session.close();
       // return total;
    }

    public static void main(String[] args){
        try{
            //OrderFormDao.selectOrderformByCID("145154199609093333");
            //new OrderFormDao().selectOrderformByOnumber("001");
            //OrderFormDao.CancelOrderByOnumber("100");
            //OrderFormDao.selectOrderCanCancelByCID(0,"145154199609093333");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}