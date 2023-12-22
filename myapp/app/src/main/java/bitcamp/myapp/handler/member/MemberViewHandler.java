package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class MemberViewHandler extends AbstractMenuHandler {


  private ArrayList<Member> objectRepository;

  public MemberViewHandler(ArrayList<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;

  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    Member member = this.objectRepository.get(index);
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("가입일: %1tY-%1tm-%1td %1tH:%1tM:%1tS\n", member.getCreatedDate());
  }
}
