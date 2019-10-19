package com.jobs.application;

import com.jobs.domain.IPaymentRate;

/**
 * Crea la tarifa de pago para cada tipo de empleado
 */
public class PaymentFactory {

	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*.85;
			}
		};
	}

	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1;
			}
		};
	}

	public static IPaymentRate createPaymentRateVolunteer(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return 0;
			}
		};
	}
}
