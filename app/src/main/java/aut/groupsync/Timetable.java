package aut.groupsync;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.Date;

public class Timetable extends Fragment implements Serializable {
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
}
