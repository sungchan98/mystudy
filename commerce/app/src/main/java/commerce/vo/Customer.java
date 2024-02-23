package commerce.vo;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

  private static final long serialVersionUID = 100L;

  private int customers_no;
  private String name;
  private String gender;
  private int age;
  private String address;
  private String email;

  private String phone_no;
  @Override
  public String toString() {
    return "Customer{" +
        "customers-no=" + customers_no +
        ", name='" + id + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
