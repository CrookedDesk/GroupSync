package aut.groupsync;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class GroupView extends Fragment {
    private String groupName;
    private List<User> userList = new ArrayList<>();
    private Timetable timetable;
    public static User currentUser;

    public static PopupWindow displayPopupWindow(View popupLayout, View onView) {
        final PopupWindow popupWindow = new PopupWindow(popupLayout, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //display the popup window
        popupWindow.showAtLocation(onView, Gravity.CENTER, 0, 0);

        return popupWindow;
    }

    public View onCreateView(final LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.group_page,
                container, false);
        Button addGroupBtn = view.findViewById(R.id.addGroupBtn);


        addGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file
                View addGroupPopupLayout = inflater.inflate(R.layout.add_group_popup,null);

                Button confirmAddGroupBtn = addGroupPopupLayout.findViewById(R.id.confirmAddGroupBtn);

                //instantiate popup window

                final PopupWindow createGroupPopupW = displayPopupWindow(addGroupPopupLayout, view);



                //close the popup window on button click
                confirmAddGroupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText name = createGroupPopupW.getContentView().findViewById(R.id.groupNameEditTxt); //Get text from user input
                        String grpName = name.getText().toString(); //save text into string
                        Group newGrp = new Group(grpName); //create group with previous text
                        if (currentUser != null) {
                            currentUser.getGroups().add(newGrp);
                        }


                        //pass group to database

                        createGroupPopupW.dismiss();
                    }
                });

                final Button inviteUsersButton = createGroupPopupW.getContentView().findViewById(R.id.inviteUserBtn);

                View inviteUserPopupLayout = inflater.inflate(R.layout.invite_group_popup, null);
                final PopupWindow inviteUserPopupW = new PopupWindow(inviteUserPopupLayout, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                if (inviteUsersButton != null) {
                    inviteUsersButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            inviteUserPopupW.showAtLocation(view, Gravity.CENTER, 0, 0);

                            Button inviteUserButtonInPopup = inviteUserPopupW.getContentView().findViewById(R.id.inviteUserPopupBtn);

                            if (inviteUserButtonInPopup != null) {
                                inviteUserButtonInPopup.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        inviteUserPopupW.dismiss();
                                    }
                                });
                            }
                        }
                    });



                }

            }
        });
        return view;
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
