package com.jobs.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;

public class EmployeeRepository {

	private static List<AbsStaffMember> members;
	
	public EmployeeRepository()
	{
		members = new ArrayList<>();
	}
	
	public List<AbsStaffMember> getAllMembers()
	{
		return new ArrayList<>(members);
	}
	
	
	public void addMember(AbsStaffMember member) throws Exception
	{
		if(member==null) throw new Exception();
		members.add(member);
	}
	
	
}
