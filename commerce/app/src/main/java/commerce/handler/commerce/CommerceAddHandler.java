package commerce.handler.commerce;

import commerce.menu.AbstractMenuHandler;
import commerce.dao.CommerceDao;
import commerce.vo.Commerce;
import commerce.util.Prompt;
import java.util.Date;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class CommerceAddHandler extends AbstractMenuHandler {

  private CommerceDao commerceDao;

  public CommerceAddHandler(CommerceDao commerceDao, Prompt prompt) {
    super(prompt);
    this.commerceDao = commerceDao;
  }

  @Override
  protected void action() {
    Commerce commerce = new Commerce();

      String category = this.prompt.input("카테고리(상의 or 하의 or 신발)? ");

      if (isValidCategory(category)) {
        commerce.setCategory(category);
      } else {
        System.out.println("상의 하의 신발 중 하나의 항목만 입력하세요.");
        return;
      }

    commerce.setTitle(this.prompt.input("상품명? "));
    commerce.setPrice(this.prompt.inputInt("가격? "));
    commerce.setName(this.prompt.input("구매자? "));
    commerce.setCreatedDate(new Date());

    commerceDao.add(commerce);
  }

  private boolean isValidCategory(String category) {
    return category.equals("상의") || category.equals("하의") || category.equals("신발");
  }
}
