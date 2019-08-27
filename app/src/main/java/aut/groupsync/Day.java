package aut.groupsync;

public class Day {
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
}
