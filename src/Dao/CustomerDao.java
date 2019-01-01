package Dao;

import Bean.Customer;
import Dao.Tools.LogOut;
import Dao.Tools.getSqlSession;
import Mapper.CustomerIFS;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class CustomerDao {

    public static Customer Login(Customer customer) throws IOException {
        //传入customer，检索phone与pwd后，返回customer
        SqlSession session = getSqlSession.getSession().openSession();
        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);
        return customerIFS.selectCustomerByIDPwd(customer);
    }

    public static int Register(Customer customer) throws IOException {
        //传入customer
        //检索phone或ID有没有重复的
        //返回0表示插入失败，1表示成功，2表示重复
        int success = 0;
        SqlSession session = getSqlSession.getSession().openSession();
        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);

        //计数
        int sum = customerIFS.selectCustomerSumByIDPhone(customer);
        LogOut.Info("查询结果", sum);

        //插入
        if (sum == 0) {
            LogOut.Info("ready to insert customer !");
            success = customerIFS.insertCustomer(customer);
            session.commit();
            return success;
        }
        session.close();
        return 2;

    }
}
