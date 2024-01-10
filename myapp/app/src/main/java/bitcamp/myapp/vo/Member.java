package bitcamp.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

  private static final long serialVersionUID = 100L;

  private String email;
  private String name;
  private String password;
  private Date createdDate;

  public static Member createFromCsv(String csv) {
    String[] values = csv.split(","); // "aaa,aaaa,2023-01-01" ==> {"aaa","aaaa","2023-1-1"}
    Member obj = new Member();
    obj.setEmail(values[0]);
    obj.setName(values[1]);
    obj.setPassword(values[2]);
    obj.setCreatedDate(new Date(Long.valueOf(values[3])));
    return obj;
  }

  @Override
  public String toString() {
    return "Member{" +
        "email='" + email + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }

  //CSV 문자열을 가지고 객체에 저장하기
  //
//  public void setFromCsv(String csv) {
//    String[] values = csv.split(","); // "aaa,aaaa,2023-01-01" ==> {"aaa","aaaa","2023-1-1"}
//    Member obj = new Member();
//    this.Email(values[0]);
//    this.Name(values[1]);
//    this.obj.setPassword(values[2]);
//    obj.setCreatedDate(new Date(Long.valueOf(values[3])));
//    return obj;
//  }

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

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
