package sample.mapper;


public class Customer {

  private String C_ID;
  private String C_phone;
  private String C_password;
  private String C_name;
  private String C_sex;

  public String getC_ID() {
    return C_ID;
  }

  public void setC_ID(String C_id) {
    C_ID = C_id;
  }

  public String getC_phone() {
    return C_phone;
  }

  public void setC_phone(String c_phone) {
    C_phone = c_phone;
  }

  public String getC_password() {
    return C_password;
  }

  public void setC_password(String c_password) {
    C_password = c_password;
  }

  public String getC_name() {
    return C_name;
  }

  public void setC_name(String c_name) {
    C_name = c_name;
  }

  public String getC_sex() {
    return C_sex;
  }

  public void setC_sex(String c_sex) {
    C_sex = c_sex;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "C_id='" + C_ID + '\'' +
            ", C_phone='" + C_phone + '\'' +
            ", C_password='" + C_password + '\'' +
            ", C_name='" + C_name + '\'' +
            ", C_sex='" + C_sex + '\'' +
            '}';
  }
}
