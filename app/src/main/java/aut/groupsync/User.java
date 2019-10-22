package aut.groupsync;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private String username;
    private String email;
    private Timetable timetable;
    private Diary diary;
    private List<Group> groups = new ArrayList<Group>();

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        List<Day> days = new ArrayList<>();

        Date date = new Date();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i<7; i++) {
            days.add(new Day(date));

            c.setTime(date);
            c.add(Calendar.DATE, 1);
            date = c.getTime();
        }

        this.timetable = new Timetable(new Week(days));
    }

    public String getEmail()
    {
        return email;
    }

    public String getUsername()
    {
        return username;
    }

    public Timetable getTimetable()
    {
        return timetable;
    }

    public List<Group> getGroups() { return groups; }

    public void addGroup(Group newGrp) { groups.add(newGrp);}

    public Diary getDiary()
    {
        return diary;
    }
}
