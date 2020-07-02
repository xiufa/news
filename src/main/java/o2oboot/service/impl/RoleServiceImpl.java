package o2oboot.service.impl;

import o2oboot.dao.AccessRoleMapDao;
import o2oboot.dao.RoleDao;
import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;
import o2oboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public int addRole(Role role) {
        return roleDao.insertRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int deleteRole(Long roleId) {
        return roleDao.deleteRoleById(roleId);
    }

    @Override
    public int queryRole(Long roleId) {
        return roleDao.deleteRoleById(roleId);
    }

    @Override
    public int addRoleAccess(Role role, Access access) {
        //List<Access> accesses=roleDao.queryAccessList(role.getRoleId());
        List<Access> accesses=role.getAccesses();
        accesses.add(access);
        role.setAccesses(accesses);
        return roleDao.updateRole(role);
    }

    @Override
    public int deleteRoleAccess(Role role, Access access) {
        List<Access> accesses=role.getAccesses();
        for(int i=0;i<accesses.size();i++){
            Access a=accesses.get(i);
            if(access.getAccessId()==a.getAccessId()){
                accesses.remove(a);
            }
        }
        role.setAccesses(accesses);
        return roleDao.updateRole(role);
    }
}
