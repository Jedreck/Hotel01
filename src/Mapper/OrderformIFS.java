package Mapper;

import Bean.Orderform;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface OrderformIFS {
    //客户
    //通过身份证号查询客户订单
    public List<Map<String,Object>> selectOrderformByCID(@Param(value = "offset") int offset,@Param(value = "C_ID") String C_ID)throws IOException;

    //通过订单号查询某个客户订单
    public Map<String,Object> selectOrderformByOnumber(String O_num)throws IOException;

    //某个客户的订单总数
    public int GetTotalDatas(@Param(value = "C_ID") String C_ID) throws IOException;

    //取消订单,改变订单状态,解除预订的房间
    //解除房间预订
    public void CancleOrderByOnumberRTOC(@Param(value = "O_num")String O_num)throws IOException;
    //改变订单状态
    public void CancleOrderByOnumberOF(@Param(value = "O_num")String O_num)throws IOException;

    //通过身份证号查询客户可以取消的订单
    public List<Map<String,Object>> selectOrderCanCancelByCID(@Param(value = "offset") int offset,@Param(value = "C_ID") String C_ID)throws IOException;
    //某个客户可以取消的订单总数
    public int GetTotalCancelDatas(@Param(value = "C_ID")String C_ID) throws IOException;

    //酒店管理人员
    //查询所有已经预定的订单
    public List<Map<String,Object>> SelectAllAcceptedOrder(@Param(value = "offset") int offset)throws IOException;
    //查询所有已经预定的订单总数
    public int StaffGetTotalAcceptOrderNum()throws IOException;

    //查询所有未经预定的订单
    public List<Map<String,Object>> SelectAllUnAcceptedOrder(@Param(value = "offset") int offset)throws IOException;
    //查询所有未经预定的订单总数
    public int StaffGetTotalUnAcceptOrderNum()throws IOException;
    //接受未预定的订单
    public void AcceptOrder(@Param(value = "O_num")String O_num) throws IOException;

    //拒绝未接受的预订
    //解除房间的占用
    public void RejectionOfOrderByNum(@Param(value = "O_num")String O_num)throws IOException;
    //改变订单状态
    public int RejectionOfOrderStatus(@Param(value = "O_num")String O_num)throws IOException;

    //!--办理入住-->

    //<!--网上预订入住-->
    //<!--查询可以入住的订单-->
    public List<Map<String,Object>>SelectOrderCanCheckIn(@Param(value = "C_phone")String C_phone)throws IOException;
    //查询可以入住的房间
    public List<Map<String,Object>>SelectRoomCanCheckIn(@Param(value = "offset") int offset,@Param(value = "O_num")String  O_num)throws IOException;
    //<!--查询某个类型可以入住房间类型的总数-->
    public int SelectTotalRoomCanCheckInNum(@Param(value = "O_num")String O_num)throws IOException;

    //改变房间占用时间，订单状态，办理入住
    public int ChangeRoomstateForCheckIn(@Param(value = "O_num")String O_num,@Param(value = "R_num")String R_num)throws IOException;
}
