package commerce.dao;

import commerce.vo.Commerce;
import java.util.List;

public interface CommerceDao {
  
  void add(Commerce commerce);

  int delete(int no);

  List<Commerce> findAll();

  Commerce findBy(int no);

  int update(Commerce commerce);

}