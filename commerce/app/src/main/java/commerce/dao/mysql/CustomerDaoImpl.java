package commerce.dao.mysql;

import commerce.dao.DaoException;
import commerce.dao.CustomerDao;
import commerce.vo.Customer;
import commerce.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

  DBConnectionPool connectionPool;

  public CustomerDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(Customer customer) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into customers(id,name,password) values(?,?,sha2(?,256))")) {
      pstmt.setString(1, customer.getId());
      pstmt.setString(2, customer.getName());
      pstmt.setString(3, customer.getPassword());
      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "delete from customers where customer_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Customer> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select customer_no, id, name, created_date from customers");
        ResultSet rs = pstmt.executeQuery();) {

      ArrayList<Customer> list = new ArrayList<>();

      while (rs.next()) {
        Customer customer = new Customer();
        customer.setNo(rs.getInt("customer_no"));
        customer.setId(rs.getString("id"));
        customer.setName(rs.getString("name"));
        customer.setCreatedDate(rs.getDate("created_date"));

        list.add(customer);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Customer findBy(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select customer_no, id, name, created_date from customers where customer_no=?")) {
      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Customer customer = new Customer();
          customer.setNo(rs.getInt("customer_no"));
          customer.setId(rs.getString("id"));
          customer.setName(rs.getString("name"));
          customer.setCreatedDate(rs.getDate("created_date"));
          return customer;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Customer customer) {
    String sql = null;
    if (customer.getPassword().length() == 0) {
      sql = "update customers set id=?, name=? where customer_no=?";
    } else {
      sql = "update customers set id=?, name=?, password=sha2(?,256) where customer_no=?";
    }

    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setString(1, customer.getId());
      pstmt.setString(2, customer.getName());
      pstmt.setString(3, customer.getPassword());
      pstmt.setInt(4, customer.getNo());
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }

  @Override
  public Customer findByIdAndPassword(String id, String password) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select customer_no, id, name, created_date from customers where id=? and password=sha2(?,256)")) {
      pstmt.setString(1, id);
      pstmt.setString(2, password);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Customer customer = new Customer();
          customer.setNo(rs.getInt("customer_no"));
          customer.setId(rs.getString("id"));
          customer.setName(rs.getString("name"));
          customer.setCreatedDate(rs.getDate("created_date"));
          return customer;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
