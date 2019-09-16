package aut.groupsync.services;

import aut.groupsync.data.model.UserInfo;

public class UserService implements IUserService {
    UserInfo[] users = new UserInfo[]{
            new UserInfo("Mandeep Kaur", "m.kaur.nz@gmail.com"),
            new UserInfo("John Smith", "jsmith@gmail.com")
    };


    @Override
    public UserInfo login(String email, String password) {
        UserInfo matchingUser = getUserInfo(email);

        if (matchingUser == null) {
            return new UserInfo("User not found");
        }


        if (password == null || !password.equals("123")) {
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

    @Override
    public UserInfo signUp(String displayName, String name, String email, String password) {
        return null;
    }
}
