package com.adward.ad.service.impl;

import com.adward.ad.constant.ConstantsEnum;
import com.adward.ad.dao.AdUserRepository;
import com.adward.ad.entity.AdUser;
import com.adward.ad.exception.AdException;
import com.adward.ad.service.IUserService;
import com.adward.ad.utils.CommonUtils;
import com.adward.ad.vo.CreateUserRequest;
import com.adward.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository adUserRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository adUserRepository) {
        this.adUserRepository = adUserRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {

        if (!request.validate()){
            throw new AdException(ConstantsEnum.REQUEST_PARAM_ERROR.getMessage());
        }

        AdUser oldUser = adUserRepository.findByUsername(request.getUsername());

        if (oldUser != null){
            throw new AdException(ConstantsEnum.SAME_NAME_USER_ERROR.getMessage());
        }

        AdUser newUser = adUserRepository.save(new AdUser(
                request.getUsername(), CommonUtils.md5(request.getUsername())
        ));

        return new CreateUserResponse(newUser.getId(), newUser.getUsername(), newUser.getToken(),
                newUser.getCreateTime(), newUser.getUpdateTime());
    }
}
