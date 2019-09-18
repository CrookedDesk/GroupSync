package aut.groupsync.services;

import java.util.ArrayList;
import java.util.List;

import aut.groupsync.data.model.UserInfo;

public class UserService implements IUserService {
    List<UserInfo> users = new ArrayList<UserInfo>();

    @Override
    public UserInfo login(String email, String password) {
        UserInfo matchingUser = getUserInfo(email);

        if (matchingUser == null) {
            return new UserInfo("User not found");
        }


        if (!matchingUser.checkPassword(password)) {

            return new UserInfo("Wrong password");
        }

        return matchingUser;
    }


    private UserInfo getUserInfo(String email) {
        for (UserInfo user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    @Override
    public UserInfo signUp(String displayName, String email, String password, String passwordConfirm) {
        String error = null;

        if (isNullOrEmpty(displayName)) {
            error = "Display name cannot be empty";
        } else if (isNullOrEmpty(email)) {
            error = "Email cannot be empty";
        } else if (isNullOrEmpty(password)) {
            error = "Password cannot be empty";
        } else if (isNullOrEmpty(passwordConfirm)) {
            error = "Confirm password name cannot be empty";
        } else if (!password.equals(passwordConfirm)) {
            error = "Confirm password does not match";
        } else {
            UserInfo userInfo = getUserInfo(email);

            if (userInfo != null) {
                error = "User already exists";
            }
        }

        if (error != null) {
            return new UserInfo(error);
        }

        UserInfo newUser = new UserInfo(displayName, email, password);
        users.add(newUser);
        return newUser;
    }
}
