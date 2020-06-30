package o2oboot.dao;

import o2oboot.entity.access.Access;

public interface AccessDao {

    int insertAccess(Access access);
    Access queryAccessByUrl(String url);
    //TODO 增删改查access
}
