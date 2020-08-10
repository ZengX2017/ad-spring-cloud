package com.adward.ad.service.impl;

import com.adward.ad.dao.CreativeRepository;
import com.adward.ad.entity.Creative;
import com.adward.ad.service.ICreativeService;
import com.adward.ad.vo.CreativeRequest;
import com.adward.ad.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Adward_Z
 * @date 2020/8/10
 */
@Service
@Slf4j
public class CreativeServiceImpl implements ICreativeService {

    @Autowired
    private CreativeRepository creativeRepository;

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {
        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
