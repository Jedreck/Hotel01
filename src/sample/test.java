package sample;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import sample.mapper.Customer;
import sample.tools.getSqlSession;

import java.io.IOException;
import java.util.List;

public class test {

    @Test
    public void test01() throws IOException {
        System.out.println("test");

        //开启
        SqlSession session = getSqlSession.getSession();


        //根据ID查询
        Customer customer = session.selectOne("selectCustomerByID", "145154199909093333");
        System.out.println(customer);

        //插入
        /*customer.setC_ID("145154199909093385");
        customer.setC_phone("13846535684");
        System.out.println("插入：\n" + customer);
        int success = session.insert("insertCustomer", customer);
        session.commit();
        System.out.println(success);*/

        //模糊查询
        List<Customer> list = session.selectList("selectCustomerByFuzzyName","涛");
        System.out.println(list);

        //关闭
        session.close();

    }
}
