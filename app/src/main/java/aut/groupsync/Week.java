package aut.groupsync;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Week implements Serializable {
	private List<Day> days;

	public Week(List<Day> days) {
		this.days = days;
	}

	public String getDateText() {
		String year = days.get(0).getYear();
		SimpleDateFormat weekFormat = new SimpleDateFormat("MM-dd");
		return year + ", " + weekFormat.format(days.get(0)) + " to " + weekFormat.format(days.get(6));
	}

	public List<Day> getDays() {
		return days;
	}
}
