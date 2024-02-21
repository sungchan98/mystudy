package commerce.vo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
  private static final long serialVersionUID = 100L;

  private int no;
  private String title;
  private int price;
  private String name;
  private Date orderDate;
  private String category;
  private String review;
  private String name;
}
