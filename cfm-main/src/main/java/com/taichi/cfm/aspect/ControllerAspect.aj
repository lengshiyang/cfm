package com.taichi.cfm.aspect;

import com.alibaba.fastjson.JSON;
import com.taichi.cfm.common.exception.ErrorCode;
import com.taichi.cfm.common.exception.ResultDto;
import com.taichi.cfm.common.exception.TaiChiException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by shiyang.leng
 * on 2019/05/30
 * ClassDescription：切面
 */
@Aspect
@Component
public class ControllerAspect {

    private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Around("execution(* com.taichi.cfm.controller..*.*(..))")
    public Object process(ProceedingJoinPoint jp) throws java.lang.Throwable {
        Object rvt = null;
        long startTime = System.currentTimeMillis();
        String ControllerClassName = jp.getTarget().getClass().getName();
        String methodInfo = ControllerClassName + "." + jp.getSignature().getName();
        logger.info("类名称:{}", ControllerClassName);
        ResultDto<Object> result = new ResultDto<Object>();
        try {
            rvt = jp.proceed();
        } catch (IllegalArgumentException e) {
            logger.error("参数错误, error={}", e.getMessage());
            result.setErrcode(ErrorCode.FAILED.getCode());
            result.setErrmsg(e.getMessage());
            result.setSuccess(false);
        } catch (TaiChiException e) {
            logger.error("业务处理异常:", e);
            result.setErrcode(e.getError());
            result.setErrmsg(e.getMessage());
            result.setSuccess(false);
        } catch (Exception e) {
            logger.error("系统异常:", e);
            result.setErrcode(ErrorCode.FAILED.getCode());
            result.setErrmsg(e.getMessage());
            result.setSuccess(false);
        }
        long endTime = System.currentTimeMillis();
        String returnInfo = JSON.toJSONString(rvt);
        long time = endTime - startTime;
        logger.info("方法结束:{}\n 返回结果:{} \n耗时:{}", methodInfo, returnInfo, time);
        if (null == rvt) {
            return result;
        }
        return rvt;
    }
}
