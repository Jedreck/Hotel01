package Dao.Test;

import Bean.RoomType;
import Bean.Roomtypeordercheck;
import Dao.RoomtypeordercheckDao;
import Dao.Tools.LogOut;
import Dao.Tools.getSqlSession;
import Mapper.OrderformIFS;
import Mapper.RoomTypeIFS;
import Mapper.RoomtypeordercheckIFS;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import Mapper.CustomerIFS;
import Bean.Customer;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
    @Test
    public void testCheckMaxDate() throws IOException {
        long ADate = 1000*60*60*24;
        Date date = new Date();
        date.setTime(date.getTime()+ADate*60);
        int roomtype = 25;
        int su = RoomtypeordercheckDao.checkMaxDate(roomtype,date);
        LogOut.Info("su",su);
    }

//    @Test
//    public void getMaxDate() throws IOException, ParseException {
//        long ADATE = 1000 * 60 * 60 * 24;
//        int roomtype = 42;
//        Date nowDate = new Date();
//        Date endDate = new Date(nowDate.getTime() + (ADATE * 120));
//
//        Date startDate = RoomtypeordercheckDao.getMaxDateOfType(roomtype);
//        LogOut.Info("date", startDate);
//        Date tempDate;
//        List<Roomtypeordercheck> list = new ArrayList<>();
//        Roomtypeordercheck r;
//        int dateLenth = 0;
//        if (startDate == null) {
//            tempDate = nowDate;
//        } else {
//            tempDate = startDate;
//        }
////        dateLenth = (int) (endDate.getTime() - tempDate.getTime() / ADATE);
//        while (tempDate.compareTo(endDate) < 0) {
//            r = new Roomtypeordercheck();
//            r.setRRoomtype(roomtype);
//            r.setOptime(new java.sql.Date(tempDate.getTime()));
//            tempDate.setTime(tempDate.getTime() + ADATE);
//            list.add(r);
//        }
//        LogOut.Info("list", list.size()+"--"+list);
//        int success = RoomtypeordercheckDao.insertDateOfTime(list);
//        LogOut.Info("result",success);
//    }
//
//    @Test
//    public void compareDate() {
//        Date nowDate = new Date();
//        Date min = new Date(nowDate.getTime());
//        Date max = new Date(nowDate.getTime() + (1000 * 60 * 60 * 24));
//        LogOut.Info("min-max", min.compareTo(max));
//        LogOut.Info("min-max", max.compareTo(max));
//        LogOut.Info("min-max", max.compareTo(min));
//    }
//    @Test
//    public void testorder() throws IOException {
//        SqlSession session = getSqlSession.getSession().openSession();
//        OrderformIFS orderformIFS = session.getMapper(OrderformIFS.class);
//        int success = orderformIFS.insertOrder("15465456484852166",
//                new Timestamp(56).toString(),
//                new Timestamp(996).toString(),
//                25,
//                "15888888888",
//                800);
//        session.commit();
//        session.close();
//        System.out.println(success);
//    }

