package commerce.handler.commerce;

import commerce.menu.AbstractMenuHandler;
import commerce.dao.CommerceDao;
import commerce.vo.Commerce;
import commerce.util.Prompt;
import java.util.List;

// 게시글의 '목록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class CommerceListHandler extends AbstractMenuHandler {

  private CommerceDao commerceDao;

  public CommerceListHandler(CommerceDao commerceDao, Prompt prompt) {
    super(prompt);
    this.commerceDao = commerceDao;
  }

  @Override
  protected void action() {

  //  System.out.printf("%-4s\t%-20s\t%10s\t%-15s\t%-19s\n", "번호", "상품명", "가격", "구매자", "구매일");
    System.out.printf("%-4s\t%-20s\t%10s\t%-15s\t%-19s\n", "번호", "상품명", "가격", "구매자", "구매일");

    List<Commerce> list = commerceDao.findAll();


    for (Commerce commerce : list) {
      System.out.printf("%-4d\t%-20s\t%10s\t%-15s\t%tY-%tm-%td\n",
          commerce.getNo(),
          commerce.getTitle(),
          commerce.getPrice(),
          commerce.getName(),
          commerce.getCreatedDate(),
          commerce.getCreatedDate(),
          commerce.getCreatedDate());
    }
  }
}