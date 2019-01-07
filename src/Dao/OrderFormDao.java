package Dao;

import Bean.Customer;
import Bean.Orderform;
import Mapper.OrderformIFS;
import org.apache.ibatis.session.SqlSession;
import Dao.Tools.getSqlSession;
import org.apache.tools.ant.taskdefs.condition.Or;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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

    //!--办理入住-->

    //<!--网上预订入住-->
    //<!--查询可以入住的订单-->
    public List<Map<String,Object>>SelectOrderCanCheckIn(String C_phone)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<Map<String,Object>> orderformlist = null;
        try{
            orderformlist = orderformIFS.SelectOrderCanCheckIn(C_phone);
        }catch (IOException e){
            System.out.println("查询可以入住的订单出错--orderformdao");
            e.printStackTrace();
        }
        //System.out.println(orderformlist);
        session.commit();
        session.close();
        return orderformlist;
    }
    //查询某个类型可以入住的房间
    public List<Map<String,Object>>SelectRoomCanCheckIn(int offect,String O_num)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<Map<String,Object>> orderformlist = null;
        try{
            orderformlist = orderformIFS.SelectRoomCanCheckIn(offect,O_num);
        }catch (IOException e){
            System.out.println("查询可以入住的订单出错--orderformdao");
            e.printStackTrace();
        }
        //System.out.println(orderformlist);
        session.commit();
        session.close();
        return orderformlist;
    }

    //查询某个类型可以入住房间类型的总数
    public int SelectTotalRoomCanCheckInNum(String O_num)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        int total = 0;
        try{
            total = orderformIFS.SelectTotalRoomCanCheckInNum(O_num);
        }catch (Exception e){
            System.out.println("客户可以取消的房间总数->orderformdao");
        }
        session.commit();
        session.close();
        return total;
    }

    //通过身份证号查询客户订单
    public  int ChangeRoomstateForCheckIn(String O_num,String R_num)throws IOException{

        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        int total = 0;
        try{
            total = orderformIFS.ChangeRoomstateForCheckIn(O_num,R_num);
        }catch (IOException e){
            System.out.println("客户入住房间失败，orderformdao");
            e.printStackTrace();
        }
        //System.out.println(orderformlist);
        //System.out.println(total);
        session.commit();
        session.close();
        return total;
    }

    //查询主要的房间类型
    public List<String>SelectMainRtype()throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<String> src = null;
        try{
            src = orderformIFS.SelectMainRtype();
        }catch (IOException e){
            System.out.println("客户入住房间失败，orderformdao");
            e.printStackTrace();
        }
        //System.out.println(orderformlist);
        //System.out.println(total);
        session.commit();
        session.close();
        return src;
    }

    //查询主要的床类型
    public List<String>SelectMainBtype()throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<String> src = null;
        try{
            src = orderformIFS.SelectMainBtype();
        }catch (IOException e){
            System.out.println("客户入住房间失败，orderformdao");
            e.printStackTrace();
        }
        //System.out.println(orderformlist);
        //System.out.println(total);
        //System.out.println(src);
        session.commit();
        session.close();
        return src;
    }



    //员工查询某个类型可以入住的房间
    public List<Map<String,Object>>StaffSelectRoomCanCheckIn(int offect,String R_roomtype)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        List<Map<String,Object>> orderformlist = null;
        try{
            orderformlist = orderformIFS.StaffSelectRoomCanCheckIn(offect,R_roomtype);
        }catch (IOException e){
            System.out.println("查询可以入住的订单出错--orderformdao");
            e.printStackTrace();
        }
        System.out.println(orderformlist);
        session.commit();
        session.close();
        return orderformlist;
    }

    //员工查询某个类型可以入住房间类型的总数
    public int StaffSelectTotalRoomCanCheckInNum(String R_roomtype)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        int total = 0;
        try{
            total = orderformIFS.StaffSelectTotalRoomCanCheckInNum(R_roomtype);
        }catch (Exception e){
            System.out.println("客户可以取消的房间总数->orderformdao");
        }
        //System.out.println("StaffSelectTotalRoomCanCheckInNum -----------" + total);
        session.commit();
        session.close();
        return total;
    }


    //<!--办理入住成功进行的操作-->
    //    <!--将获取到的客户信息插入订单表密码默认为“000000”-->
    public void StaffInsertCustomerN(Customer customer)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        try{
            orderformIFS.StaffInsertCustomerN(customer);
        }catch (Exception e){
            System.out.println("获取到的客户信息插入订单->orderformdao");
        }
        //System.out.println("StaffSelectTotalRoomCanCheckInNum -----------" + total);
        session.commit();
        session.close();
    }
    //<!--生成新的订单-->
    public void StaffInsertOrderformN(Orderform orderform) throws  IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        try{
            orderformIFS.StaffInsertOrderformN(orderform);
        }catch (Exception e){
            System.out.println("前台添加员工->orderformdao");
        }
        session.commit();
        session.close();
    }

    //<!--利用R_num改变房间的duetime-->
    public void StaffChangeRoomstateForCheckIn(String R_num)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        try{
            orderformIFS.StaffChangeRoomstateForCheckIn(R_num);
        }catch (Exception e){
            System.out.println("前台添加员工->orderformdao");
        }
        session.commit();
        session.close();
    }

    //<!--占用房间-->
    public void StaffChangeRoomOrderForCheckIn(Orderform orderform)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        try{
            orderformIFS.StaffChangeRoomOrderForCheckIn(orderform);
        }catch (Exception e){
            System.out.println("占用房间->orderformdao");
        }
        session.commit();
        session.close();
    }

    //通过手机号查询某个客户订单
    public  Map<String,Object> StaffselectOrderformByCphone(String C_phone)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        Map<String,Object> orderform = null;
        try{
            orderform = orderformIFS.StaffselectOrderformByCphone(C_phone);
            //System.out.println(orderform);
        }catch (IOException e){
            System.out.println("查询客户订单信息出错 - orderformdao");
            e.printStackTrace();
        }
        //System.out.println(orderform);
        session.commit();
        session.close();
        return orderform;

    }

    //!--结算改变订单状态填入结束时间-->
    public void StaffCheckOut(String O_num)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);

        //调用userMapper的方法
        try{
            orderformIFS.StaffCheckOut(O_num);
        }catch (IOException e){
            System.out.println("改变订单状态填入结束时间出错- orderformdao");
            e.printStackTrace();
        }
        session.commit();
        session.close();
    }

    public String SelectCIDForCustomer(String C_phone)throws IOException{
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        //调用userMapper的方法
        String C_ID = "";
        try{
             C_ID = orderformIFS.SelectCIDForCustomer(C_phone);
            System.out.println(C_ID);
        }catch (IOException e){
            System.out.println("改变订单状态填入结束时间出错- orderformdao");
            e.printStackTrace();
        }
        session.commit();
        session.close();
        return C_ID;
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
            //new OrderFormDao().SelectOrderCanCheckIn("13695632587");
            //new OrderFormDao().SelectRoomCanCheckIn(0,"001");
            //new OrderFormDao().ChangeRoomstateForCheckIn("001","101");
            //new OrderFormDao().SelectMainBtype();
            //new OrderFormDao().StaffSelectRoomCanCheckIn(0,"25");
            //new OrderFormDao().StaffSelectTotalRoomCanCheckInNum("25");
            //new OrderFormDao().StaffSelectRoomCanCheckIn(0,"25");
            //new OrderFormDao().StaffselectOrderformByCphone("18222222222");
            new OrderFormDao().SelectCIDForCustomer("15888888888");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int insertForm(String O_num
            , Timestamp checkintime
            , Timestamp checkouttime
            , int R_type
            , String phone
            , double O_price
    )throws IOException{
        SqlSession session = getSqlSession.getSession().openSession();
        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
        int success = orderformIFS.insertOrder(O_num,checkintime.toString(),checkouttime.toString(),R_type,phone,O_price);
        session.commit();
        session.close();
        return success;
    };
}
