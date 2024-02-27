package commerce.dao;

import commerce.vo.AttachedFile;
import java.util.List;

public interface AttachedFileDao {

  void add(AttachedFile file);

  int addAll(List<AttachedFile> files);

  int delete(int no);

  int deleteAll(int productNo);

  List<AttachedFile> findAllByProductNo(int productNo);

  AttachedFile findByNo(int no);
}
