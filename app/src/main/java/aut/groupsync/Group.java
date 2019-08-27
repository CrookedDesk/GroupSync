package aut.groupsync;

import java.util.List;

public class Group {
    private String groupName;
    private List<Account> userList;
    private Timetable timetable;

    Group(String groupName, Account user)
    {
        this.groupName = groupName;
        userList.add(user); //initial user/creator
    }

    public void changeName(String newName)
    {
        this.groupName = newName;
    }

    public void inviteUser(Account user)
    {//Sending invite to user
        //user.notifyInvite(Group this)
    }

    public void addUser(Account user)
    {//Call this when user has accepted invite
        //userList.add(user)
        //syncTimetable
    }

    public void removeUser(Account user)
    {//Remove user
        //if(userList.user exists)
        //{
        //    userList.remove(user)
        //}
        //syncTimetable
    }

    public void addAppointment(Appointment newApp)
    {
        //timetable.addApp(newApp)
    }

    public void editAppointment(Appointment oldApp)
    {
        //timetable.editApp(oldApp)
    }

    public void syncTimetable()
    {/*syncing the users timetables
        Timetable temp = new Timetable();
        //copy group specific appointments into temp timetable

        for(int i = 0; i < userList.size(); i++)
        {
            Account currentUser = userList.get(i);
            Timetable currentTable = currentUser.getTimetable();
            for(//appointment in currentTable)
            {
                //if(appointment.getTime is in timetable)
                //{
                //  do nothing
                //}
                //else
                //{
                //  timetable.addAppointment(appointment.getTime, String groupname, etc)
                //}
            }
            //replace group timetable with temp timetable
        }
        */
    }

    public String getGroupName()
    {
        return groupName;
    }

    public List<Account> getUsers()
    {
        return userList;
    }
}
