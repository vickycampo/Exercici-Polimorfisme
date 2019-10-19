package com.jobs.domain;

public class Volunteer extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;

	public Volunteer (String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception
	{
		super(name, address, phone);
		this.salaryPerMonth = salaryPerMonth;
		this.paymentRate = paymentRate;
	}
	@Override
	public void pay()
	{
		totalPaid = paymentRate.pay(salaryPerMonth);
		System.out.println("Voluntarios no reciben sueldo.");
	}


}
