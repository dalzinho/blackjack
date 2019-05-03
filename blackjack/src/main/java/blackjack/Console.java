package blackjack;
import java.util.Scanner;

public class Console {

  Scanner sc;

  public void display(String text){
    System.out.println(text);
  }

  public char twistOrStick(){
    sc = new Scanner(System.in);
    String data = sc.nextLine();
    return data.charAt(0);
  }
}