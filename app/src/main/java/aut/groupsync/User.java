package aut.groupsync;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private Timetable timetable;
    private Diary diary;
    private List<GroupView> groups = new ArrayList<GroupView>();

    public User(String username, String email) {
        this.username = username;
        this.email = email;
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

    public List<GroupView> getGroups()
    {
        return groups;
    }

    public Diary getDiary()
    {
        return diary;
    }
}
