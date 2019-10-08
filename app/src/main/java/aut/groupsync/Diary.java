package aut.groupsync;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Diary implements Serializable {
	private List<Note> notes;

	public Diary(List<Note> notes) {
		this.notes = notes;
	}

	public Diary() { this(new ArrayList<Note>()); }

	public List<Note> getNotes() {
		return this.notes;
	}
}
