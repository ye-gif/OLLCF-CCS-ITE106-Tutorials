import java.util.Scanner;

public class StudentGradeCalculator{
	
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of the students in the class:");
		int numStudents = scanner.nextInt();
		scanner.nextLine();
		
		String[]studentNames = new String[numStudents];
		double[]averageScores = new double[numStudents];
		char[]letterGrades = new char[numStudents];
		
		int numAssignments = 3;
		for (int i = 0 ; i < numStudents; i++){
			System.out.println("Enter the name of the student" + (i + 1) + ":");
			studentNames[i] = scanner.nextLine();
			
		double totalScore = 0;
		for(int j = 0; j < numAssignments; j++){
			System.out.println("Enter score for assignmet" + (j + 1) + ":");
			totalScore += scanner.nextDouble();
		}
		averageScores[i] = totalScore/numAssignments;
		
		if(averageScores[i]>= 90){
			letterGrades[i] = 'A';
		}else if(averageScores[i]>= 80){
			letterGrades[i] = 'B';
		}else if(averageScores[i]>= 70){
			letterGrades[i] = 'C';
		}else if(averageScores[i]>= 60){
			letterGrades[i] = 'D';
		}else{
			letterGrades[i] = 'F';
			}
				
		System.out.println("\nStudent Grades:");
		for(int n = 0; i<numStudents; i++){
			System.out.println("Student:"+ studentNames[i]);
			System.out.println("Average Score:" + averageScores[i]);
			System.out.println("Letter Grade:" + letterGrades[i]);
			System.out.println();
			
			}
		}
	}
}
