package o2oboot.service;

import o2oboot.entity.access.Access;

public interface AccessService {
    int addAccess(Access access);
    int updateAccess(Access access);
    int deleteAccesss(Long accessId);
    int queryAccessById(Long accessId);
}
