package sample;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import sample.mapper.Customer;
import sample.mapper.CustomerIFS;
import sample.tools.getSqlSession;

import java.io.IOException;
import java.util.List;

public class test {

    //@Test
    //初始链接方法已经不用
    /*public void test01() throws IOException {
        System.out.println("test");

        //开启
        SqlSession session = getSqlSession.getSession().openSession();


        //根据ID查询
        Customer customer = session.selectOne("selectCustomerByID", "145154199909093333");
        System.out.println(customer);

        //插入
        *//*customer.setC_ID("145154199909093385");
        customer.setC_phone("13846535684");
        System.out.println("插入：\n" + customer);
        int success = session.insert("insertCustomer", customer);
        session.commit();
        System.out.println(success);*//*

        //模糊查询
        List<Customer> list = session.selectList("selectCustomerByFuzzyName", "涛");
        System.out.println(list);

        //关闭
        session.close();

    }*/

    @Test
    public void test02() throws IOException {
        //获取sqlSession对象
        SqlSession session = getSqlSession.getSession().openSession();

        //创建UserMapper对象，MyBatis自动生成mapper代理
        CustomerIFS customerIFS = session.getMapper(sample.mapper.CustomerIFS.class);

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
        Logger.getRootLogger().info("RESULT--"+list);

        //关闭资源
        session.close();
        System.out.println("123123");
    }
}
