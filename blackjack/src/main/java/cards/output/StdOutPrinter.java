package cards.output;

import org.apache.maven.shared.utils.StringUtils;

import java.io.PrintStream;
import java.util.Scanner;

public class StdOutPrinter implements CardsGui {

  private static final String BOX_TEXT_PREFIX = "| ";
  private static final String BOX_TEXT_SUFFIX = " |";

  private PrintStream printStream;

  public StdOutPrinter(PrintStream printStream) {
    this.printStream = printStream;
  }

  @Override
  public void displayBold(String text) {
    String topAndBottom = getBoxLine(text.length());
    printStream.println(topAndBottom);
    printStream.println(emboldenText(text));
    printStream.println(topAndBottom);
  }

  private String emboldenText(String text) {
    return BOX_TEXT_PREFIX + text.toUpperCase() + BOX_TEXT_SUFFIX;
  }


  private String getBoxLine(int textLength) {
    int totalLength = textLength + BOX_TEXT_PREFIX.length() + BOX_TEXT_SUFFIX.length();
    return StringUtils.repeat("=", totalLength);
  }

  public void display(String text){
    printStream.println(text);
  }
}