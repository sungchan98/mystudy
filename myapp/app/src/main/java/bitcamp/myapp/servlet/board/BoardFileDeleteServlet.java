package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/file/delete")
public class BoardFileDeleteServlet extends HttpServlet {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardFileDeleteServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.boardDao = new BoardDaoImpl(connectionPool, 1);
    this.attachedFileDao = new AttachedFileDaoImpl(connectionPool);
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
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<p>로그인하시기 바랍니다!</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    try {
      int fileNo = Integer.parseInt(request.getParameter("no"));

      AttachedFile file = attachedFileDao.findByNo(fileNo);
      if (file == null) {
        out.println("첨부파일 번호가 유효하지 않습니다.");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      Member writer = boardDao.findBy(file.getBoardNo()).getWriter();

      if (writer.getNo() != loginUser.getNo()) {
        out.println("<p>권한이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      attachedFileDao.delete(fileNo);

      out.println(" <script>");
      out.println("   location.href=.document.referrer;");
      //referrer는 이전 페이지의 주소를 가지고 있음, 이전페이지의 주소를 다시 줘서 웹브라우저는 그 주소에 다시 서버에 요청 하고 다시 받아온 결과를 출력함
      out.println(" </script>");
//      out.println("<p>첨부 파일을 삭제했습니다!</p>");

    } catch (Exception e) {
      out.println("<p>삭제 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
/*
[조회]
번호? 7
번호: 7
제목: a2
내용: aa2
작성자: a
작성일: 2024-02-14 00:00:00
첨부파일:
  a1.gif
  a2.gif
  a3.gif
 */