/**
 *
 * @author Perla Molina
 * @version 1.0
 * @since -February 14, 2020, 7:10pm-
 * WordMastermind.java
 *
 * This program allows a user to play Mastermind with the computer.
 * --EXPLAIN THE RULES--
 * 
 */
import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class WordMastermind
{
   //This is an array of Strings
   static String wordList[] = {"pink","soup","kpop", "ball", "love", "hero", "song", "cute", "sexy", "sock", "wing", "rose", "army", "stay", "days"};
   /**
    * Entry point of the program
    * @param args input arguments
    */
   public static void main(String[] args)
   {
      System.out.println("Welcome to Word Mastermind!");//The intro & rules
      System.out.println("\nGoal of the game: Try to guess the secret 4-letter word in 7 tries!");
      System.out.println("\nSome clues:" +
        "\nAn 'O' means you guessed the correct letter in the correct position." +
        "\nAn 'X' means you guessed the correct letter but in the wrong position.");
      
      Random randomWord = new Random(); //Selecting random word from list
      int w = randomWord.nextInt(wordList.length);
      String secret = wordList[w];
      StringBuilder currentResult = new StringBuilder(secret.length());
      
      System.out.println("The secret word is:");
      currentResult.append("----");
      System.out.println(currentResult);

      int numOfTries = 0;
      while (numOfTries < 7) {//start of 7 guesses while loop
        String currentGuess; //1st try or 1st round
        Scanner guessScan = new Scanner(System.in);
        System.out.println("Guess my word:");
        currentGuess = guessScan.nextLine();

        while (currentGuess.length() != 4) {//start of input validation while loop
          System.out.println("Please guess a 4-letter word: ");
          currentGuess = guessScan.nextLine();
        }//end of input validation while loop

        for (int c = 0; c < currentGuess.length(); c++) {//start of checking letters for loop
          char i = currentGuess.charAt(c);
          if (secret.indexOf(i) >= 0 && secret.indexOf(i) < 5) {//if statement checking if a letter is in secret word
            if (currentGuess.indexOf(i) == secret.indexOf(i)) {//if statement checking if a lettter is in the right position
              currentResult.setCharAt(currentGuess.indexOf(i),'O');
            }
            else {
              currentResult.setCharAt(c, 'X');
              //currentResult.setCharAt(secret.indexOf(i),'-');
            }
          }
          else {
            currentResult.setCharAt(c, '-');
          }
        }//end of checking letters for loop
        System.out.println(currentResult);
        numOfTries++;

        if (currentGuess.equals(secret)) {//if statement when player guesses secret word in less than 7 tries
          System.out.println("\nGood job! You guessed it right in "+ numOfTries + " tries!");
          break;
        }
        if (numOfTries == 7) {//if statement when player doesn't guess secret word in 7 tries
          System.out.println("Sorry, you did not guess the secret word in 7 tries." +
            "\nThe secret word was: " + secret);
        }
      }//end of 7 guesses while loop

      String playAgain; //ask to play again
      Scanner playScan = new Scanner(System.in);
      System.out.println("\nDo you want to play again?\n (Press 1 for Yes or Press 2 for No)");
      playAgain = playScan.nextLine();

      while (playAgain.length() > 1) {
        System.out.println("\nPlease Press 1 for Yes or Press 2 for No");
        playAgain = playScan.nextLine();
      }

      if (playAgain.contains("1")) {
        main(null);
      }
      else {
        System.out.println("\nThanks for playing!\nGood bye!");
      }
   }
}