package Mapper;

import Bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface EmployeeIFS {
    public int GetTotalByPosition(String E_position) throws IOException;

    public int InsertEmployee(Employee employee)throws IOException;

    public List<Employee> SelectEmployeesByName(@Param(value="offset")int offset, @Param(value="name")String name)throws IOException;

    public Employee SelectEmployeeByEN(String E_num)throws IOException;

    public int GetTotalDatas(@Param(value="name") String name)throws IOException;

    public int UpdateEmployeeStatusByEN(@Param(value="E_num")String E_num, @Param(value="E_status")int E_status) throws IOException;

    public int UpdateEmployeeInfo(Employee employee) throws IOException;

    public List<Employee> SelectSOM(@Param(value="offset")int offset, @Param(value="name")String name)throws IOException;

    public int GetTotalSOMDatas(@Param(value="name") String name)throws IOException;

    public Employee Login(Employee employee)throws IOException;

    public List<Map<String,Object>> SelectEmployeeSexD() throws IOException;
}
