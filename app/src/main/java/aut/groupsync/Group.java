package aut.groupsync;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Group extends Fragment {
    private String groupName;
    private List<Account> userList = new ArrayList<>();
    private Timetable timetable;

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
                final PopupWindow createGroupPopupW = new PopupWindow(addGroupPopupLayout, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                //display the popup window
                createGroupPopupW.showAtLocation(view, Gravity.CENTER, 0, 0);



                //close the popup window on button click
                confirmAddGroupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
