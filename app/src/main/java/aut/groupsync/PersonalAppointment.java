package aut.groupsync;

public class PersonalAppointment extends Appointment {
	private boolean isPrivate;

	public PersonalAppointment(Date date, Note note, boolean hasAlarm, String name, boolean reoccuring, boolean isPrivate) {
		super(date, note, hasAlarm, name, reoccuring);
		this.isPrivate = isPrivate;
	}

	public void setPrivacy(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public boolean isPrivate() {
		return this.isPrivate;
	}
}
