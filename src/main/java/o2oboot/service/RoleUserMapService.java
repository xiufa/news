package o2oboot.service;

import o2oboot.entity.User;
import o2oboot.entity.access.Role;

public interface RoleUserMapService {
    int addRoleUserMap(Role role, User user);
    int deleteRoleUserMap(Role role,User user);
    int updateRoleUserMap(Role role, User user);
}
