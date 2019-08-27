package aut.groupsync;

import java.util.List;

public class Group {
    private String groupName;
    private List<Account> userList;
    private Timetable timetable;
    private Account Admin;

    Group(Account Admin, String groupName)
    {
        this.groupName = groupName;
        this.Admin = Admin;
    }

    public void setAdmin(Account user)
    {
        this.Admin = user;
    }

    public void inviteUser(Account user)
    {
        //Sending invite to user
        //user.notifyInvite(Group this)
    }

    public void addUser(Account user)
    {
        //Call this when user has accepted invite
        //userList.add(user)
        //syncTimetable
    }

    public void removeUser(Account user)
    {
        //Remove user
        //userList.remove(user)
        //syncTimetable
    }

    public void changeName(String newName)
    {
        this.groupName = newName;
    }

    public void addAppointment(Appointment newApp)
    {
        //timetable.addApp(newApp)
    }

    public void syncTimetable()
    {
        //copy group specific appointments into temp timetable
        //for loop
        // {
        //   get user from list
        //   get their timetable
        //   for loop
        //    {
        //       get their first/second/third/etc appointment
        //       check if corresponding time slot in group table is free
        //       if free: copy appointment into temp group timetable without personal details
        //       else: ignore
        //    }
        // }
        //replace group timetable with temp timetable
    }

    public String getGroupName()
    {
        return groupName;
    }

    public Account getAdmin()
    {
        return Admin;
    }
}
