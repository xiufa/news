package o2oboot.dao;

import o2oboot.entity.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    int queryUserSignIn(String userID, String password);
    User queryUserById(String userID);
    List<User> queryUserList(String userID);
    int updateUser(User user);
}
