package Bean;


public class Roomtypeordercheck {

  private java.sql.Date optime;
  private long R_roomtype;
  private long ordernum;


  public java.sql.Date getOptime() {
    return optime;
  }

  public void setOptime(java.sql.Date optime) {
    this.optime = optime;
  }


  public long getRRoomtype() {
    return R_roomtype;
  }

  public void setRRoomtype(long rRoomtype) {
    this.R_roomtype = rRoomtype;
  }


  public long getOrdernum() {
    return ordernum;
  }

  public void setOrdernum(long ordernum) {
    this.ordernum = ordernum;
  }

  @Override
  public String toString() {
    return "Roomtypeordercheck{" +
            "optime=" + optime +
            ", R_roomtype=" + R_roomtype +
            ", ordernum=" + ordernum +
            '}';
  }
}
