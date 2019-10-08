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

public class GroupView extends Fragment {

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

        final Button testButton = (Button) view.findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group g = new Group("placeholder", currentUser);
                g = g.read("beep", view);

                TextView groupName = (TextView) view.findViewById(R.id.textName);
                TextView creatorName = (TextView) view.findViewById(R.id.textCreator);
                TextView creatorEmail = (TextView) view.findViewById(R.id.textCreatorEmail);

                if (g.getGroupName() instanceof String) {groupName.setText(g.getGroupName());}
                if (g.getUsers().get(0).getUsername() instanceof String) {creatorName.setText(g.getUsers().get(0).getUsername()); }
                if (g.getUsers().get(0).getEmail() instanceof String) {creatorEmail.setText(g.getUsers().get(0).getEmail()); }
            }
        });

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
                        initiateTestUser();
                        if (currentUser != null)
                        {
                            Group newGrp = new Group(grpName, currentUser); //create group with previous text
                            newGrp.save(v);
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
