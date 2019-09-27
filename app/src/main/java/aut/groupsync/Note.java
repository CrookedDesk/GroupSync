package aut.groupsync;

import java.io.Serializable;

public class Note implements Serializable {
	private String text;

	public Note(String text) {
		this.text = text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
}
