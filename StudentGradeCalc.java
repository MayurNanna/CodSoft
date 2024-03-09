	import java.util.Scanner;

	public class StudentGradeCalc {
		static Scanner scr = new Scanner(System.in);
		
		static {
			System.out.println("\n**Student Grade Calculator**");
		}
		
		public static void main(String[] args) {
			streamChoice();
		}

		static void streamChoice() {
			System.out.println("\nPlease Enter your stream."
							+"\nEnter 1 for PCM (Physics, Chemistry, Mathematics)"
							+"\nEnter 2 for PCB (Physics, Chemistry, Biology)"
							+"\nEnter 3 for PCMB (Physics, Chemistry, Mathematics, Biology)"
							+"\nEnter 4 to exit.");
			System.out.print("Enter your stream: ");
			int stream = scr.nextInt();
				switch(stream) {
				case 1:
					System.out.println("\n**PCM Stream**");
					pCM();
					break;
				case 2:
					System.out.println("\n**PCB Stream**");
					pCB();
					break;
				case 3:
					System.out.println("\n**PCMB Stream**");
					pCMB();
					break;
				case 4:
					break;
				default:
					System.out.println("\nPlease enter valid stream");
					break;
			}
		}

		static void pCM() {
			int p1 = getValidMarks("Physics");
			int c1 = getValidMarks("Chemistry");
			int m1 = getValidMarks("Mathematics");

			int sum = p1 + c1 + m1;
			double avg = (double)sum / 3;
			String grade = getGrades(avg);
			System.out.println("\nYour total score is: "+sum+"/300\nAnd you average percenteage is: "+avg+"%\nAnd your grade is: "+grade+".");
			exitOrReturn();
		}

		static void pCB() {
			int p2 = getValidMarks("Physics");
			int c2 = getValidMarks("Chemistry");
			int b1 = getValidMarks("Biology");

			int sum = p2 + c2 + b1;
			double avg = (double)sum / 3;
			String grade = getGrades(avg);
			System.out.println("\nYour total score is: "+sum+"/300\nAnd you average percenteage is: "+avg+"%\nAnd your grade is: "+grade+".");
			exitOrReturn();
		}

		static void pCMB() {
			int p2 = getValidMarks("Physics");
			int c2 = getValidMarks("Chemistry");
			int m2 = getValidMarks("Mathematics");
			int b2 = getValidMarks("Biology");

			int sum = p2 + c2 + m2 + b2;
			double avg = (double)sum / 4;
			String grade = getGrades(avg);
			System.out.println("\nYour total score is: "+sum+"/400\nAnd you average percentage is: "+avg+"%\nAnd your grade is: "+grade+".");
			exitOrReturn();
		}

		static int getValidMarks(String subject) {
			int marks;
			do {
				System.out.print("Please Enter Your " + subject + " marks out of 100: ");
				marks = scr.nextInt();
				if (marks < 0 || marks > 100) {
					System.out.println("\nInvalid marks! Marks should be between 0 and 100.");
				}
			} while (marks < 0 || marks > 100);
			return marks;
		}

		static String getGrades(double avg) {
			if (avg >= 90) {
				return "A+";
			} else if (avg >= 80) {
				return "A";
			} else if (avg >= 70) {
				return "B";
			} else if (avg >= 60) {
				return "C";
			} else if (avg >= 50) {
				return "D";
			} else {
				return "F";
			}
		}

		static void exitOrReturn() {
			System.out.print("\nEnter 1 for main menu.\nEnter 2 to quit.\nEnter your choice: ");
			int out = scr.nextInt();
			switch (out) {
				case 1:
					streamChoice();
					break;
				case 2:
					System.out.println("\nExiting...");
					break;
				default:
					System.out.println("Please enter valid option.");
					exitOrReturn();
			}
		}
	}