package sample.mapper;

import java.io.IOException;
import java.util.List;

public interface CustomerIFS {
    public Customer selectCustomerByID(String id)throws IOException;

    public List<Customer> selectCustomerByFuzzyName(String name)throws IOException;

    public int insertCustomer(Customer customer)throws IOException;
}
