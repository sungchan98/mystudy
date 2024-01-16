package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoproxyGenerator;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.handler.HelpHandler;
import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentDeleteHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentModifyHandler;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardDeleteHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberDeleteHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberModifyHandler;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.util.Prompt;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);


  AssignmentDao assignmentDao;
  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao greetingDao;

  MenuGroup mainMenu;

  ClientApp() {
    prepareNetwork();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[과제관리 시스템]");
    new ClientApp().run();
  }

  void prepareNetwork() {

    try {
      // 1) 서버와 연결한 후 연결 정보 준비
      // => new Socket(서버주소, 포트번호)
      //    - 서버 주소: IP 주소, 도메인명
      //    - 포트 번호: 서버 포트 번호
      // => 로컬 컴퓨터를 가리키는 주소
      //    - IP 주소: 127.0.0.1
      //    - 도메인명: localhost

      // 네트워크 DAO 구현체 준비
      DaoproxyGenerator daoGenerator = new DaoproxyGenerator("localhost", 8888);
      boardDao = daoGenerator.create(BoardDao.class, "board");
      greetingDao = daoGenerator.create(BoardDao.class, "greeting");
      assignmentDao = daoGenerator.create(AssignmentDao.class, "assignment");
      memberDao = daoGenerator.create(MemberDao.class, "member");


    } catch (Exception e) {
      System.out.println("통신오류!");
      e.printStackTrace();
    }
  }


  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentDao, prompt));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentDao, prompt));
    assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentDao, prompt));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentDao, prompt));
    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentDao, prompt));

    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    boardMenu.addItem("등록", new BoardAddHandler(boardDao, prompt));
    boardMenu.addItem("조회", new BoardViewHandler(boardDao, prompt));
    boardMenu.addItem("변경", new BoardModifyHandler(boardDao, prompt));
    boardMenu.addItem("삭제", new BoardDeleteHandler(boardDao, prompt));
    boardMenu.addItem("목록", new BoardListHandler(boardDao, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberDao, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberDao, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberDao, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberDao, prompt));

    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(greetingDao, prompt));
    greetingMenu.addItem("조회", new BoardViewHandler(greetingDao, prompt));
    greetingMenu.addItem("변경", new BoardModifyHandler(greetingDao, prompt));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingDao, prompt));
    greetingMenu.addItem("목록", new BoardListHandler(greetingDao, prompt));

    mainMenu.addItem("도움말", new HelpHandler(prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
  }
}

