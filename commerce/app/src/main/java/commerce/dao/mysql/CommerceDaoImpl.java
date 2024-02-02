package commerce.dao.mysql;

import commerce.dao.CommerceDao;
import commerce.dao.DaoException;
import commerce.vo.Commerce;
import java.sql.Connection;
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
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into commerces(title,price,name) values('%s','%s','%s')",
          commerce.getTitle(), commerce.getPrice(), commerce.getName()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from commerces where commerce_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Commerce> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from commerces");

      ArrayList<Commerce> list = new ArrayList<>();

      while (rs.next()) {
        Commerce commerce = new Commerce();
        commerce.setNo(rs.getInt("commerce_no"));
        commerce.setTitle(rs.getString("title"));
        commerce.setPrice(rs.getString("price"));
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
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from commerces where commerce_no=" + no);

      //ArrayList<Commerce> list = new ArrayList<>();

      if (rs.next()) {
        Commerce commerce = new Commerce();
        commerce.setNo(rs.getInt("commerce_no"));
        commerce.setTitle(rs.getString("title"));
        commerce.setPrice(rs.getString("price"));
        commerce.setName(rs.getString("name"));
        commerce.setCreatedDate(rs.getDate("created_date"));

        return commerce;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Commerce commerce) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update commerces set title='%s', price='%s', name='%s' where commerce_no=%d",
          commerce.getTitle(), commerce.getPrice(), commerce.getName(), commerce.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
