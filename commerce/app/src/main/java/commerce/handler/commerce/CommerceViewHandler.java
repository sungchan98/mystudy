package commerce.handler.commerce;

import commerce.menu.AbstractMenuHandler;
import commerce.dao.CommerceDao;
import commerce.util.Prompt;
import commerce.vo.Commerce;


// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class CommerceViewHandler extends AbstractMenuHandler {

  private CommerceDao commerceDao;

  public CommerceViewHandler(CommerceDao commerceDao, Prompt prompt) {
    super(prompt);
    this.commerceDao = commerceDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Commerce commerce = commerceDao.findBy(no);
    if (commerce == null) {
      System.out.println("상품 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("번호: %d\n", commerce.getNo());
    System.out.printf("상품명: %s\n", commerce.getTitle());
    System.out.printf("가격: %s\n", commerce.getPrice());
    System.out.printf("구매자: %s\n", commerce.getName());
   // System.out.printf("주문일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", commerce.getCreatedDate(),commerce.getCreatedDate());
    //System.out.printf("주문일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", commerce.getCreatedDate());
    System.out.printf("주문일: %1$tF %1$tT\n", commerce.getCreatedDate());
  }
}
