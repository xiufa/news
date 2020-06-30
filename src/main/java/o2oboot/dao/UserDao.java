package o2oboot.dao;

import o2oboot.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    int queryUserSignIn(@Param("userID") String userId, @Param("password")String password);
    int queryUserById(@Param("userID") String userId);
    User queryUser(@Param("userID") String userId);
    int updateUser(User user);
}
