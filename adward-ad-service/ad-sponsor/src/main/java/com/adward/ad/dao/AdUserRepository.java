package com.adward.ad.dao;

import com.adward.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {
    /**
     * <h2>根据用户名查找用户记录</h2>
     * */
    AdUser findByUsername(String username);
}
