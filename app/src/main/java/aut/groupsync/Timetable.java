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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Timetable extends Fragment implements Serializable {
    private List<Week> weeks;
    private int currentDayIndex;
    private int currentWeekIndex;
    private int timetableID;

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

    public Day getCurrentDay() {
		//Calendar calendar = Calendar.getInstance();
        //calendar.setTime(now);
		//week.getDays().get(calendar.get(Calendar.DAY_OF_WEEK));
        return weeks.get(currentWeekIndex).getDays().get(this.currentDayIndex);
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void updateTimetable(Timetable newTable) {
        this.weeks = newTable.getWeeks();
    }

    public void save(View v)
    {
        try {
            File f = new File(v.getContext().getFilesDir() + "/" + timetableID + ".txt");
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
}
