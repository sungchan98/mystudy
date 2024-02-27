package commerce.dao;

import commerce.vo.Customer;
import commerce.vo.Product;
import java.util.List;

public interface ProductDao {
  public void add(Product product);

  public int delete(int no);

  public List<Product> findAll();

  public Product findBy(int no);

  public int update(Product product);
}
