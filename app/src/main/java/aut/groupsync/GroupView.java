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
    private User currentUser;

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
                createGroupPopupW.setFocusable(true);
                createGroupPopupW.update();

                //close the popup window on button click
                confirmAddGroupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText name = createGroupPopupW.getContentView().findViewById(R.id.groupNameEditTxt); //Get text from user input
                        String grpName = name.getText().toString(); //save text into string
                        if (currentUser != null)
                        {
                            Group newGrp = new Group(grpName, currentUser); //create group with previous text
                            currentUser.addGroup(newGrp);
                        }

                        //pass group to database

                        createGroupPopupW.dismiss();
                    }
                });

                final Button inviteUsersButton = createGroupPopupW.getContentView().findViewById(R.id.inviteUserBtn);

                View inviteUserPopupLayout = inflater.inflate(R.layout.invite_group_popup, null);
                final PopupWindow inviteUserPopupW = new PopupWindow(inviteUserPopupLayout, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                inviteUserPopupW.setFocusable(true);
                inviteUserPopupW.update();

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

}
