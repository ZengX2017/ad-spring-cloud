package com.adward.ad.service;

import com.adward.ad.entity.AdPlan;
import com.adward.ad.exception.AdException;
import com.adward.ad.vo.AdPlanGetRequest;
import com.adward.ad.vo.AdPlanRequest;
import com.adward.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
public interface IAdPlanService {

    /**
     * 创建推广计划
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
