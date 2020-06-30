package o2oboot.dao;

import o2oboot.entity.access.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int insertUser(User user);
    int queryUserSignIn( Long userId, String password);
    int queryUserById(Long userId);
    User queryUser( Long userId);
    int updateUser(User user);



}
