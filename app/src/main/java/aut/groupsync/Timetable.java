package aut.groupsync;

public class Timetable {
	private Week week;

	public Timetable(Week week, int currentDayIndex) {
		this.week = week;
	}

	public Week getWeek() {
		return this.week;
	}

	public Day getCurrentDay() {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
		week.getDays().get(calendar.get(Calendar.DAY_OF_WEEK));
	}
}
