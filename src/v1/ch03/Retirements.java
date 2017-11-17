/**
 * 
 */
package v1.ch03;

import java.util.Scanner;

/**
 * @author niu
 * @date Nov 14, 2017 9:38:59 AM
 * @Description: 退休金额计算小程序
 */
public class Retirements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("How much money will you contribute ever year?");
		double payment=in.nextDouble();
		System.out.println("Interest rate in%:");
		double interestRate=in.nextDouble();
		double balance=0;
		int year=0;
		String input;
		
		//update account balance while user isn't ready to retire
		do{
			balance+=payment;
			double interest=balance*interestRate/100;
			balance+=interest;
			year+=1;
			
			System.out.printf("After year %d, you balance is %,.2f%n",year,balance);
			System.out.print("Ready to retire?(Y/N)");
			input=in.next();
		}while(input.equals("N"));
	}

}
