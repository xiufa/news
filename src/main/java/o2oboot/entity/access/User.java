package o2oboot.entity.access;

public class User {
    private String userId;
    private String username;
    private String password;
    private String gender;

    private Role role;

    public User() {
    }

    public User(String userID, String username, String password, String gender) {
        this.userId = userID;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
