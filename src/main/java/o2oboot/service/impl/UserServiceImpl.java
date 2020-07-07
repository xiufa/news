package o2oboot.service.impl;

import o2oboot.dao.UserDao;
import o2oboot.entity.User;
import o2oboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
;import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int checkUserSingIn(String userId, String password) {
        return userDao.queryUserSignIn(userId,password);
    }

    @Override
    public int checkUserEmail(String email) {
        return userDao.queryUserByEmail(email);
    }

    @Override
    public User getUserDetail(Long userId) {
        return userDao.queryUser(userId);
    }

    @Override
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public Long queryMaxUserId() {
        return userDao.queryMaxUserId();
    }
}
