package aut.groupsync;

import android.content.Context;
import android.graphics.drawable.shapes.Shape;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {

    private String groupName;
    private List<User> userList = new ArrayList<>();
    private Timetable timetable;

    public Group(String groupName, User currentUser) {
        this.groupName = groupName;
        userList.add(currentUser); //initial user/creator
    }

    public void changeName(String newName) {
        this.groupName = newName;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    /**
     * Returns true if the removal was successful.
     **/
    public boolean removeUser(User user) {
        if (userList.contains(user)) {
            userList.remove(user);
            return true;
        }
        return false;
    }


    public void addAppointment(Appointment newApp, DayOfWeek dayOfWeek) {
        //get information from input
        //save into string
        this.timetable.getWeek(/*get whatever week you're on atm*/).getDays().get(dayOfWeek.ordinal()/*get from button number*/).addAppointment(/*string*/newApp);
    }

    public void editAppointment(Appointment oldApp) {
        //timetable.editApp(oldApp)
    }

    public void syncTimetable() {/*syncing the users timetables
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

    public String getGroupName() {
        return groupName;
    }

    public List<User> getUsers() {
        return userList;
    }

    public void save(View v)
    {
        try {
            File f = new File(v.getContext().getFilesDir() + "/groups/" + groupName + ".txt");
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
    public Group read(String name, View v)
    {
        Group g = new Group("placeholder", new User("placeholder", "placeholder"));
        try {
            File f = new File(v.getContext().getFilesDir() + "/groups/" + name + ".txt");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            g = (Group)ois.readObject();

            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Error");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found Error");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        return g;
    }
}
