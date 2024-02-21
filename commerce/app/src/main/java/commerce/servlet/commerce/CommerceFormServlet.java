package commerce.servlet.commerce;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/commerce/form")
public class CommerceFormServlet extends HttpServlet {

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


    out.println("<div>");
    out.println("      제목: <input name='title' type='text'>");
    out.println("</div>");
    out.println("<div>");
    out.println("      내용: <textarea name='content'></textarea>");
    out.println("</div>");


    out.println("<div>");
    out.println("      첨부파일: <input multiple name='files' type='file'>");
    out.println("</div>");

    out.println("<div>");
    out.println("  <button>등록</button>");
    out.println("</div>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }
}
