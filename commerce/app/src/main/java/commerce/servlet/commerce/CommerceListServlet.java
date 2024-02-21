package commerce.servlet.commerce;



import commerce.dao.CommerceDao;
import commerce.vo.Commerce;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jdt.internal.compiler.ast.Assignment;

@WebServlet("/commerce/list")
public class CommerceListServlet extends HttpServlet {

  private CommerceDao commerceDao;

  @Override
  public void init() {
    commerceDao = (CommerceDao) this.getServletContext().getAttribute("commerceDao");
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
    out.println("<h1>상품</h1>");

    out.println("<a href='/commerce/form.html'>새 상품</a>");

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>상품명</th> <th>가격</th> <th>구매자</th> <th>구매일</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<Commerce> list = commerceDao.findAll();

      for (Commerce commerce : list) {
        out.printf(
            "<tr> <td>%d</td> <td><a href='/commerce/view?no=%1$d'>%s</a></td><td>%d</td> <td>%s</td> <td>%s</td></tr>\n",
            commerce.getNo(),
            commerce.getTitle(),
            commerce.getPrice(),
            commerce.getName(),
            commerce.getCreatedDate());
      }

      out.println("    </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
