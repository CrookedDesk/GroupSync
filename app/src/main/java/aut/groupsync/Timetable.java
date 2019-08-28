package aut.groupsync;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class Timetable extends Fragment {
//	private Week week;
//
//	public Timetable(Week week, int currentDayIndex) {
//		this.week = week;
//	}
//
//	public Week getWeek() {
//		return this.week;
//	}
//
//	public Day getCurrentDay() {
//		Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now);
//		week.getDays().get(calendar.get(Calendar.DAY_OF_WEEK));
//	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.timetable_main, container, false);
	}
}
