package aut.groupsync.services;

import aut.groupsync.data.model.UserInfo;

public interface IUserService {
    /**
     * Login a user with the given email and password
     *
     * @param email
     * @param password
     * @return Error message if the credentials are not correct
     */
    UserInfo login(String email, String password);

    UserInfo signUp(String displayName, String email, String password, String passwordConfirm);

}
