package aut.groupsync;

import android.view.View;

import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Appointment extends Fragment implements Serializable {
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

	public String getTime()
	{
		String time;
		time = date.toString();
		//time.format into time only
		return time;
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

	public void save(View v)
	{
		try {
			File f = new File(v.getContext().getFilesDir() + "/" + name + ".txt");
			FileOutputStream fOut = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fOut);
			oos.writeObject(this);

			oos.flush();
			oos.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File Error");
		} catch (IOException e) {
			System.out.println("IO Error");
		}
	}

	public Appointment read(String name, View v)
	{
		Appointment a = new Appointment(new Date(), new Note("note"), true, "name", false);
		try {
			File f = new File(v.getContext().getFilesDir() + "/" + name + ".txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			a = (Appointment)ois.readObject();

			ois.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File Error");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found Error");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
		return a;
	}
}
