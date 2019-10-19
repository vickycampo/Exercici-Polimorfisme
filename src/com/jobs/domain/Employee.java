package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception
	{
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay()
	{
		double totalPaid = paymentRate.pay(salaryPerMonth);
		System.out.println( "Sueldo enviado: " + totalPaid );
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ")
				.append(name)
				.append("\n")
				.append("Dirección: ")
				.append(address)
				.append("\n")
				.append("Teléfono: ")
				.append(phone)
				.append("\n").append("\n");
		return (sb.toString());
	}
}
