package com.taichi.cfm.service.impl;

import com.taichi.cfm.common.utils.BeanUtil;
import com.taichi.cfm.domain.annotations.Condition;
import com.taichi.cfm.domain.model.BasicParamConfig;
import com.taichi.cfm.domain.repository.BasicParamConfigRepository;
import com.taichi.cfm.service.IBasicParamConfigService;
import com.taichi.cfm.service.dto.AddBasicParamConfigBO;
import com.taichi.cfm.service.dto.QueryBasicParamConfigBO;
import com.taichi.cfm.service.utils.ConditionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class BaseParamConfigServiceImpl implements IBasicParamConfigService {

	private static final Logger logger = LoggerFactory.getLogger(BaseParamConfigServiceImpl.class);

	@Resource
	private BasicParamConfigRepository basicParamConfigRepository;

	@Override
	public List<BasicParamConfig> findAll(){
		return basicParamConfigRepository.findAll();
	}

	@Override
	public Page<BasicParamConfig> page(QueryBasicParamConfigBO queryBasicParamConfigBO, Pageable pageRequest) {
		Condition<BasicParamConfig> queryCondition = new Condition<>();
		ConditionUtil.initCondition(queryCondition,queryBasicParamConfigBO);
		Sort sort = new Sort(Sort.Direction.DESC,"timeUpdate");
		Pageable pageable = new PageRequest(pageRequest.getPageNumber(), pageRequest.getPageSize(),sort);
		return basicParamConfigRepository.findAll(queryCondition, pageable);
	}

	@Override
	public void add(AddBasicParamConfigBO param){
		BasicParamConfig basicParamConfig = BeanUtil.copyProperties(param,BasicParamConfig.class);
		basicParamConfig.setOperatorCode("shiyang.leng");
		basicParamConfig.setTimeInsert(new Date());
		basicParamConfig.setTimeUpdate(new Date());
		basicParamConfigRepository.save(basicParamConfig);
	}

	@Override
	public void delete(BasicParamConfig param){
		basicParamConfigRepository.delete(param.getId());
	}

	@Override
	public void update(AddBasicParamConfigBO param){
		BasicParamConfig basicParamConfig = basicParamConfigRepository.findOne(param.getId());
		basicParamConfig.setType(param.getType());
		basicParamConfig.setMemo(param.getMemo());
		basicParamConfig.setParamCode(param.getParamCode());
		basicParamConfig.setParamValue(param.getParamValue());
		basicParamConfig.setSystemCode(param.getSystemCode());
		basicParamConfig.setOperatorCode("shiyang.leng");
		basicParamConfig.setTimeUpdate(new Date());
		basicParamConfigRepository.save(basicParamConfig);
	}
}
