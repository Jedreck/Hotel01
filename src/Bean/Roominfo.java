package Bean;


public class Roominfo {

  private String R_num;
  private int R_roomtype;
  private int R_floor;
  private String duetime;

  public String getR_num() {
    return R_num;
  }

  public void setR_num(String r_num) {
    R_num = r_num;
  }

  public int getR_roomtype() {
    return R_roomtype;
  }

  public void setR_roomtype(int r_roomtype) {
    R_roomtype = r_roomtype;
  }

  public int getR_floor() {
    return R_floor;
  }

  public void setR_floor(int r_floor) {
    R_floor = r_floor;
  }

  public String getDuetime() {
    return duetime;
  }

  public void setDuetime(String duetime) {
    this.duetime = duetime;
  }

  @Override
  public String toString() {
    return "Roominfo{" +
            "R_num='" + R_num + '\'' +
            ", R_roomtype=" + R_roomtype +
            ", R_floor=" + R_floor +
            ", duetime='" + duetime + '\'' +
            '}';
  }
}
