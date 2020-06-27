package o2oboot.service;

import o2oboot.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    int checkUserSingIn(String userID, String password);

    User checkUserID(String userID);

    List<User> getUserDetail(String userID);

    int modifyUser(User user);
}
