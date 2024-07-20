package com.rookie.stack.datadesensitizationshowcase.layout;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.rookie.stack.datadesensitizationshowcase.enums.SensitiveStrategy;

/**
 * @author eumenides
 * @description
 * @date 2024/7/20
 */
public class MaskingPatternLayout extends PatternLayout {
    @Override
    public String doLayout(ILoggingEvent event) {
        String message = super.doLayout(event);
        message = maskSensitiveData(message);
        return message;
    }

    private String maskSensitiveData(String message) {
        for (SensitiveStrategy strategy : SensitiveStrategy.values()) {
            message = strategy.desensitizer().apply(message);
        }
        return message;
    }
}
