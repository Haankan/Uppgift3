import java.util.Scanner;
public class Age3{
	public static void main(String[] args){
		int age = 0;

		Scanner apa = new Scanner(System.in);
		System.out.println("How old are you?");
		age = Integer.parseInt(apa.next());
		if (age<16){
			System.out.println("You cant drive!");
		}
		if (age == 16 || age == 17){
			System.out.println("You can drive but not vote");

		}
		if (age >= 18 && age <=24){
			System.out.println("You can vote but not rent a car");
		}
		if (age>25){
			System.out.println("You can do everything");
		}



	}
}