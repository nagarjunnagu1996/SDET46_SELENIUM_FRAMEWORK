package com.commonutilities.enumsutility;

public enum tabnames
{
	DASHBOARD("Dashboard"),MYPROFILE("My Profile"),CLASSROOM("Classroom"),GRADE("Grade"),SUBJECT("Subject"),TEACHER("Teacher"),
	SUBJECTROUTING("Subject Routing"),TIMETABLE("Timetable"),STUDENT("Student"),STUDENTPAYMENT("Student Payment"),
	ATTENDANCE("Attendance"),EXAM("Exam"),PETTYCASH("Petty Cash"),Friends("Friends"),EVENT("Event");

String tab;
	private tabnames(String tab)
	{
		this.tab=tab;
	}
	public String gettabnames()
	{
		return tab;
	}





}
