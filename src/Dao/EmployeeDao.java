package Dao;

import Bean.Employee;
import Dao.Tools.MyUtil;
import Dao.Tools.getSqlSession;
import Mapper.EmployeeIFS;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * 操作员工表
 */
public class EmployeeDao {
    private SqlSession session;
    private EmployeeIFS employeeIFS;

    /**
     * 用于生成员工号
     * @param E_position 职位
     * @return 该职位共有多少员工
     * @throws IOException
     */
    public int GetTotalByPosition(String E_position)throws IOException {
        session = getSqlSession.getSession().openSession();
        employeeIFS = session.getMapper(EmployeeIFS.class);
        int total = 0;
        try {
            total =  employeeIFS.GetTotalByPosition(E_position);
        } catch (Exception e){
            System.out.println("异常：选择相应职位员工总数-->GetTotalByPosition-->EmployeeDao");
            e.printStackTrace();
        }
        session.close();
        return total;
    }

    /**
     * 增加一个员工
     * @param employee 员工的信息
     * @return 插入结果
     * @throws IOException
     */
    public int InsertEmployee(Employee employee)throws IOException{
        session = getSqlSession.getSession().openSession();
        employeeIFS = session.getMapper(EmployeeIFS.class);
        // 自动生成员工号
        employee.setE_num(MyUtil.GenerateE_num(employee.getE_position()));
        int result = 0;
        System.out.println(employee.toString());
        result =  employeeIFS.InsertEmployee(employee);
        // 增加相应类型的房间数量
        session.commit();
        session.close();
        return result;
    }

    /**
     *
     * @param offset 偏移量
     * @param name 房间类型的名字
     * @return 符合条件的数据
     * @throws IOException
     */
    public List<Employee> SelectEmployeesByName(int offset, String name) throws IOException {
        session = getSqlSession.getSession().openSession();
        employeeIFS = session.getMapper(EmployeeIFS.class);
        List<Employee> roomTypeList = null;
        try {
            roomTypeList =  employeeIFS.SelectEmployeesByName(offset,name);
        } catch (Exception e){
            System.out.println("选择员工出错-->SelectEmployeesByName-->EmployeeDdao");
            e.printStackTrace();
        }
        session.close();
        return roomTypeList;
    }

    /**
     * 获取客户名为name的数据总数
     * @param name 员工名字
     * @return 数据总数
     * @throws IOException
     */
    public int GetTotalDatas(String name) throws IOException{
        session = getSqlSession.getSession().openSession();
        employeeIFS = session.getMapper(EmployeeIFS.class);
        int total = 0;
        try {
            total =  employeeIFS.GetTotalDatas(name);
        } catch (Exception e){
            System.out.println("异常：选择员工总数-->GetTotalDatas-->EmployeeDao");
            e.printStackTrace();
        }
        session.close();
        return total;
    }

    /**
     * 根据员工号选择相应的员工的信息
     * @param E_num 员工的工号
     * @return 符合条件的数据
     * @throws IOException
     */
    public Employee SelectEmployeeByEN(String E_num) throws IOException {
        session = getSqlSession.getSession().openSession();
        employeeIFS = session.getMapper(EmployeeIFS.class);
        Employee employee = null;
        try {
            employee =  employeeIFS.SelectEmployeeByEN(E_num);
        } catch (Exception e){
            System.out.println("异常:选择员工出错-->SelectEmployeeByEN-->EmployeeDao");
            e.printStackTrace();
        }
        session.close();
        return employee;
    }

    /**
     * 根据员工编号改变员工的在职状态，可用于删除
     * @param E_num 需要更新的员工的员工号
     *@param E_status 需要改变为的状态 1 在职；0 已离职
     * @return 更新结果
     * @throws IOException
     */
    public int UpdateEmployeeStatusByEN(String E_num, int E_status) throws IOException {
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        employeeIFS = session.getMapper(EmployeeIFS.class);
        int result = 0;
        result =  employeeIFS.UpdateEmployeeStatusByEN(E_num, E_status);
        session.commit();
        session.close();
        return result;
    }

    /**
     * 根据员工编号改变员工的信息
     * @param employee 需要更新的员工的信息
     * @return 更新结果
     * @throws IOException
     */
    public int UpdateEmployeeInfo(Employee employee) throws IOException {
        session = getSqlSession.getSession().openSession();
        employeeIFS = session.getMapper(EmployeeIFS.class);
        int result = 0;
        result =  employeeIFS.UpdateEmployeeInfo(employee);
        session.commit();
        session.close();
        return result;
    }

    /**
     * 用于超级管理员的管理
     * @param offset 偏移量
     * @param name 员工的名字
     * @return 符合条件的数据
     * @throws IOException
     */
    public List<Employee> SelectSOM(int offset, String name) throws IOException {
        session = getSqlSession.getSession().openSession();
        employeeIFS = session.getMapper(EmployeeIFS.class);
        List<Employee> roomTypeList = null;
        try {
            roomTypeList =  employeeIFS.SelectSOM(offset,name);
        } catch (Exception e){
            System.out.println("选择管理员或超级管理员出错-->SelectSOM-->EmployeeDdao");
            e.printStackTrace();
        }
        session.close();
        return roomTypeList;
    }

    /**
     * 用于超级管理员
     * 获取客户名为name的数据总数
     * @param name 员工名字
     * @return 数据总数
     * @throws IOException
     */
    public int GetTotalSOMDatas(String name) throws IOException{
        session = getSqlSession.getSession().openSession();
        employeeIFS = session.getMapper(EmployeeIFS.class);
        int total = 0;
        try {
            total =  employeeIFS.GetTotalSOMDatas(name);
        } catch (Exception e){
            System.out.println("异常：选择超级管理员和管理员总数-->GetTotalSOMDatas-->EmployeeDao");
            e.printStackTrace();
        }
        session.close();
        return total;
    }


    public static void main(String[] args) {
        try {
            EmployeeDao ed = new EmployeeDao();
            //System.out.println(ed.SelectEmployeesByName(0,""));
            //System.out.println("总数：" + ed.GetTotalDatas(""));

            System.out.println(ed.SelectSOM(0,""));
            System.out.println("总数：" + ed.GetTotalSOMDatas(""));

            //System.out.println("数据：" + ed.SelectEmployeeByEN("101001"));
            //System.out.println("更新：" + ed.UpdateEmployeeStatusByEN("101022", 0));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
