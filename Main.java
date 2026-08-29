import java.util.Scanner;
import java.util.Random;

class GameLevel{
    String levelName;
    int[] numbers;
    int maxAttempts;

    public GameLevel(String levelName, int[] numbers, int maxAttempts){
        this.levelName = levelName;
        this.numbers = numbers;
        this.maxAttempts = maxAttempts;
    }
    //Comment here...
    public boolean containsNumber(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == target){
                return true;
        }
    }
    return false;
}
    public int pickRandomAnswer(){
        Random random = new Random();
        int randomIndex = random.nextInt(this.numbers.length);
        return this.numbers[randomIndex];
    }
}
public class Main {


    public void main(String[] arg) {

        Random random = new Random();

        //Bring out the scanner
        Scanner user = new Scanner(System.in);

        //Decision on easy or hard
        System.out.println("1 (Easy) or 2 (Hard)");
        int introQuestion = user.nextInt();


        //If Easy
        if (introQuestion == 1) {
            int attemptsEasy = 0;
            int[] numbersOfEasy = {7, 21, 36, 45, 50};
            GameLevel easyLevel = new GameLevel("Easy", numbersOfEasy, 3);
            int easyCorrectAnswer = easyLevel.pickRandomAnswer();

            while (attemptsEasy < 3){
                System.out.println("What is the answer out of 50? ");
                int userAnswer = user.nextInt();

                if (userAnswer == easyCorrectAnswer){
                    System.out.println("Correct! You Win!");
                    break;
                }
                else{
                    attemptsEasy++;
                    System.out.println("Wrong!! Attempts: " + (3 - attemptsEasy));
                }
            }
            if (attemptsEasy == 3){
                System.out.println("Game Over! The answer was: " + easyCorrectAnswer);
            }

        }

        //If Hard
        if (introQuestion == 2) {
            int attemptsHard = 0;
            int [] numbersOfHard = new int[50];
            for (int i = 0; i < numbersOfHard.length; i++){
                numbersOfHard[i] = random.nextInt(900) + 100;
            }

            GameLevel hardLevel = new GameLevel("Hard", numbersOfHard, 3);
            int answer = hardLevel.pickRandomAnswer();

            while (attemptsHard < 3) {
                System.out.println("What is the answer out of a lot?");
                int userAnswer = user.nextInt();

                if (userAnswer == answer){
                    System.out.println("Correct! You Win!");
                    break;
                }
                else{
                    attemptsHard++;
                    System.out.println("Wrong!! Attempts: " + (3 - attemptsHard));
                }
            }
            if (attemptsHard == 3){
                System.out.println("Game Over! The answer was: " + answer);
            }
        }

    }
}