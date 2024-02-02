package commerce.handler.commerce;

import commerce.menu.AbstractMenuHandler;
import commerce.dao.CommerceDao;
import commerce.util.Prompt;
import commerce.vo.Commerce;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class CommerceModifyHandler extends AbstractMenuHandler {

  private CommerceDao commerceDao;

  public CommerceModifyHandler(CommerceDao commerceDao, Prompt prompt) {
    super(prompt);
    this.commerceDao = commerceDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Commerce oldCommerce = commerceDao.findBy(no);

    if (oldCommerce == null) {
      System.out.println("상품 번호가 유효하지 않습니다.");
      return;
    }

    Commerce commerce = new Commerce();
    commerce.setNo(oldCommerce.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    commerce.setTitle(this.prompt.input("상품명(%s)? ", oldCommerce.getTitle()));
    commerce.setPrice(this.prompt.input("가격(%s)? ", oldCommerce.getPrice()));
    commerce.setName(this.prompt.input("구매자(%s)? ", oldCommerce.getName()));
    commerce.setCreatedDate(oldCommerce.getCreatedDate());

    commerceDao.update(commerce);
    System.out.println("상품을 변경했습니다");

  }
}
