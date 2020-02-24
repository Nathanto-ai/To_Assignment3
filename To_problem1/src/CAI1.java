import java.util.*;
import java.security.SecureRandom;


public class CAI1 {

	public static void main(String[] args) {
//		calls quiz
		quiz();
	}
	
//	stores program logic
	public static void quiz() {
		
//		Initialize random variables
		int rand1, rand2, ans, check = 0;

//		Call random number generator
		rand1 = randGen();
		rand2 = randGen();
		
//		While loop so student can have repeated attempts
		while (check != 1) {
		
//			Call ask question
			askquestion(rand1, rand2);
			
//			read response of student
			ans = readResponse();
		
//			check if answer is correct
			check = isAnswerCorrect(ans, rand1, rand2);
		
			if(check == 1)
				displayCorrectResponse();
			else
				displayIncorrectResponse();
		}
		
	}
	
//	random number generator
	public static int randGen() {
		int min = 0, max = 9;
		SecureRandom rand = new SecureRandom();
		
//		initializes random number
		int randomNum = rand.nextInt((max - min) + 1) + min;
		
		return randomNum;
	}
	
	//	Asks question
	public static void askquestion(int rand1, int rand2){
		System.out.printf("How much is %d times %d\n", rand1, rand2);
		
	}
	
//	Reads student response
	public static int readResponse() {		
		int ans;
		
//		Initialize scanner
		Scanner res = new Scanner(System.in);	
		
//		get student response
		ans = res.nextInt();
		
		return ans;		
	}
	
//	Checks if answer is correct
	public static int isAnswerCorrect(int ans, int rand1, int rand2) {
		int correctAns;
		
//		find correct answer
		correctAns = rand1 * rand2;
		
//		return whether the answer is correct or not
		if (ans == correctAns)
			return 1;
		else
			return 0;
	}
	
//	Print correct answer response and exit program
	public static void displayCorrectResponse() {
		System.out.println("Very good!");
		
		System.exit(0);
	}
	
//	Print incorrect answer response and allow student to retry
	public static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");				
	}
		
}

