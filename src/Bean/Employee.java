package Bean;

public class Employee {
    private int E_status;
    private double E_salary;
    private String E_ID;
    private String E_sex;
    private String E_num;
    private String E_phone;
    private String E_name;
    private String E_password;
    private String E_position;
    private String E_address;
    private String E_hiredate;

    public int getE_status() {
        return E_status;
    }

    public void setE_status(int e_status) {
        E_status = e_status;
    }

    public double getE_salary() {
        return E_salary;
    }

    public void setE_salary(double e_salary) {
        E_salary = e_salary;
    }

    public String getE_ID() {
        return E_ID;
    }

    public void setE_ID(String e_ID) {
        E_ID = e_ID;
    }

    public String getE_sex() {
        return E_sex;
    }

    public void setE_sex(String e_sex) {
        E_sex = e_sex;
    }

    public String getE_num() {
        return E_num;
    }

    public void setE_num(String e_num) {
        E_num = e_num;
    }

    public String getE_phone() {
        return E_phone;
    }

    public void setE_phone(String e_phone) {
        E_phone = e_phone;
    }

    public String getE_name() {
        return E_name;
    }

    public void setE_name(String e_name) {
        E_name = e_name;
    }

    public String getE_password() {
        return E_password;
    }

    public void setE_password(String e_password) {
        E_password = e_password;
    }

    public String getE_position() {
        return E_position;
    }

    public void setE_position(String e_position) {
        E_position = e_position;
    }

    public String getE_address() {
        return E_address;
    }

    public void setE_address(String e_address) {
        E_address = e_address;
    }

    public String getE_hiredate() {
        return E_hiredate;
    }

    public void setE_hiredate(String e_hiredate) {
        E_hiredate = e_hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "E_status=" + E_status +
                ", E_salary=" + E_salary +
                ", E_ID='" + E_ID + '\'' +
                ", E_sex='" + E_sex + '\'' +
                ", E_num='" + E_num + '\'' +
                ", E_phone='" + E_phone + '\'' +
                ", E_name='" + E_name + '\'' +
                ", E_password='" + E_password + '\'' +
                ", E_position='" + E_position + '\'' +
                ", E_address='" + E_address + '\'' +
                ", E_hiredate='" + E_hiredate + '\'' +
                '}';
    }
}
