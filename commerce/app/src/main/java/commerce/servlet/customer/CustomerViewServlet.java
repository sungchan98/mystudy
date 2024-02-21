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

@WebServlet("/customer/view")
public class CustomerViewServlet extends HttpServlet {

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

      Customer customer = customerDao.findBy(no);
      if (customer == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='/customer/update'>");
      out.println("<div>");
      out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", customer.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("  아이디: <input name='id' type='text' value='%s'>\n", customer.getId());
      out.println("</div>");
      out.println("<div>");
      out.printf("  이름: <input name='name' type='text' value='%s'>\n", customer.getName());
      out.println("</div>");
      out.println("<div>");
      out.println("  암호: <input name='password' type='password'>");
      out.println("</div>");
      out.println("<div>");
      out.printf("  가입일: <input readonly type='text' value='%s'>\n", customer.getCreatedDate());
      out.println("</div>");
      out.println("<div>");
      out.println("  <button>변경</button>");
      out.printf("  <a href='/customer/delete?no=%d'>[삭제]</a>\n", no);
      out.println("</div>");
      out.println("</form>");

    } catch (Exception e) {
      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
