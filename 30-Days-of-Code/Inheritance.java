import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}
class Student extends Person{
   
	private int[] testScores;
    
    Student(String firstName, String lastName, int idNumber, int[] testScores){
        super(firstName, lastName, idNumber);        
        this.testScores = testScores;
    }
    
    public int[] getTestScores(){
        return this.testScores;
    }
    
    int total=0;
       
    //calculate
    public String calculate(){
        for(int i=0; i<testScores.length; i++){
            total += testScores[i];
        }
        double a = total/(testScores.length);
        
        if(a>=90 && a<=100){
            return "O";
        }
        if(a>=80 && a<=90){
            return "E";
        }
        if(a>=70 && a<=80){
            return "A";
        }
        if(a>=55 && a<=70){
            return "P";
        }
        if(a>=40 && a<=55){
            return "D";
        }
        if(a<40){
            return "T";
        }
        
        return null;
    }
   
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}
