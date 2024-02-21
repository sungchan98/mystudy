package commerce.servlet.commerce;


import commerce.dao.AttachedFileDao;
import commerce.dao.CommerceDao;
import commerce.vo.AttachedFile;
import commerce.vo.Commerce;
import commerce.vo.Customer;
import commerce.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/commerce/update")
public class CommerceUpdateServlet extends HttpServlet {

  private TransactionManager txManager;
  private CommerceDao commerceDao;
  private AttachedFileDao attachedFileDao;

  @Override
  public void init() {
    txManager = (TransactionManager) this.getServletContext().getAttribute("txManager");
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
    out.println("<h1>상품/h1>");

    Customer loginUser = (Customer) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<p>로그인하시기 바랍니다!</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Commerce commerce = commerceDao.findBy(no);
      if (commerce == null) {
        out.println("<p>번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      } else if (commerce.getNo() != loginUser.getNo()) {
        out.println("<p>권한이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      commerce.setCategory(request.getParameter("category"));
      commerce.setTitle(request.getParameter("title"));

      ArrayList<AttachedFile> attachedFiles = new ArrayList<>();


        String[] files = request.getParameterValues("files");
        if (files != null) {
          for (String file : files) {
            if (file.length() == 0) {
              continue;
            }
            attachedFiles.add(new AttachedFile().filePath(file));
          }
        }


      txManager.startTransaction();

      commerceDao.update(commerce);

      if (attachedFiles.size() > 0) {
        for (AttachedFile attachedFile : attachedFiles) {
          attachedFile.setCommerceNo(commerce.getNo());
        }
        attachedFileDao.addAll(attachedFiles);
      }

      txManager.commit();

      out.println("<p>변경했습니다.</p>");

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      out.println("<p>등록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

