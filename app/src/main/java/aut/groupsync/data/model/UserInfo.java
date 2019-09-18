package aut.groupsync.data.model;

public class UserInfo {
    private String password;
    private String email;
    private String displayName;
    private String error;

    public UserInfo(String displayName, String email) {
        this.setDisplayName(displayName);
        this.setEmail(email);
    }

    public UserInfo(String displayName, String email, String password) {
        this.setDisplayName(displayName);
        this.setEmail(email);
        this.password = password;
    }

    public UserInfo(String error) {
        this.setError(error);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean checkPassword(String password) {
        return password != null && password.equals(this.password);
    }
}
