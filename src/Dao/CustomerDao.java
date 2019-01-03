package Dao;

import Bean.Customer;
import Dao.Tools.LogOut;
import Dao.Tools.getSqlSession;
import Mapper.CustomerIFS;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CustomerDao {
    private SqlSession session;
    private CustomerIFS customerIFS;
    /*public static Customer Login(Customer customer) throws IOException {
        //传入customer，检索phone与pwd后，返回customer
        SqlSession session = getSqlSession.getSession().openSession();
        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);
        return customerIFS.selectCustomerByIDPwd(customer);
    }*/

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

    public static Customer getProfile(Customer customer) throws IOException {
        //传入customer,含有部分信息
        //检查对应customer
        //传出customer

        SqlSession session = getSqlSession.getSession().openSession();
        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);

        List<Customer> list = customerIFS.selectCustomerByMultiple(customer);
        LogOut.Info("list num",list.size());

        session.close();
        return list.size()==0?null:list.get(0);
    }

    public static int ModifyInfo(Customer customer) throws IOException{
        SqlSession session = getSqlSession.getSession().openSession();
        CustomerIFS customerIFS = session.getMapper(CustomerIFS.class);

        int success = customerIFS.updateCustomerByID(customer);

        session.commit();
        session.close();
        return success;
    }

    /**
     *
     * @param offset 偏移量
     * @param name 房间类型的名字
     * @return 符合条件的数据
     * @throws IOException
     */
    public List<Customer> SelectCustomerByFuzzyName(int offset, String name) throws IOException {
        session = getSqlSession.getSession().openSession();
        customerIFS = session.getMapper(CustomerIFS.class);
        List<Customer> roomTypeList = null;
        try {
            roomTypeList =  customerIFS.SelectCustomerByFuzzyName(offset,name);
        } catch (Exception e){
            System.out.println("选择房间类型出错-->selectAllRoomType-->RoomTypeDao");
            e.printStackTrace();
        }
        session.close();
        return roomTypeList;
    }

    /**
     * 获取客户名为name的数据总数
     * @param name 客户名
     * @return 数据总数
     * @throws IOException
     */
    public int GetTotalDatas(String name) throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        customerIFS = session.getMapper(CustomerIFS.class);
        int total = 0;
        try {
            total =  customerIFS.GetTotalDatas(name);
        } catch (Exception e){
            System.out.println("异常：选择客户总数-->GetTotalDatas-->CustomerDao");
            // e.printStackTrace();
        }
        session.close();
        return total;
    }

    /**
     *
     * @param C_ID 客户的身份证
     * @return 符合条件的数据
     * @throws IOException
     */
    public Customer SelectCustomerByID(String C_ID) throws IOException {
        session = getSqlSession.getSession().openSession();
        customerIFS = session.getMapper(CustomerIFS.class);
        Customer customer = null;
        try {
            customer =  customerIFS.SelectCustomerByID(C_ID);
        } catch (Exception e){
            System.out.println("异常选择客户出错-->SelectCustomerByIDServlet-->CustomerDao");
            e.printStackTrace();
        }
        session.close();
        return customer;
    }

    public static void main(String[] args) {
        try {
            //测试1
//            CustomerDao cd = new CustomerDao();
//            System.out.println(cd.SelectCustomerByFuzzyName(0,"大").toString());
//            System.out.println("总数" + cd.GetTotalDatas("大"));

            //测试2
            CustomerDao cd = new CustomerDao();
            System.out.println(cd.SelectCustomerByID("145154199609093333").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
