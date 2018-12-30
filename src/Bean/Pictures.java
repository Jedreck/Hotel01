package Bean;


public class Pictures {

  private String P_ID;
  private long R_type;


  public String getPId() {
    return P_ID;
  }

  public void setPId(String pId) {
    this.P_ID = pId;
  }


  public long getRType() {
    return R_type;
  }

  public void setRType(long rType) {
    this.R_type = rType;
  }

  @Override
  public String toString() {
    return "Pictures{" +
            "P_ID='" + P_ID + '\'' +
            ", R_type=" + R_type +
            '}';
  }
}
