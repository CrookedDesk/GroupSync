package aut.groupsync;

import java.util.ArrayList;
import java.util.List;

public class Diary {
	private List<Note> notes;

	public Diary(List<Note> notes) {
		this.notes = notes;
	}

	public Diary() {
		this(new ArrayList<Note>());
	}

	public List<Note> getNotes() {
		return this.notes;
	}
}
