package com.imooc.ad.search.impl;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.index.DataTable;
import com.imooc.ad.index.adunit.AdUnitIndex;
import com.imooc.ad.index.adunit.AdUnitObject;
import com.imooc.ad.index.creative.CreativeIndex;
import com.imooc.ad.index.creative.CreativeObject;
import com.imooc.ad.index.creativeunit.CreativeUnitIndex;
import com.imooc.ad.index.district.UnitDistrictIndex;
import com.imooc.ad.index.interest.UnitItIndex;
import com.imooc.ad.index.keyword.UnitKeywordIndex;
import com.imooc.ad.search.ISearch;
import com.imooc.ad.search.vo.SearchRequest;
import com.imooc.ad.search.vo.SearchResponse;
import com.imooc.ad.search.vo.feature.DistrictFeature;
import com.imooc.ad.search.vo.feature.FeatureRelation;
import com.imooc.ad.search.vo.feature.ItFeature;
import com.imooc.ad.search.vo.feature.KeywordFeature;
import com.imooc.ad.search.vo.media.AdSlot;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by Qinyi.
 */
@Slf4j
@Service
public class SearchImpl implements ISearch {

    @Override
    public SearchResponse fetchAds(SearchRequest request) {

        // 请求的广告位信息
        List<AdSlot> adSlots = request.getRequestInfo().getAdSlots();

        // 三个 Feature
        KeywordFeature keywordFeature =
                request.getFeatureInfo().getKeywordFeature();
        DistrictFeature districtFeature =
                request.getFeatureInfo().getDistrictFeature();
        ItFeature itFeature =
                request.getFeatureInfo().getItFeature();

        FeatureRelation relation = request.getFeatureInfo().getRelation();

        // 构造响应对象
        SearchResponse response = new SearchResponse();
        Map<String, List<SearchResponse.Creative>> adSlot2Ads =
                response.getAdSlot2Ads();

        for (AdSlot adSlot : adSlots) {

            Set<Long> targetUnitIdSet;

            // 根据流量类型获取初始 AdUnit
            Set<Long> adUnitIdSet = DataTable.of(
                    AdUnitIndex.class
            ).match(adSlot.getPositionType());
        }

        return null;
    }

}
