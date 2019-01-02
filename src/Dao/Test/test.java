package Dao.Test;

import Dao.Tools.LogOut;
import Dao.Tools.getSqlSession;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import Mapper.CustomerIFS;
import Bean.Customer;

import java.io.IOException;
import java.util.List;

public class test {

    @Test
    public void test02() throws IOException {
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);

        //调用userMapper的方法
        Customer customer = customerIFS.selectCustomerByID("145154199909093333");

        //打印
        System.out.println(customer);

        //插入
        /*customer.setC_ID("145154199909203598");
        customer.setC_phone("13846535684");
        System.out.println("插入：\n" + customer);

        int success = customerIFS.insertCustomer(customer);
        session.commit();*/

        //模糊查询
        List<Customer> list = customerIFS.selectCustomerByFuzzyName("涛");
        Logger.getRootLogger().info("模糊查询--" + list);

        //综合动态查询
        Customer customer1 = new Customer();
//        customer1.setCName(customer.getCName());
        customer1.setCSex(customer.getCSex());

        list = customerIFS.selectCustomerByMultiple(customer1);
        Logger.getRootLogger().info("综合动态查询--" + list);

        //关闭资源
        session.close();
        System.out.println("123123");
    }

    @Test
    public void testJson2obj() {
        String string = "{\"phone\":\"13846533359\",\"password\":\"123123\"}";
        JsonElement jsonElement = new JsonParser().parse(string);
        String phone = jsonElement.getAsJsonObject().get("phone").toString();
        String password = jsonElement.getAsJsonObject().get("password").toString();
        Logger.getRootLogger().info("phone:"+phone+"--pwd:"+password);
    }

    @Test
    public void testinsert() throws IOException {
        //准备数据
        Customer  customer = new Customer();
        customer.setCPhone("13888888888");
        customer.setCId("145154199909093333");
        int success=0,sum=0;

        //建立连接映射
        SqlSession session = getSqlSession.getSession().openSession();
        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);

        //计数
        sum = customerIFS.selectCustomerSumByIDPhone(customer);
        LogOut.Info("sum",sum);

        //插入
        if(sum==0){
            LogOut.Info("ready to insert customer !");
            success = customerIFS.insertCustomer(customer);
        }
        session.commit();

        //关闭
        session.close();

    }

    @Test
    public void tesstUpdate() throws IOException {
        //准备数据
        Customer  customer = new Customer();
        customer.setCPhone("15888888888");
        customer.setCId("145154199909093333");
        customer.setCSex("女");
        customer.setCName("litao");
        customer.setCPassword("456456");
        int success=0,sum=0;

        //建立连接映射
        SqlSession session = getSqlSession.getSession().openSession();
        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);

        //计数
        sum = customerIFS.updateCustomerByID(customer);
        LogOut.Info("sum",sum);

        session.commit();

        //关闭
        session.close();

    }
}
