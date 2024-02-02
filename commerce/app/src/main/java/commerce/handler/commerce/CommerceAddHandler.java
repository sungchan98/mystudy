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
    commerce.setTitle(this.prompt.input("상품명? "));
    commerce.setPrice(this.prompt.inputInt("가격? "));
    commerce.setName(this.prompt.input("구매자? "));
    commerce.setCreatedDate(new Date());

    commerceDao.add(commerce);
  }
}
