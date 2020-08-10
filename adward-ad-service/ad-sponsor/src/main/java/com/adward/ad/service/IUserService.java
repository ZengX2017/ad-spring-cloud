package com.adward.ad.service;

import com.adward.ad.exception.AdException;
import com.adward.ad.vo.CreateUserRequest;
import com.adward.ad.vo.CreateUserResponse;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
