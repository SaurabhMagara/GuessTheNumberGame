import java.util.Random;
import java.util.Scanner;

public class GameLoop {
    private final Scanner s = new Scanner(System.in);
    private int userChoice;

    private int getUserChoice() {
        return userChoice;
    }

    private void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    private final int computerChoice;
    GameLoop(){
        Random r = new Random();
        computerChoice = r.nextInt(100);
    }

    private int getComputerChoice() {
        return computerChoice;
    }

    protected void startGame(){
        GameLoop g = new GameLoop();
        System.out.print("""
                Welcome To Number Guessing Game!!
                1.You Have to Guess Number Between 1 to 100.
                2.You Cannot Exit game util you guessed the correct number.
                3.Enjoy Playing !!
                """);
        int choice;
        int tries = 0;
        while(true){
            if(tries <= 2) {
                System.out.println("Computers Choice is : " + g.getComputerChoice());
                System.out.println("Enter Your Choice :");
                choice = s.nextInt();
                g.setUserChoice(choice);
                if (g.getComputerChoice() < g.getUserChoice()) {
                    System.out.println("Guess Lower...");
                    ++tries;
                } else if (g.getUserChoice() < g.getComputerChoice()) {
                    System.out.println("Guess Higher...");
                    ++tries;
                } else if (g.getUserChoice() == g.getComputerChoice()) {
                    ++tries;
                    System.out.println("You Guessed The Correct Number!!\n" +
                            "You Guessed It in " + tries + " tries");
                    return;
                }
            }else{
                System.out.println("You Are Out Of Tries!!!");
                return;
            }
        }
    }
}
