package commerce.dao.mysql;

import commerce.dao.AttachedFileDao;
import commerce.dao.DaoException;
import commerce.vo.AttachedFile;
import commerce.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttachedFileDaoImpl implements AttachedFileDao {

  DBConnectionPool connectionPool;

  public AttachedFileDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(AttachedFile file) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into commerce_files(file_path,commerce_no) values(?,?)")) {

      pstmt.setString(1, file.getFilePath());
      pstmt.setInt(2, file.getCommerceNo());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int addAll(List<AttachedFile> files) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into commerce_files(file_path,commerce_no) values(?,?)")) {

      for (AttachedFile file : files) {
        pstmt.setString(1, file.getFilePath());
        pstmt.setInt(2, file.getCommerceNo());
        pstmt.executeUpdate();
      }

      return files.size();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "delete from commerce_files where file_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public int deleteAll(int commerceNo) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "delete from commerce_files where commerce_no=?")) {
      pstmt.setInt(1, commerceNo);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<AttachedFile> findAllByCommerceNo(int commerceNo) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select file_no, file_path, commerce_no"
                + " from commerce_files where commerce_no=? order by file_no asc")) {

      pstmt.setInt(1, commerceNo);

      try (ResultSet rs = pstmt.executeQuery()) {

        ArrayList<AttachedFile> list = new ArrayList<>();

        while (rs.next()) {
          AttachedFile file = new AttachedFile();
          file.setNo(rs.getInt("file_no"));
          file.setFilePath(rs.getString("file_path"));
          file.setCommerceNo(rs.getInt("commerce_no"));

          list.add(file);
        }
        return list;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public AttachedFile findByNo(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select file_no, file_path, commerce_no"
                + " from commerce_files where file_no=?")) {
      pstmt.setInt(1, no);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          AttachedFile file = new AttachedFile();
          file.setNo(rs.getInt("file_no"));
          file.setFilePath(rs.getString("file_path"));
          file.setCommerceNo(rs.getInt("commerce_no"));
          return file;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
