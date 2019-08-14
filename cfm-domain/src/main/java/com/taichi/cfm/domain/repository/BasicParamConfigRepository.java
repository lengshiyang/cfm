package com.taichi.cfm.domain.repository;

import com.taichi.cfm.domain.data.BaseRepository;
import com.taichi.cfm.domain.model.BasicParamConfig;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p> 基础参数配置Repository </p>
 */
@Repository
public interface BasicParamConfigRepository extends BaseRepository<BasicParamConfig, Long> {

    BasicParamConfig findByParamCode(String ParamCode);

    List<BasicParamConfig> findByType(String type);
}
