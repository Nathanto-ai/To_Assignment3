import java.util.*;
import java.security.SecureRandom;

public class CAI4 {

		public static void main(String[] args) {
//			calls quiz
			quiz();
		}
		
//		stores program logic
		public static void quiz() {
			
//			Initialize scanner
			Scanner rep = new Scanner(System.in);
			
//			Initialize variables
			int rand1 = 0, rand2 = 0, ans, check = 0, i, correctCounter = 0, repeat = 0, difficulty;
			
//			While loop so student can have repeated attempts
			while (repeat != 1) {
				
//				Call read difficulty to determine difficulty
				difficulty = readDifficulty();
			
//				for loop to limit questions to 10
				for (i = 0; i < 10; i++) {										
			
////					if statement to select which level random number generator is called
//					if (difficulty == 1) {
//						rand1 = randGen1();
//						rand2 = randGen1();		
//					}
//					else if (difficulty == 2) {
//						rand1 = randGen2();
//						rand2 = randGen2();		
//					}
//					else if (difficulty == 3) {
//						rand1 = randGen3();
//						rand2 = randGen3();		
//					}
//					else if (difficulty == 4) {
//						rand1 = randGen4();
//						rand2 = randGen4();		
//					}
					
					rand1 = generateQuestionArgument(difficulty);
					rand2 = generateQuestionArgument(difficulty);
					
//					Call ask question
					askquestion(rand1, rand2);
					
//		 			read response of student
					ans = readResponse();
				
//					check if answer is correct
					check = isAnswerCorrect(ans, rand1, rand2);
				
					if(check == 1) {
						displayCorrectResponse();
					
//						increase correctCounter
						correctCounter++;
					}
					else {
						displayIncorrectResponse();
					}
				}
				
//				Calls completion message
				displayCompletionMessage(correctCounter);
			
				System.out.println("Would you like to solve a new problem set? if so type 0 if not type 1.");
				repeat = rep.nextInt();
			}
			System.exit(0);
		}
		
//		Reads difficulty from student
		public static int readDifficulty() {
			
			Scanner ch = new Scanner(System.in);

			int choice, send = 0;
			
			System.out.println("Choose a difficulty level from 1 to 4");
			
			choice = ch.nextInt();
			
//			create switch case for determining difficulty level
			switch(choice) {
			
				case 1:
					send = 1;
					break;
					
				case 2:
					send = 2;
					break;
					
				case 3:
					send = 3;
					break;
				
				case 4:
					send = 4;
					break;
			}
				return send;
		}
		
		public static int generateQuestionArgument(int difficulty) {
			int rand = 0;
			
//			if statement to select which level random number generator is called
			if (difficulty == 1) {
				rand = randGen1();	
			}
			else if (difficulty == 2) {
				rand = randGen2();
			}
			else if (difficulty == 3) {
				rand = randGen3();		
			}
			else if (difficulty == 4) {
				rand = randGen4();
			}
			
			return rand;
				
		}
		
		
		
//		random number generator level 1
		public static int randGen1() {
			int min = 0, max = 9;
			SecureRandom rand = new SecureRandom();
			
//			initializes random number
			int randomNum = rand.nextInt((max - min) + 1) + min;
			
			return randomNum;
		}
		
//		random number generator level 2
		public static int randGen2() {
			int min = 0, max = 99;
			SecureRandom rand = new SecureRandom();
			
//			initializes random number
			int randomNum = rand.nextInt((max - min) + 1) + min;
			
			return randomNum;
		}
		
//		random number generator level 3
		public static int randGen3() {
			int min = 0, max = 999;
			SecureRandom rand = new SecureRandom();
			
//			initializes random number
			int randomNum = rand.nextInt((max - min) + 1) + min;
			
			return randomNum;
		}
		
//		random number generator level 4
		public static int randGen4() {
			int min = 0, max = 9999;
			SecureRandom rand = new SecureRandom();
			
//			initializes random number
			int randomNum = rand.nextInt((max - min) + 1) + min;
			
			return randomNum;
		}
		
//		random number generator for correct/incorrect ans
		public static int randGenAns() {
			int min = 1, max = 4;
			SecureRandom rand = new SecureRandom();
			
//			initializes random number
			int randomNum = rand.nextInt((max - min) + 1) + min;
			
			return randomNum;
		}
		
		//	Asks question
		public static void askquestion(int rand1, int rand2){
			System.out.printf("How much is %d times %d\n", rand1, rand2);	
		}
		
//		Reads student response
		public static int readResponse() {		
			int ans;
			
//			Initialize scanner
			Scanner res = new Scanner(System.in);	
			
//			get student response
			ans = res.nextInt();
			
			return ans;		
		}
		
//		Checks if answer is correct
		public static int isAnswerCorrect(int ans, int rand1, int rand2) {
			int correctAns;
			
//			find correct answer
			correctAns = rand1 * rand2;
			
//			return whether the answer is correct or not
			if (ans == correctAns)
				return 1;
			else
				return 0;
		}
		
//		Print correct answer response and exit program
		public static void displayCorrectResponse() {
			
//			random switch case for picking possible correct answer responses
			switch(randGenAns()) {
			
				case 1:
					System.out.println("Very good!");
					break;
				
				case 2:
					System.out.println("Excellent!");
					break;
				
				case 3:
					System.out.println("Nice Work!");
					break;				
				
				case 4:
					System.out.println("Keep up the good work!");
					break;
			}
			
		}
		
//		Print incorrect answer response and allow student to retry
		public static void displayIncorrectResponse() {
//			random switch case for picking possible incorrect answer responses
			switch(randGenAns()) {
			
				case 1:
					System.out.println("No. Please try again");
					break;
				
				case 2:
					System.out.println("Wrong. Try once more");
					break;
				
				case 3:
					System.out.println("Don't give up!");
					break;				
				
				case 4:
					System.out.println("No. Keep trying.");
					break;
			}
					
		}
		
//		Calculate and prints out appropriate score response
		public static void displayCompletionMessage(double numCorrect){
			double score;
			
//			calculate percentage
			score = numCorrect / 10;
					
			if (score > .75)
				System.out.println("Congratulations, you are ready to go to the next level!");
			else
				System.out.println("Please, ask your teacher for help.");		
			
		}
	}

