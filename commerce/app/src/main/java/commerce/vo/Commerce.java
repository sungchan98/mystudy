package commerce.vo;

import java.io.Serializable;
import java.util.Date;

public class Commerce implements Serializable {


  private static final long serialVersionUID = 100L;

  private int no;
  private String title;
  private int price;
  private String name;
  private Date createdDate;
  private String category;


  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  @Override
  public String toString() {
    return "Commerce{" +
        "category='" + category + '\'' +
        ", title='" + title + '\'' +
        ", price='" + price + '\'' +
        ", name='" + name + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }
  public String getCategory(){ return category; }
  public void setCategory(String category){ this.category = category;}
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
