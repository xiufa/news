package o2oboot.entity;

public class User {
    private Long userId;
    private String username;
    private String email;
    private String password;

    public User() {
    }

    public User(Long userID, String username, String password, String email) {
        this.userId = userID;
        this.username = username;
        this.password = password;
        this.email=email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
