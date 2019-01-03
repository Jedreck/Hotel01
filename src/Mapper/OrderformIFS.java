package Mapper;

import Bean.Orderform;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface OrderformIFS {
    //通过身份证号查询客户订单
    public List<Map<String,Object>> selectOrderformByCID(@Param(value = "offset") int offset,@Param(value = "C_ID") String C_ID)throws IOException;

    //通过订单号查询某个客户订单
    public Map<String,Object> selectOrderformByOnumber(String O_num)throws IOException;

    //某个客户的订单总数
    public int GetTotalDatas(@Param(value = "C_ID") String C_ID) throws IOException;
}
