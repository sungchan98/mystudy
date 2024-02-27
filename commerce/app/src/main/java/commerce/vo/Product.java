package commerce.vo;

import java.io.Serializable;

public class Product implements Serializable {


  private static final long serialVersionUID = 100L;

  int productNo;
  String categoryName;
  String productName;
  int productPrice;
  int productQuantity; //상품수량
  int productSize;


  @Override
  public String toString() {
    return "Commerce{" +
        "productNo=" + productNo +
        ", categoryName='" + categoryName + '\'' +
        ", productName='" + productName + '\'' +
        ", productPrice=" + productPrice +
        ", productQuantity=" + productQuantity +
        ", productSize=" + productSize +
        '}';
  }

  public int getProductNo() {
    return productNo;
  }

  public void setProductNo(int productNo) {
    this.productNo = productNo;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(int productPrice) {
    this.productPrice = productPrice;
  }

  public int getProductQuantity() {
    return productQuantity;
  }

  public void setProductQuantity(int productQuantity) {
    this.productQuantity = productQuantity;
  }

  public int getProductSize() {
    return productSize;
  }

  public void setProductSize(int productSize) {
    this.productSize = productSize;
  }
}
