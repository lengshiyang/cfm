package com.taichi.cfm.service;

import com.taichi.cfm.domain.model.BasicParamConfig;
import com.taichi.cfm.service.dto.AddBasicParamConfigBO;
import com.taichi.cfm.service.dto.QueryBasicParamConfigBO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IBasicParamConfigService {
    List<BasicParamConfig> findAll();

    /**
     * 分页查询基础参数配置
     * @param queryBasicParamConfigBO
     * @param pageRequest
     * @return
     */
    Page<BasicParamConfig> page(QueryBasicParamConfigBO queryBasicParamConfigBO, Pageable pageRequest);

    void add(AddBasicParamConfigBO param);

    void update(AddBasicParamConfigBO param);

    void delete(BasicParamConfig param);
}
