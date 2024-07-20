package com.rookie.stack.datadesensitizationshowcase.logger;

import com.rookie.stack.datadesensitizationshowcase.enums.SensitiveStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author eumenides
 * @description
 * @date 2024/7/20
 */
public class SensitiveDataLogger {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveDataLogger.class);

    public static void info(String message) {
        logger.info(maskSensitiveData(message));
    }

    private static String maskSensitiveData(String message) {
        for (SensitiveStrategy strategy : SensitiveStrategy.values()) {
            message = strategy.desensitizer().apply(message);
        }
        return message;
    }
}