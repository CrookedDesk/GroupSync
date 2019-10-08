package aut.groupsync;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Day implements Serializable {
	private List<Appointment> appointments;
	private Date date;

	public Day(Date date) {
		this.date = date;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public Date getDate() {
		return this.date;
	}

	public String getYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return year + "";
	}

	public void addAppointment(Appointment app) {
		appointments.add(app);
	}

	public void removeAppointment(String time) {
		for (Appointment a : appointments)
		{
			Appointment app = a;
			if (a.getTime() == time)
			{
				appointments.remove(a);
			}
		}
	}
}
