package commerce.vo;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

  private static final long serialVersionUID = 100L;

  private int customerNo;
  private String email;
  private String name;
  private String password;
  private String gender;
  private String address;

  private String phoneNo;
private Date createdDate;

  @Override
  public String toString() {
    return "Customer{" +
        "customerNo=" + customerNo +
        ", email='" + email + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", gender='" + gender + '\'' +
        ", address='" + address + '\'' +
        ", phoneNo='" + phoneNo + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }

  public int getCustomerNo() {
    return customerNo;
  }

  public void setCustomerNo(int customerNo) {
    this.customerNo = customerNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
