package o2oboot.service;

import o2oboot.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    int checkUserSingIn(String email, String password);

    int checkUserEmail(String email);

    User getUserDetail(Long userId);

    int modifyUser(User user);

    List<User> queryAllUser();

    Long queryMaxUserId();
}
