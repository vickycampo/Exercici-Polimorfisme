package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

import java.util.Iterator;
import java.util.List;

/**
 * Controla la creación de los diferentes empleados según el puesto
 */
public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController()
	{
		repository = new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception
	{
		AbsStaffMember boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception
	{
		AbsStaffMember employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception
	{
		AbsStaffMember manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}

	public void createVolunteer(String name, String address, String phone) throws Exception
	{
		double salaryPerMonth = 0;
		AbsStaffMember volunteer = new Volunteer (name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateVolunteer());
		repository.addMember(volunteer);

	}

	public void payAllEmployeers()
	{
		List<AbsStaffMember> allMembers = repository.getAllMembers();
		Iterator<AbsStaffMember> iterator = allMembers.iterator();
		System.out.println("Pagos de salarios: ");
		while ( iterator.hasNext() )
		{
			AbsStaffMember empleado = iterator.next();
			System.out.println("Nombre: " + empleado.getName());
			empleado.pay();
			System.out.println("");

		}
	}

	public String getAllEmployees()
	{
		StringBuilder sb = new StringBuilder();
		List<AbsStaffMember> allMembers = repository.getAllMembers();
		Iterator<AbsStaffMember> iterator = allMembers.iterator();

		while ( iterator.hasNext() )
		{
			sb.append( iterator.next().toString() );
		}
		return sb.toString();
	}


	
	
	
}
