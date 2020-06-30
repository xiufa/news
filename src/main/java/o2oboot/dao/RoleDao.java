package o2oboot.dao;

import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;

public interface RoleDao {
    int insertRole(Role role);
    //TODO 增删改查role

    Role queryRoleById(Long roleId);





}
