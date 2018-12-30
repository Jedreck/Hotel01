package Bean;


public class Customer {

  private String C_ID;
  private String C_phone;
  private String C_password;
  private String C_name;
  private String C_sex;


  public String getCId() {
    return C_ID;
  }

  public void setCId(String cId) {
    this.C_ID = cId;
  }


  public String getCPhone() {
    return C_phone;
  }

  public void setCPhone(String cPhone) {
    this.C_phone = cPhone;
  }


  public String getCPassword() {
    return C_password;
  }

  public void setCPassword(String cPassword) {
    this.C_password = cPassword;
  }


  public String getCName() {
    return C_name;
  }

  public void setCName(String cName) {
    this.C_name = cName;
  }


  public String getCSex() {
    return C_sex;
  }

  public void setCSex(String cSex) {
    this.C_sex = cSex;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "C_ID='" + C_ID + '\'' +
            ", C_phone='" + C_phone + '\'' +
            ", C_password='" + C_password + '\'' +
            ", C_name='" + C_name + '\'' +
            ", C_sex='" + C_sex + '\'' +
            '}';
  }
}
