package o2oboot.dao;

import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;

public interface AccessRoleMapDao {
    int addAccessRoleMap(Access access, Role role);
    int deleteAccessRoleMap(Access access,Role role);
}
