package cards.output;

import org.apache.maven.shared.utils.StringUtils;

import java.util.Scanner;

public class StdOutPrinter implements CardsGui {

  private static final String BOX_TEXT_PREFIX = "| ";
  private static final String BOX_TEXT_SUFFIX = " |";

  @Override
  public void displayBold(String text) {
    String topAndBottom = getBoxLine(text.length());
    System.out.println(topAndBottom);
    System.out.println(emboldenText(text));
    System.out.println(topAndBottom);
  }

  private String emboldenText(String text) {
    return BOX_TEXT_PREFIX + text.toUpperCase() + BOX_TEXT_SUFFIX;
  }


  private String getBoxLine(int textLength) {
    int totalLength = textLength + BOX_TEXT_PREFIX.length() + BOX_TEXT_SUFFIX.length();
    return StringUtils.repeat("=", totalLength);
  }

  public void display(String text){
    System.out.println(text);
  }

  public char readCharFromCommandLine(){
    Scanner sc = new Scanner(System.in);
    String data = sc.nextLine();
    return data.charAt(0);
  }
}