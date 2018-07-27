package com.mak;

import java.util.Scanner;

abstract class Arithmetic {
	double num1, num2, num3;

	public Arithmetic(double num1, double num2, double num3) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	public void readValues(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public void printValues() {
		System.out.println("Numer1: " + num1);
		System.out.println("Numer2: " + num2);
		System.out.println("Aswer:  " + num3);

	}

	public abstract void calculate();

}

class Addition extends Arithmetic {

	public Addition(double num1, double num2, double num3) {
		super(num1, num2, num3);
	}

	@Override
	public void calculate() {
		num3 = num1 + num2;
	}

}

class Subtraction extends Arithmetic {

	public Subtraction(double num1, double num2, double num3) {
		super(num1, num2, num3);
	}

	@Override
	public void calculate() {
		num3 = num1 - num2;
	}

}

class Multiplication extends Arithmetic {

	public Multiplication(double num1, double num2, double num3) {
		super(num1, num2, num3);
	}

	@Override
	public void calculate() {
		num3 = num1 * num2;
	}

}

class Division extends Arithmetic {

	public Division(double num1, double num2, double num3) {
		super(num1, num2, num3);
	}

	@Override
	public void calculate() {
		try {
			num3 = num1 / num2;
		} catch (ArithmeticException e) {
			System.out.println("Cannot Devide By Zero");
		}
	}

}

public class Calculate {
	public static void main(String[] args) {
		Arithmetic a[] = new Arithmetic[4];
		a[0] = new Addition(0, 0, 0);
		a[1] = new Subtraction(0, 0, 0);
		a[2] = new Multiplication(0, 0, 0);
		a[3] = new Division(0, 0, 0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Your Choice: ");
		System.out.println("1-Addition ");
		System.out.println("2-Subtraction");
		System.out.println("3-Multiplication");
		System.out.println("4-Divition");
		int ch=0;
		try {
		ch = sc.nextInt();
		}
		catch(NumberFormatException ex){
			System.out.println("Invalid Values Entered!!!");
		}
		System.out.println((ch<1||ch>4)?"Invalid Choice":"Please Enter 2 Values");		
		a[ch-1].readValues(sc.nextDouble(), sc.nextDouble());
		a[ch-1].calculate();
		a[ch-1].printValues();
		sc.close();
	}
}
