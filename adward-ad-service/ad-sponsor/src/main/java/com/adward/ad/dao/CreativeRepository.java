package com.adward.ad.dao;

import com.adward.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
public interface CreativeRepository extends JpaRepository<Creative, Long> {
}