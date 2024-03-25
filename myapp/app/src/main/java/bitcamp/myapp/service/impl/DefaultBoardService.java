package bitcamp.myapp.service.impl;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;

public class DefaultBoardService implements BoardService {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public DefaultBoardService(BoardDao boardDao, AttachedFileDao attachedFileDao) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  public void add(Board board) {
    boardDao.add(board);
    if (board.getFiles() != null) {
      for (AttachedFile attachedFile : board.getFiles()) {
        attachedFile.setBoardNo(board.getNo());
      }
      attachedFileDao.addAll(board.getFiles());
    }
  }
}
