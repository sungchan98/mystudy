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
            "insert into customers(email,name,password,gender,address,phone_no) values(?,?,sha2(?,256),?,?,?)")) {
      pstmt.setString(1, customer.getEmail());
      pstmt.setString(2, customer.getName());
      pstmt.setString(3, customer.getPassword());
      pstmt.setString(4, customer.getGender());
      pstmt.setString(5, customer.getAddress());
      pstmt.setString(6, customer.getPhoneNo());
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
            "select customer_no, email, name, created_date from customers");
        ResultSet rs = pstmt.executeQuery();) {

      ArrayList<Customer> list = new ArrayList<>();

      while (rs.next()) {
        Customer customer = new Customer();
        customer.setCustomerNo(rs.getInt("customer_no"));
        customer.setEmail(rs.getString("email"));
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
            "select customer_no, email, name, gender, address, phone_no ,created_date from customers where customer_no=?")) {
      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Customer customer = new Customer();
          customer.setCustomerNo(rs.getInt("customer_no"));
          customer.setEmail(rs.getString("email"));
          customer.setName(rs.getString("name"));
          customer.setGender(rs.getString("gender"));
          customer.setAddress(rs.getString("address"));
          customer.setPhoneNo(rs.getString("phone_no"));
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
      sql = "update customers set email=?, name=?, gender=?, address=?, phone_no=? where customer_no=?";
    } else {
      sql = "update customers set email=?, name=?, password=sha2(?,256), gender=?, address=?, phone_no=?  where customer_no=?";
    }

    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setString(1, customer.getEmail());
      pstmt.setString(2, customer.getName());
      pstmt.setString(3, customer.getGender());
      pstmt.setString(5, customer.getAddress());
      pstmt.setString(6, customer.getPhoneNo());

      if(customer.getPassword().length() ==0){
        pstmt.setInt(6,customer.getCustomerNo());
      }else{
        pstmt.setString(3,customer.getPassword());
        pstmt.setInt(7,customer.getCustomerNo());
      }

      pstmt.setInt(7, customer.getCustomerNo());
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
