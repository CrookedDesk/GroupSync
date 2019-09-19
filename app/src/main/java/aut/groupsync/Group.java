package aut.groupsync;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupName;
    private List<User> userList = new ArrayList<>();
    private Timetable timetable;
    private User currentUser;

    public Group(String groupName)
    {
        this.groupName = groupName;
        initiateTestUser();
        userList.add(currentUser); //initial user/creator
    }

    private void initiateTestUser()
    {
        this.currentUser = new User("DylanHarding", "sdp0982@autuni.ac.nz");
    }

    public void changeName(String newName)
    {
        this.groupName = newName;
    }

    public void addUser(User user)
    {
        userList.add(user);
    }

    public void removeUser(User user)
    {
        if(userList.contains(user))
        {
            userList.remove(user);
        }
        //else return error message to user
    }

    public void addAppointment(Appointment newApp, int dayOfWeek)
    {
        this.timetable.getWeek().getDays().get(dayOfWeek).addAppointment(newApp);
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
            User currentUser = userList.get(i);
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

    public List<User> getUsers()
    {
        return userList;
    }
}
