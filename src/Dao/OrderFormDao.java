package Dao;

import Bean.Orderform;
import Mapper.OrderformIFS;
import org.apache.ibatis.session.SqlSession;
import Dao.Tools.getSqlSession;

import java.io.IOException;
import java.io.PrintWriter;
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

    //酒店管理人员查询所有已经预定的订单
    public List<Map<String,Object>> SelectAllAcceptedOrder(int offect)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<Map<String,Object>> orderformlist = null;
        try{
            orderformlist = orderformIFS.SelectAllAcceptedOrder(offect);
        }catch (IOException e){
            System.out.println("查询客户已预订订单信息出错");
            e.printStackTrace();
        }
        //System.out.println(orderformlist);
        session.commit();
        session.close();
        return orderformlist;
    }
    //所有已经预定订单的数量
    public int StaffGetTotalAcceptOrderNum()throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        int total = 0;
        try{
            total = orderformIFS.StaffGetTotalAcceptOrderNum();
        }catch (Exception e){
            System.out.println("客户可以取消的房间总数->GetTotalCancelDatas");
        }
        session.close();
        return total;
    }

    //酒店管理人员查询所有未经预定的订单
    public List<Map<String,Object>> SelectAllUnAcceptedOrder(int offect)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<Map<String,Object>> orderformlist = null;

        try{
            orderformlist = orderformIFS.SelectAllUnAcceptedOrder(offect);
        }catch (IOException e){
            System.out.println("查询客户未预订订单信息出错");
            e.printStackTrace();
        }
        //System.out.println("1111111111111111111111111111111111111111111111111111111111");
        //System.out.println("11111111"+orderformlist);
        session.commit();
        session.close();
        return orderformlist;
    }
    //所有未预定订单的数量
    public int StaffGetTotalUnAcceptOrderNum()throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        int total = 0;
        try{
            total = orderformIFS.StaffGetTotalUnAcceptOrderNum();
        }catch (Exception e){
            System.out.println("客户可以取消的房间总数->GetTotalCancelDatas");
        }
        session.commit();
        session.close();
        return total;
    }

    //接受新的订单
    public void AcceptOrder(String O_num)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        try{
             orderformIFS.AcceptOrder(O_num);
        }catch (Exception e){
            System.out.println("酒店管理人员接受预订->AcceptOrder");
        }
        session.commit();
        session.close();
    }

    //拒绝未接受预订订单
    public  int RejectionOfOrder(String O_num) throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        int index = 0;
        try{
            orderformIFS.RejectionOfOrderByNum(O_num);
            index = orderformIFS.RejectionOfOrderStatus(O_num);
        }catch (Exception e){
            System.out.println("拒绝订单-->OrderFormDao");
        }
        //提交
        session.commit();
        session.close();
         return index;
    }

    public static void main(String[] args){
        try{
            //OrderFormDao.selectOrderformByCID("145154199609093333");
            //new OrderFormDao().selectOrderformByOnumber("001");
            //OrderFormDao.CancelOrderByOnumber("100");
            //OrderFormDao.selectOrderCanCancelByCID(0,"145154199609093333");
            //new OrderFormDao().SelectAllAcceptedOrder();
            //new OrderFormDao().SelectAllAcceptedOrder(0);
            //System.out.println(new OrderFormDao().SelectAllUnAcceptedOrder(0));
            //new OrderFormDao().SelectAllUnAcceptedOrder(0);
            //System.out.println(new OrderFormDao().StaffGetTotalUnAcceptOrderNum());
            //new OrderFormDao().RejectionOfOrder("021");
            //new OrderFormDao().AcceptOrder("100");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
