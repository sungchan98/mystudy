package commerce.servlet.customer;

import commerce.dao.CustomerDao;
import commerce.vo.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer/update")
public class CustomerUpdateServlet extends HttpServlet {

  private CustomerDao customerDao;

  @Override
  public void init() {
    this.customerDao = (CustomerDao) this.getServletContext().getAttribute("customerDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>쇼핑몰</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>고객</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Customer old = customerDao.findBy(no);
      if (old == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      Customer customer = new Customer();
      customer.setNo(old.getNo());
      customer.setId(request.getParameter("id"));
      customer.setName(request.getParameter("name"));
      customer.setPassword(request.getParameter("password"));
      customer.setCreatedDate(old.getCreatedDate());

      customerDao.update(customer);
      out.println("<p>고객을 변경했습니다.</p>");

    } catch (Exception e) {
      out.println("<p>고객 변경 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
