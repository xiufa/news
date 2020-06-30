package o2oboot.service;

import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;

public interface RoleService {
    int addRole(Role role);
    int updateRole(Role role);

    int addRoleAccess(Role role, Access access);
    int deleteRoleAccess(Role role, Access access);


}
