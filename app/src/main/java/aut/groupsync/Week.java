package aut.groupsync;

import java.text.SimpleDateFormat;
import java.util.List;

public class Week {
	private List<Day> days;

	public Week(List<Day> days) {
		this.days = days;
	}

	public String getDateText() {
		String year = days.get(0).getYear();
		SimpleDateFormat weekFormat = new SimpleDateFormat("MM-dd");
		return year + ", " + weekFormat.format(days.get(0)) + " to " + weekFormat.format(days.get(6));
	}

//	public List getDays() {
//
//	}
}
