package com.rookie.stack.datadesensitizationshowcase.aspect;

import com.rookie.stack.datadesensitizationshowcase.enums.SensitiveStrategy;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author eumenides
 * @description
 * @date 2024/7/20
 */
@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.rookie.stack..*(..))")
    public void logBefore() {
        // 在方法执行前处理日志脱敏逻辑
    }

    @AfterReturning(pointcut = "execution(* com.rookie.stack..*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        if (result != null) {
            String resultStr = result.toString();
            String maskedResult = maskSensitiveData(resultStr);
            logger.info("方法返回值: " + maskedResult);
        }
    }

    private String maskSensitiveData(String message) {
        for (SensitiveStrategy strategy : SensitiveStrategy.values()) {
            message = strategy.desensitizer().apply(message);
        }
        return message;
    }
}
