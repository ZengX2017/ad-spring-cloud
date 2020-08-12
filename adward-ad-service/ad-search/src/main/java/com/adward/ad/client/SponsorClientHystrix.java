package com.adward.ad.client;

import com.adward.ad.client.vo.AdPlan;
import com.adward.ad.client.vo.AdPlanGetRequest;
import com.adward.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Adward_Z
 * 断路器
 * @date 2020/8/12
 */
@Component
public class SponsorClientHystrix implements SponsorClient {

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(
            AdPlanGetRequest request) {
        return new CommonResponse<>(-1,
                "eureka-client-ad-sponsor error");
    }
}
