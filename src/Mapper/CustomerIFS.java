package Mapper;

import Bean.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerIFS {
    public Customer selectCustomerByID(String id)throws IOException;

//    public Customer selectCustomerByIDPwd(Customer customer)throws IOException;

    public List<Customer> selectCustomerByFuzzyName(String name)throws IOException;

    public int insertCustomer(Customer customer)throws IOException;

    public List<Customer> selectCustomerByMultiple(Customer customer)throws IOException;

    public int selectCustomerSumByIDPhone(Customer customer)throws IOException;

    public int updateCustomerByID(Customer customer)throws IOException;
}
