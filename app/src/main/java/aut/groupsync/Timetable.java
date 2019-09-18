package aut.groupsync;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Timetable extends Fragment {
    private Week week;
    private int currentDayIndex;

//    public Timetable(Week week, int currentDayIndex) {
//        this.week = week;
//        if (currentDayIndex > 6) {
//            currentDayIndex = 6;
//        }
//        if (currentDayIndex < 0) {
//            currentDayIndex = 0;
//        }
//
//        this.currentDayIndex = currentDayIndex;
//    }

    public Week getWeek() {
        return this.week;
    }

    public Day getCurrentDay() {
		//Calendar calendar = Calendar.getInstance();
        //calendar.setTime(now);
		//week.getDays().get(calendar.get(Calendar.DAY_OF_WEEK));
        return this.week.getDays().get(this.currentDayIndex);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.timetable_main, container, false);
    }
}
