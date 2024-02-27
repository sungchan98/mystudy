package commerce.dao;

import commerce.vo.Order;
import commerce.vo.Product;
import java.util.List;

public interface OrderDao {
  public void add(Order order);

  public int delete(int no);

  public List<Order> findAll();

  public Order findBy(int no);

  public int update(Order order);
}
