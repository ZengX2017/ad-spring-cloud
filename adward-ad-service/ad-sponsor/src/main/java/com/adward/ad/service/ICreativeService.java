package com.adward.ad.service;

import com.adward.ad.vo.CreativeRequest;
import com.adward.ad.vo.CreativeResponse;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
public interface ICreativeService {
    CreativeResponse createCreative(CreativeRequest request);
}
