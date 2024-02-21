package commerce.dao;

import commerce.vo.Customer;
import java.util.List;

public interface CustomerDao {

  public void add(Customer customer);

  public int delete(int no);

  public List<Customer> findAll();

  public Customer findBy(int no);

  public int update(Customer customer);

  public Customer findByIdAndPassword(String id, String password);
}
