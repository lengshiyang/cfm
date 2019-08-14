package com.taichi.cfm.controller;

import com.taichi.cfm.common.exception.ResultDto;
import com.taichi.cfm.domain.model.BasicParamConfig;
import com.taichi.cfm.service.IBasicParamConfigService;
import com.taichi.cfm.service.dto.AddBasicParamConfigBO;
import com.taichi.cfm.service.dto.QueryBasicParamConfigBO;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/baseConfig")
public class BasicParamConfigController {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(BasicParamConfigController.class);

    @Resource
    private IBasicParamConfigService basicParamConfigService;

    @RequestMapping(value="/pageQuery", method={RequestMethod.GET, RequestMethod.POST})
    public ResultDto<Page<BasicParamConfig>> pageQuery(@RequestBody QueryBasicParamConfigBO queryBasicParamConfigBO,
                                                                                 Integer page, Integer pageSize ) {
        Pageable pageable = new PageRequest(page-1,pageSize);
        Page<BasicParamConfig> pageResult = basicParamConfigService.page(queryBasicParamConfigBO,pageable);
        return new ResultDto<Page<BasicParamConfig>>(pageResult);
    }

    @RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
    public ResultDto add(@RequestBody AddBasicParamConfigBO param, HttpServletRequest request) {
        basicParamConfigService.add(param);
        return new ResultDto<>();
    }

    @RequestMapping(value="/update", method={RequestMethod.GET, RequestMethod.POST})
    public ResultDto update(@RequestBody AddBasicParamConfigBO param, HttpServletRequest request) {
        basicParamConfigService.update(param);
        return new ResultDto<>();
    }

    @RequestMapping(value="/delete", method={RequestMethod.GET, RequestMethod.POST})
    public ResultDto delete(@RequestBody BasicParamConfig param) {
        basicParamConfigService.delete(param);
        return new ResultDto<>();
    }
}
