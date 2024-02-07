package commerce.dao.mysql;

import commerce.dao.CommerceDao;
import commerce.dao.DaoException;
import commerce.vo.Commerce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommerceDaoImpl implements CommerceDao {


  Connection con;

  public CommerceDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Commerce commerce) {
    try(PreparedStatement pstmt = con.prepareStatement("insert into commerces(category,title,price,name) values(?,?,?,?)")) {

      pstmt.setString(1,commerce.getCategory());
      pstmt.setString(2,commerce.getTitle());
      pstmt.setInt(3,commerce.getPrice());
      pstmt.setString(4,commerce.getName());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try( PreparedStatement pstmt = con.prepareStatement(
        "delete from commerces where commerce_no=?")) {

      pstmt.setInt(1,no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Commerce> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select commerce_no, title, price, name, created_date from commerces");
        ResultSet rs = pstmt.executeQuery()){

      ArrayList<Commerce> list = new ArrayList<>();

      while (rs.next()) {
        Commerce commerce = new Commerce();
        commerce.setNo(rs.getInt("commerce_no"));
        commerce.setTitle(rs.getString("title"));
        commerce.setPrice(rs.getInt("price"));
        commerce.setName(rs.getString("name"));
        commerce.setCreatedDate(rs.getDate("created_date"));

        list.add(commerce);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Commerce findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select commerce_no, category, title, price, name, created_date from commerces where commerce_no=?")){

      pstmt.setInt(1,no);

      try(ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Commerce commerce = new Commerce();
          commerce.setNo(rs.getInt("commerce_no"));
          commerce.setCategory(rs.getString("category"));
          commerce.setTitle(rs.getString("title"));
          commerce.setPrice(rs.getInt("price"));
          commerce.setName(rs.getString("name"));
          commerce.setCreatedDate(rs.getDate("created_date"));

          return commerce;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Commerce commerce) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update commerces set category=? , title=?, price=?, name=? where commerce_no=?")) {

      pstmt.setString(1,commerce.getCategory());
      pstmt.setString(2,commerce.getTitle());
      pstmt.setInt(3,commerce.getPrice());
      pstmt.setString(4,commerce.getName());
      pstmt.setInt(5,commerce.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
