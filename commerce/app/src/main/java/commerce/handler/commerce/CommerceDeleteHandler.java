package commerce.handler.commerce;

import commerce.menu.AbstractMenuHandler;
import commerce.dao.CommerceDao;
import commerce.util.Prompt;


public class CommerceDeleteHandler extends AbstractMenuHandler {

  private CommerceDao commerceDao;

  public CommerceDeleteHandler(CommerceDao commerceDao, Prompt prompt) {
    super(prompt);
    this.commerceDao = commerceDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    if (commerceDao.delete(no) == 0) {
      System.out.println("상품 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
