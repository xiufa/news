package o2oboot.dao;

import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;
import o2oboot.entity.access.User;

public interface RoleUserMapDao {
    int addRoleUserMap(Role role, User user);
    int deleteRoleUserMap(Role role,User user);
    int updateRoleUserMap(Role role, User user);
}

