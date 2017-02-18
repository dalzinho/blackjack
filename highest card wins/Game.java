public class Game {

  String result;

  public Game(){
    result = "";
  }

  public String decide(int p1Score, int p2Score){
    if(p1Score > p2Score){
      result = "Player One wins!";
    }
    else if(p2Score > p1Score){
      result = "Player Two wins!";
    }
    else{
      result = "It's a Draw!";
    }

    return result;
  }
} 