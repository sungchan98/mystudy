package commerce.servlet.commerce;

import commerce.dao.AttachedFileDao;
import commerce.dao.CommerceDao;
import commerce.vo.AttachedFile;
import commerce.vo.Commerce;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/commerce/view")
public class CommerceViewServlet extends HttpServlet {

  private CommerceDao commerceDao;
  private AttachedFileDao attachedFileDao;

  @Override
  public void init() {
    this.commerceDao = (CommerceDao) this.getServletContext().getAttribute("commerceDao");
    this.attachedFileDao = (AttachedFileDao) this.getServletContext()
        .getAttribute("attachedFileDao");
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

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Commerce commerce = commerceDao.findBy(no);
      if (commerce == null) {
        out.println("<p>번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      List<AttachedFile> files = attachedFileDao.findAllByCommerceNo(no);

      out.println("<form action='/commerce/update'>");
      out.println("<div>");
      out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", commerce.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("  카테고리: <input name='category' type='text' value='%s'>\n", commerce.getCategory());
      out.println("</div>");
      out.println("<div>");
      out.printf("  상품명: <input name='title' type='text' value='%s'>\n", commerce.getTitle());
      out.println("</div>");
      out.println("<div>");
      out.printf("  가격: <input name='price' type='text' value='%d'>\n", commerce.getPrice());
      out.println("</div>");
      out.println("<div>");
      out.printf("  구매자: <input readonly type='text' value='%s'>\n", commerce.getName());
      out.println("</div>");


        out.println("<div>");
        out.println("  첨부파일: <input multiple name='files' type='file'>");
        out.println("  <ul>");
        for (AttachedFile file : files) {
          out.printf("    <li>%s <a href='/commerce/file/delete?&no=%d'>삭제</a></li>\n",
              file.getFilePath(),
              file.getNo());
        }
        out.println("  </ul>");
        out.println("</div>");

      out.println("<div>");
      out.println("  <button>변경</button>");
      out.printf("  <a href='/commerce/delete?&no=%d'>[삭제]</a>\n", no);
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

