package commerce.vo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
  private static final long serialVersionUID = 100L;

  private int orderNo;
  private int orderQuantity;
  private int orderPrice;
  private String review;
  private Date orderDate;

  @Override
  public String toString() {
    return "Order{" +
        "orderNo='" + orderNo + '\'' +
        ", orderQuantity='" + orderQuantity + '\'' +
        ", orderPrice='" + orderPrice + '\'' +
        ", review='" + review + '\'' +
        ", orderDate=" + orderDate +
        '}';
  }

  public int getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(int orderNo) {
    this.orderNo = orderNo;
  }

  public int getOrderQuantity() {
    return orderQuantity;
  }

  public void setOrderQuantity(int orderQuantity) {
    this.orderQuantity = orderQuantity;
  }

  public int getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(int orderPrice) {
    this.orderPrice = orderPrice;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }
}
