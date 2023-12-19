package bitcamp.menu;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler {

  protected Menu menu;
  protected Prompt prompt;

  public AbstractMenuHandler(Prompt prompt) {
    this.prompt = prompt;
  }


  @Override
  public void action(Menu menu) {
    this.printMenutitle(menu.getTitle());
    this.menu = menu;

    this.action();

  }

  private void printMenutitle(String title) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);
  }

  protected abstract void action();
}
