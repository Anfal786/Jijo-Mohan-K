package com.mak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class EmployeeVo {
	private int empId;
	private String empName;
	private double annualIncome, incomeTax;

	public EmployeeVo(int empId, String empName, double annualIncome) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.annualIncome = annualIncome;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(annualIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		temp = Double.doubleToLongBits(incomeTax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVo other = (EmployeeVo) obj;
		if (Double.doubleToLongBits(annualIncome) != Double.doubleToLongBits(other.annualIncome))
			return false;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (Double.doubleToLongBits(incomeTax) != Double.doubleToLongBits(other.incomeTax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "employeeVo [empId=" + empId + ", empName=" + empName + ", annualIncome=" + annualIncome + ", incomeTax="
				+ incomeTax + "]";
	}

}

class EmployeeBo {
	public void calIncomeTax(EmployeeVo eVo) {
		eVo.setIncomeTax(eVo.getAnnualIncome() * 0.1);
	}
}

class EmployeeSort implements Comparator<EmployeeVo> {

	@Override
	public int compare(EmployeeVo o1, EmployeeVo o2) {
		return (int) (o2.getIncomeTax() - o1.getIncomeTax());
	}

}

public class EmployeeMain {
	public static void main(String[] args) {
		int empId=0;
		String empName=null;
		double annualIncome=0.0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter the Number of Employee: ");
		int n = sc.nextInt();
		EmployeeBo cal = new EmployeeBo();
		ArrayList<EmployeeVo> employeeVo = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			System.out.println("\nEmployee No."+(i+1));
			System.out.print("Enter the Employee ID: ");
			empId=sc.nextInt();
			System.out.print("Enter the Employee Name: ");
			empName = sc.next();
			System.out.print("Enter the Employee Annual Income: ");
			annualIncome = sc.nextDouble();
			employeeVo.add(new EmployeeVo(empId, empName, annualIncome));
			cal.calIncomeTax(employeeVo.get(i));
		}
		sc.close();
		for (EmployeeVo e : employeeVo)
			System.out.println(e);
		Collections.sort(employeeVo, new EmployeeSort());
		System.out.println("After Sorting: ");
		for (EmployeeVo e : employeeVo)
			System.out.println(e);
	}
}
