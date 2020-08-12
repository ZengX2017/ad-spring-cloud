package com.adward.ad.client;

import com.adward.ad.client.vo.AdPlan;
import com.adward.ad.client.vo.AdPlanGetRequest;
import com.adward.ad.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Adward_Z
 * feign调用
 * @date 2020/8/12
 */
@FeignClient(value = "eureka-client-ad-sponsor",
        // 服务降级，一旦adSponsor服务发生错误或者不可用会调用SponsorClientHystrix
        fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    @RequestMapping(value = "/ad-sponsor/get/adPlan",
            method = RequestMethod.POST)
    CommonResponse<List<AdPlan>> getAdPlans(
            @RequestBody AdPlanGetRequest request);
}
