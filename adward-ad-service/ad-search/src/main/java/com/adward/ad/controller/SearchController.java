package com.adward.ad.controller;

import com.adward.ad.annotation.IgnoreResponseAdvice;
import com.adward.ad.client.SponsorClient;
import com.adward.ad.client.vo.AdPlan;
import com.adward.ad.client.vo.AdPlanGetRequest;
import com.adward.ad.vo.CommonResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Adward_Z
 * @date 2020/8/12
 */
@Slf4j
@RestController
public class SearchController {

//    private final ISearch search;

    private final RestTemplate restTemplate;

    private final SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate,
                            SponsorClient sponsorClient){//, ISearch search) {
        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
//        this.search = search;
    }

//    @PostMapping("/fetchAds")
//    public SearchResponse fetchAds(@RequestBody SearchRequest request) {
//
//        log.info("ad-search: fetchAds -> {}",
//                JSON.toJSONString(request));
//        return search.fetchAds(request);
//    }

    @IgnoreResponseAdvice
    @PostMapping("/getAdPlans")
    public CommonResponse<List<AdPlan>> getAdPlans(
            @RequestBody AdPlanGetRequest request
    ) {
        log.info("ad-search: getAdPlans -> {}",
                JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }

    /**
     * Ribbon调用微服务
     * @param request
     * @return
     */
    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlansByRibbon")
    public CommonResponse<List<AdPlan>> getAdPlansByRebbon(
            @RequestBody AdPlanGetRequest request
    ) {
        log.info("ad-search: getAdPlansByRibbon -> {}",
                JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class
        ).getBody();
    }
}