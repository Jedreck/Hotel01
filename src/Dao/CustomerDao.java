package Dao;

import Bean.Customer;
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
}
