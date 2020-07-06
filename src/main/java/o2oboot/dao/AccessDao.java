package o2oboot.dao;

import o2oboot.entity.access.Access;

import java.util.List;

public interface AccessDao {

    int insertAccess(Access access);
    Access queryAccessByUrl(String url);
    //TODO 增删改查access
    Access queryAccessById(Long accessId);
    int updateAccess(Access access);
    int deleteAccess(Long accessId);
    List<Access>queryAllAccess();
}
