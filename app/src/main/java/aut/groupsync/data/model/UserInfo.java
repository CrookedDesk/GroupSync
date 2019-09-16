package aut.groupsync.data.model;

public class UserInfo {
    private String email;
    private String displayName;
    private String error;

    public UserInfo(String displayName, String email) {
        this.setDisplayName(displayName);
        this.setEmail(email);
    }

    public UserInfo(String error){
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
}
