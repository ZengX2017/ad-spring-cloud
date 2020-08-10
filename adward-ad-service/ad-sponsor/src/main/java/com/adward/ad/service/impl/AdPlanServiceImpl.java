package com.adward.ad.service.impl;

import com.adward.ad.constant.CommonStatusEnum;
import com.adward.ad.constant.ConstantsEnum;
import com.adward.ad.dao.AdPlanRepository;
import com.adward.ad.dao.AdUserRepository;
import com.adward.ad.entity.AdPlan;
import com.adward.ad.entity.AdUser;
import com.adward.ad.exception.AdException;
import com.adward.ad.service.IAdPlanService;
import com.adward.ad.utils.CommonUtils;
import com.adward.ad.vo.AdPlanGetRequest;
import com.adward.ad.vo.AdPlanRequest;
import com.adward.ad.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
@Slf4j
@Service
public class AdPlanServiceImpl implements IAdPlanService{

    private final AdPlanRepository adPlanRepository;

    private final AdUserRepository adUserRepository;

    @Autowired
    public AdPlanServiceImpl(AdPlanRepository adPlanRepository,
                             AdUserRepository adUserRepository){
        this.adPlanRepository = adPlanRepository;
        this.adUserRepository = adUserRepository;
    }

    @Override
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {

        if (!request.createValidate()){
            throw new AdException(ConstantsEnum.REQUEST_PARAM_ERROR.getMessage());
        }

        Optional<AdUser> adUser = adUserRepository.findById(request.getId());
        if (!adUser.isPresent()){
            throw new AdException(ConstantsEnum.CAN_NOT_FIND_RECORD.getMessage());
        }

        AdPlan oldPlan = adPlanRepository.findByUserIdAndPlanName(request.getUserId(), request.getPlanName());
        if (oldPlan != null){
            throw new AdException(ConstantsEnum.SAME_NAME_PLAN_ERROR.getMessage());
        }

        AdPlan newAdPlan = adPlanRepository.save(
                new AdPlan(request.getUserId(), request.getPlanName(),
                        CommonUtils.parseStringDate(request.getStartDate()),
                        CommonUtils.parseStringDate(request.getEndDate()))
        );

        return new AdPlanResponse(newAdPlan.getId(), newAdPlan.getPlanName());
    }

    /**
     * TODO: 分页没有实现
     */
    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        if (!request.validate()){
            throw new AdException(ConstantsEnum.REQUEST_PARAM_ERROR.getMessage());
        }
        return adPlanRepository.findAllByIdInAndUserId(request.getIds(), request.getUserId());
    }

    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {
        if (!request.updateValidate()){
            throw new AdException(ConstantsEnum.REQUEST_PARAM_ERROR.getMessage());
        }

        AdPlan adPlan = adPlanRepository.findByIdAndUserId(request.getId(), request.getUserId());

        if (adPlan == null){
            throw new AdException(ConstantsEnum.CAN_NOT_FIND_RECORD.getMessage());
        }

        if (request.getPlanName() != null){
            adPlan.setPlanName(request.getPlanName());
        }

        if (request.getStartDate() != null){
            adPlan.setStartDate(
                    CommonUtils.parseStringDate(request.getStartDate())
            );
        }

        if (request.getEndDate() != null){
            adPlan.setEndDate(
                    CommonUtils.parseStringDate(request.getEndDate())
            );
        }

        adPlan.setUpdateTime(new Date());
        adPlan = adPlanRepository.save(adPlan);

        return new AdPlanResponse(adPlan.getId(), adPlan.getPlanName());
    }

    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {
        if (!request.deleteValidate()){
            throw new AdException(ConstantsEnum.REQUEST_PARAM_ERROR.getMessage());
        }

        AdPlan adPlan = adPlanRepository.findByIdAndUserId(request.getId(), request.getUserId());

        if (adPlan == null){
            throw new AdException(ConstantsEnum.CAN_NOT_FIND_RECORD.getMessage());
        }

        adPlan.setPlanStatus(CommonStatusEnum.INVALID.getCode());
        adPlan.setUpdateTime(new Date());
        adPlanRepository.save(adPlan);
    }
}
