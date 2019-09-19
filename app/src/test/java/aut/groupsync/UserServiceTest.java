package aut.groupsync;

import org.junit.Test;

import aut.groupsync.data.model.UserInfo;
import aut.groupsync.services.UserService;

import static org.junit.Assert.*;

public class UserServiceTest {
    @Test
    public void signup_displayName_null_error() {
        // arrange
        UserService userService = new UserService();

        // action
        UserInfo userInfo = userService.signUp(null, "myemail@my.com", "123", "123");

        // assert
        assertEquals("Display name cannot be empty", userInfo.getError());
    }

    @Test
    public void signup_displayName_empty_error() {
        // arrange
        UserService userService = new UserService();

        // action
        UserInfo userInfo = userService.signUp("  ", "myemail@my.com", "123", "123");

        // assert
        assertEquals("Display name cannot be empty", userInfo.getError());
    }

    @Test
    public void signup_email_null_error() {
        // arrange
        UserService userService = new UserService();

        // action
        UserInfo userInfo = userService.signUp("display name", null, "123", "123");

        // assert
        assertEquals("Email cannot be empty", userInfo.getError());
    }

    @Test
    public void signup_password_empty_error() {
        // arrange
        UserService userService = new UserService();

        // action
        UserInfo userInfo = userService.signUp("display name", "myemail@my.com", null, "123");

        // assert
        assertEquals("Password cannot be empty", userInfo.getError());
    }

    @Test
    public void signup_passwordConfirm_empty_error() {
        // arrange
        UserService userService = new UserService();

        // action
        UserInfo userInfo = userService.signUp("display name", "myemail@my.com", "123", null);

        // assert
        assertEquals("Confirm password name cannot be empty", userInfo.getError());
    }

     @Test
    public void signup_passwordDonotMatch_error() {
        // arrange
        UserService userService = new UserService();

        // action
        UserInfo userInfo = userService.signUp("display name", "myemail@my.com", "123", "abc");

        // assert
        assertEquals("Confirm password does not match", userInfo.getError());
    }

    @Test
    public void signup_success() {
        // arrange
        UserService userService = new UserService();

        // action
        UserInfo userInfo =  userService.signUp("display name", "myemail@my.com", "123", "123");

        // assert
        assertNull(userInfo.getError());
        assertEquals("display name", userInfo.getDisplayName());
        assertEquals("myemail@my.com", userInfo.getEmail());
    }

    @Test
    public void signup_existingUser_error() {
        // arrange
        UserService userService = new UserService();
        userService.signUp("display name  ", "myemail@my.com", "123", "123");

        // action
        UserInfo userInfo =  userService.signUp("display name  ", "myemail@my.com", "123", "123");

        // assert
        assertEquals("User already exists", userInfo.getError());
    }

    @Test
    public void login_after_signup() {
        // arrange
        UserService userService = new UserService();
        userService.signUp("display name", "myemail@my.com", "123", "123");

        // action
        UserInfo userInfo = userService.login("myemail@my.com", "123");

        // assert
        assertNull(userInfo.getError());
        assertEquals("display name", userInfo.getDisplayName());
        assertEquals("myemail@my.com", userInfo.getEmail());
    }

    @Test
    public void login_wrong_email() {
        // arrange
        UserService userService = new UserService();
        userService.signUp("display name", "myemail@my.com", "123", "123");

        // action
        UserInfo userInfo = userService.login("wrong", "123");

        // assert
        assertEquals("User not found", userInfo.getError());
        assertNull(userInfo.getDisplayName());
        assertNull(userInfo.getEmail());
    }

    @Test
    public void login_wrong_password() {
        // arrange
        UserService userService = new UserService();
        userService.signUp("display name", "myemail@my.com", "123", "123");

        // action
        UserInfo userInfo = userService.login("myemail@my.com", "wrong");

        // assert
        assertEquals("Wrong password", userInfo.getError());
        assertNull(userInfo.getDisplayName());
        assertNull(userInfo.getEmail());
    }
}