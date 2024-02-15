package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.util.Prompt;
import java.util.List;

public class BoardDeleteHandler extends AbstractMenuHandler {


  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardDeleteHandler(BoardDao boardDao, AttachedFileDao attachedFileDao) {

    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {

    try {
      int no = prompt.inputInt("번호? ");
      if (boardDao.delete(no) == 0) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
      } else {
        List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
        for (AttachedFile file : files) {
          if (prompt.input("  %s 삭제하시겠습니까? (y/N)", file.getFilePath()).equalsIgnoreCase("y")) {
            attachedFileDao.delete(file.getNo());
          }
        }
        prompt.println("삭제했습니다!");
      }


    } catch (Exception e) {
      prompt.println("삭제 오류!");
      e.printStackTrace();
    }
  }
}