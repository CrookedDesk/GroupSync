package aut.groupsync;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private Timetable timetable;
    private Diary diary;
    private List<Group> groups = new ArrayList<Group>();

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

    public List<Group> getGroups() { return groups; }

    public void addGroup(Group newGrp) { groups.add(newGrp);}

    public Diary getDiary()
    {
        return diary;
    }
}
