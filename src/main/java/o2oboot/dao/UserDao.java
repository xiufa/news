package o2oboot.dao;

import o2oboot.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    int queryUserSignIn(@Param("email") String email, @Param("password")String password);
    int queryUserByEmail(@Param("email") String email);
    User queryUser(@Param("userId") Long userId);
    int updateUser(User user);
    List<User> queryAllUser();
    Long queryMaxUserId();
}
