package Bean;


public class Roominfo {

  private String R_num;
  private long R_roomtype;
  private long R_floor;
  private java.sql.Date duetime;


  public String getRNum() {
    return R_num;
  }

  public void setRNum(String rNum) {
    this.R_num = rNum;
  }


  public long getRRoomtype() {
    return R_roomtype;
  }

  public void setRRoomtype(long rRoomtype) {
    this.R_roomtype = rRoomtype;
  }


  public long getRFloor() {
    return R_floor;
  }

  public void setRFloor(long rFloor) {
    this.R_floor = rFloor;
  }


  public java.sql.Date getDuetime() {
    return duetime;
  }

  public void setDuetime(java.sql.Date duetime) {
    this.duetime = duetime;
  }

  @Override
  public String toString() {
    return "Roominfo{" +
            "R_num='" + R_num + '\'' +
            ", R_roomtype=" + R_roomtype +
            ", R_floor=" + R_floor +
            ", duetime=" + duetime +
            '}';
  }
}
