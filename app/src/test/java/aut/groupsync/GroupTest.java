package aut.groupsync;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;


import java.time.DayOfWeek;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GroupTest {
    private Group createTestGroup() {
        return new Group("testName");
    }

    private User createTestUser() {
        return new User("testUsername", "testEmail@test.test");
    }

    @Test
    public void changeNameTest() {
        // Create group.
        Group group = createTestGroup();

        // Change group name.
        final String NEW_GROUP_NAME = "testName2";
        group.changeName(NEW_GROUP_NAME);

        // Should have the new name now.
        assertEquals(group.getGroupName(), NEW_GROUP_NAME);
    }

    @Test
    public void addUserTest() {
        // Create group.
        Group group = createTestGroup();

        // Create user.
        User user = createTestUser();

        // Add user to group.
        group.addUser(user);

        // Should be in the user list now.
        assertTrue(group.getUsers().contains(user));
    }

    @Test
    public void removeUserExistsTest() {
        // Create group.
        Group group = createTestGroup();

        // Create user.
        User user = createTestUser();

        // Add user to group.
        group.addUser(user);

        // Remove user from group.
        boolean result = group.removeUser(user);

        // The removal should be successful because the user exists
        assertTrue(result);

        // Should not be in the user list anymore.
        assertFalse(group.getUsers().contains(user));
    }

    @Test
    public void removeUserNotExistsTest() {
        // Create group.
        Group group = createTestGroup();

        // Create user.
        User user = createTestUser();

        // Add user to group.
        group.addUser(user);

        // Remove user from group.
        boolean result = group.removeUser(user);

        // The removal shouldn't be successful because the user doesn't exist.
        assertFalse(result);

        // Should not be in the user list.
        assertFalse(group.getUsers().contains(user));
    }

    @Test
    public void confirmAddGroupThroughUITest() {
        // Get context.
        Context context = ApplicationProvider.getApplicationContext();

        // Inflate the views needed.
        LinearLayout addGroupPopupLayout = (LinearLayout) View.inflate(context, R.layout.add_group_popup, null);
        View groupPage = View.inflate(context, R.layout.group_page, null);

        // Display popup window
        PopupWindow createGroupPopupW = GroupView.displayPopupWindow(addGroupPopupLayout, groupPage);

        // Get the confirm button
        Button confirmButton = addGroupPopupLayout.findViewById(R.id.confirmAddGroupBtn);

        int initialUserGroupSize = GroupView.currentUser.getGroups().size();
        confirmButton.performClick();

        // Check if the UI popup is still showing when the confirmation button is clicked.
        assertTrue(createGroupPopupW == null || !createGroupPopupW.isShowing());

        // Check if group list of the current user has been incremented.
        assertEquals(GroupView.currentUser.getGroups().size(), initialUserGroupSize+1);
    }
}