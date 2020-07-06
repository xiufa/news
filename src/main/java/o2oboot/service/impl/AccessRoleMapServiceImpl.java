package o2oboot.service.impl;

import o2oboot.dao.AccessRoleMapDao;
import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;
import o2oboot.service.AccessRoleMapService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccessRoleMapServiceImpl implements AccessRoleMapService {
    @Autowired
    private AccessRoleMapDao accessRoleMapDao;
    @Override
    public int addAccessRoleMap(Access access, Role role) {
        return accessRoleMapDao.addAccessRoleMap(access,role);
    }

    @Override
    public int deleteAccessRoleMap(Access access, Role role) {
        return accessRoleMapDao.deleteAccessRoleMap(access,role);
    }
}
