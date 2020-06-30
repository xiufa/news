package o2oboot.service.impl;

import o2oboot.dao.RoleUserMapDao;
import o2oboot.dao.UserDao;
import o2oboot.entity.access.Role;
import o2oboot.entity.access.User;
import o2oboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleUserMapDao roleUserMapDao;

    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int checkUserSingIn(Long userID, String password) {
        return userDao.queryUserSignIn(userID,password);
    }

    @Override
    public int checkUserID(Long userID) {
        return userDao.queryUserById(userID);
    }

    @Override
    public User getUserDetail(Long userID) {
        return userDao.queryUser(userID);
    }

    @Override
    public int modifyUser(User user) {
        roleUserMapDao.updateRoleUserMap(user.getRole(),user);
        return userDao.updateUser(user);
    }

    @Override
    public int addRole(User user, Role role) {
        return roleUserMapDao.addRoleUserMap(role,user);
    }
}
