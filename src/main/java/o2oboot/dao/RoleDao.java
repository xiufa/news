package o2oboot.dao;

import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;

import java.util.List;

public interface RoleDao {
    int insertRole(Role role);
    //TODO 增删改查role
    Role queryRoleById(Long roleId);
    int deleteRoleById(Long roleId);
    int updateRole(Role role);
    //返回role表中的List<Access> accesses中的值
}
