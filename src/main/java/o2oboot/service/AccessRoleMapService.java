package o2oboot.service;

import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;

public interface AccessRoleMapService {
    int addAccessRoleMap(Access access, Role role);
    int deleteAccessRoleMap(Access access,Role role);
}
