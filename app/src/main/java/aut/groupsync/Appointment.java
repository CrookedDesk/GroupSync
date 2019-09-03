package aut.groupsync;

import androidx.fragment.app.Fragment;

import java.util.Date;

public class Appointment extends Fragment {
	private Note note;
	private Alarm alarm;
	private String name;
	private Date date;
	private boolean reoccuring;

	public Appointment(Date date, Note note, boolean hasAlarm, String name, boolean reoccuring) {
		this.date = date;
		this.note = note;
		this.alarm = new Alarm(hasAlarm);
		this.name = name;
		this.reoccuring = reoccuring;
	}

	public Note getNote() {
		return this.note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Alarm getAlarm() {
		return this.alarm;
	}

	public String getAppointmentName() {
		return this.name;
	}

	public void setAppointmentName(String name) {
		this.name = name;
	}

	public void setReoccuring(boolean reoccuring) {
		this.reoccuring = reoccuring;
	}

	public boolean getReoccuring() {
		return this.reoccuring;
	}
}
