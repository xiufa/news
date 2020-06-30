package o2oboot.service;

import o2oboot.entity.access.Role;
import o2oboot.entity.access.User;

public interface UserService {
    int addUser(User user);

    int checkUserSingIn(Long userID, String password);

    int checkUserID(Long userID);

    User getUserDetail(Long userID);

    int modifyUser(User user);
    int addRole(User user, Role role);
}
