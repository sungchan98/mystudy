package commerce.vo;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String id;
  private String name;
  private String password;
  private Date createdDate;

  @Override
  public String toString() {
    return "Customer{" +
        "no=" + no +
        ", id='" + id + '\'' +
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
