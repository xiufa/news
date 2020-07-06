package o2oboot.dao;

import o2oboot.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    int queryUserSignIn(@Param("userId") String userId, @Param("password")String password);
    int queryUserById(@Param("userId") String userId);
    User queryUser(@Param("userId") String userId);
    int updateUser(User user);
    List<User> queryAllUser();
}