//    @Test
//    public void test02() throws IOException {
//        //获取sqlSession对象
//        SqlSession session = getSqlSession.getSession().openSession();
//
//        //创建UserMapper对象，MyBatis自动生成mapper代理
//        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);
//
//        //调用userMapper的方法
//        Customer customer = customerIFS.selectCustomerByID("145154199909093333");
//
//        //打印
//        System.out.println(customer);
//
//        //插入
//        /*customer.setC_ID("145154199909203598");
//        customer.setC_phone("13846535684");
//        System.out.println("插入：\n" + customer);
//
//        int success = customerIFS.insertCustomer(customer);
//        session.commit();*/
//
//        //模糊查询
//        List<Customer> list = customerIFS.selectCustomerByFuzzyName("涛");
//        Logger.getRootLogger().info("模糊查询--" + list);
//
//        //综合动态查询
//        Customer customer1 = new Customer();
////        customer1.setCName(customer.getCName());
//        customer1.setCSex(customer.getCSex());
//
//        list = customerIFS.selectCustomerByMultiple(customer1);
//        Logger.getRootLogger().info("综合动态查询--" + list);
//
//        //关闭资源
//        session.close();
//        System.out.println("123123");
//    }
//
//    @Test
//    public void testJson2obj() {
//        String string = "{\"phone\":\"13846533359\",\"password\":\"123123\"}";
//        JsonParser jp = new JsonParser();
//        //将json字符串转化成json对象
//        JsonObject jo = jp.parse(string).getAsJsonObject();
////        JsonElement jsonElement = new JsonParser().parse(string);
////        String phone = jsonElement.getAsJsonObject().get("phone").toString();
////        String password = jsonElement.getAsJsonObject().get("password").toString();
//        Logger.getRootLogger().info("phone:"+jo.get("phone").getAsString()+"--pwd:"+jo.get("password").getAsString());
//    }
//
//    @Test
//    public void testinsert() throws IOException {
//        //准备数据
//        Customer  customer = new Customer();
//        customer.setCPhone("13888888888");
//        customer.setCId("145154199909093333");
//        int success=0,sum=0;
//
//        //建立连接映射
//        SqlSession session = getSqlSession.getSession().openSession();
//        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);
//
//        //计数
//        sum = customerIFS.selectCustomerSumByIDPhone(customer);
//        LogOut.Info("sum",sum);
//
//        //插入
//        if(sum==0){
//            LogOut.Info("ready to insert customer !");
//            success = customerIFS.insertCustomer(customer);
//        }
//        session.commit();
//
//        //关闭
//        session.close();
//
//    }
//
//    @Test
//    public void tesstUpdate() throws IOException {
//        //准备数据
//        Customer  customer = new Customer();
//        customer.setCPhone("15888888888");
//        customer.setCId("145154199909093333");
//        customer.setCSex("女");
//        customer.setCName("litao");
//        customer.setCPassword("456456");
//        int success=0,sum=0;
//
//        //建立连接映射
//        SqlSession session = getSqlSession.getSession().openSession();
//        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);
//
//        //计数
//        sum = customerIFS.updateCustomerByID(customer);
//        LogOut.Info("sum",sum);
//
//        session.commit();
//
//        //关闭
//        session.close();
//
//    }

//    @Test
//    public void testBookRoom() throws IOException{
//        RoomType roomType = new RoomType();
//        roomType.setBedtype("标准床");
//        roomType.setPeople(2);
//
//        SqlSession session = getSqlSession.getSession().openSession();
//        RoomTypeIFS roomTypeIFS = session.getMapper(RoomTypeIFS.class);
//
//        List<RoomType> list = roomTypeIFS.selectRoomtypeForBookSearch(roomType);
//
//        LogOut.Info("result",list);
//
//        session.commit();
//        session.close();
//    }

//    @Test
//    public void testCheckTime() throws IOException, ParseException {
//        //日期操作
//        String strDate ="2019-01-03";
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyy-MM-dd");
//        Date utildate = simpleDateFormat.parse(strDate);
//        java.sql.Date startdate = new java.sql.Date(utildate.getTime());
//        String strDate2 ="2019-01-05";
//        utildate = simpleDateFormat.parse(strDate2);
//        java.sql.Date endtdate = new java.sql.Date(utildate.getTime());
//
//
//        SqlSession session=getSqlSession.getSession().openSession();
//        RoomtypeordercheckIFS roomtypeordercheckIFS = session.getMapper(RoomtypeordercheckIFS.class);
//
//        int num = roomtypeordercheckIFS.selectNowToFuture(25,startdate,endtdate);
//
//        session.commit();
//        session.close();
//
//        LogOut.Info("result",num);
//    }

//    @Test
//    public void testlist(){
//        List<String> list = new ArrayList<String>();
//        list.add("123");
//        list.add("456");
//        list.add("789");
//        LogOut.Info(list.toString());
//        for(String a:list){
//            if(a.equals("123")){
//                list.remove(a);
//            }
//        }
//        LogOut.Info(list.toString());
//    }
}
