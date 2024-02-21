package commerce.dao;

import commerce.vo.AttachedFile;
import java.util.List;

public interface AttachedFileDao {

  void add(AttachedFile file);

  int addAll(List<AttachedFile> files);

  int delete(int no);

  int deleteAll(int commerceNo);

  List<AttachedFile> findAllByCommerceNo(int commerceNo);

  AttachedFile findByNo(int no);
}
