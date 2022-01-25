package rockPaperScissors;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static final short TIE = 0, WIN = 1, DEAFEAT = 2, ERROR = -1;


	public static void main(String[] args) {
    	/* 	
    	 * The code here does two things:
    	 * It first creates a new RockPaperScissors -object with the
    	 * code `new RockPaperScissors()`. Then it calls the `run()`
    	 * method on the newly created object.
         */
        new RockPaperScissors().run();
    }
    
    
    Scanner sc = new Scanner(System.in);
    int roundCounter = 1;
    int humanScore = 0;
    int computerScore = 0;
    List<String> rpsChoices = Arrays.asList("rock", "paper", "scissors");


    public void run() {
        // TODO: Implement Rock Paper Scissors
        int rounds = 1;


        while (true) {

            System.out.println("Let's play round " + rounds);
            String playerChoice = readInput("Your choice (rock/paper/scissors)?");

            int chosenInteger = chooseRandom(rpsChoices.size());
            String computerChoice = rpsChoices.get(chosenInteger);

            short playerVictory = chooseWinner(computerChoice, playerChoice);

            String result = "";

            switch (playerVictory) {
                case TIE:
                    result = "It's a tie!";
                    break;
                case WIN:
                    result = "Player wins!";
                    humanScore++;
                    break;
                case DEAFEAT:
                    result = "Computer wins!";
                    computerScore++;
                    break;
                default:
                    result = String.format("I do not understand %s. Could you try again?", playerChoice);
            }
            //I do not understand cardboard. Could you try again?
            if (playerVictory != ERROR) {
                System.out.printf("Human chose %s, computer chose %s. ", playerChoice, computerChoice);
            }
            System.out.println(result);

            System.out.printf("Score: human %s, computer %s", humanScore, computerScore);

            System.out.println();

            String continueOrEnd = readInput("Do you wish to continue playing? (y/n)?");
            if (!continueOrEnd.equalsIgnoreCase("y")) {
                System.out.println("Bye bye :)");
                break;
            }
            rounds++;
        }
    }

    private static short chooseWinner(String computer, String player) {
        if (computer == null || player == null) return -1;

        if (computer.equals(player)) return 0;

        short won = -1;

        switch(player) {
            case "rock":
                won = computer.equals("paper") ? DEAFEAT : WIN;
                break;
            case "paper":
                won = computer.equals("scissors") ? DEAFEAT : WIN;
                break;
            case "scissors":
                won = computer.equals("rock") ? DEAFEAT : WIN;
                break;
        }
        return won;
    }


    private static int chooseRandom(int range) {

        Random r = new Random();

        return r.nextInt(range);
    }



    /**
     * Reads input from console with given prompt
     * @param prompt
     * @return string input answer from user
     */
    public String readInput(String prompt) {
        System.out.println(prompt);
        String userInput = sc.next();
        return userInput;
    }

}
