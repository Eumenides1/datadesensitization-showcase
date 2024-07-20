package com.rookie.stack.datadesensitizationshowcase.pojo;

import com.rookie.stack.datadesensitizationshowcase.annotation.Sensitive;
import com.rookie.stack.datadesensitizationshowcase.enums.SensitiveStrategy;
import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/7/20
 */
@Data
public class Person {
    /**
     * 真实姓名
     */
    @Sensitive(strategy = SensitiveStrategy.USERNAME)
    private String realName;
    /**
     * 地址
     */
    @Sensitive(strategy = SensitiveStrategy.ADDRESS)
    private String address;
    /**
     * 电话号码
     */
    @Sensitive(strategy = SensitiveStrategy.PHONE)
    private String phoneNumber;
    /**
     * 身份证号码
     */
    @Sensitive(strategy = SensitiveStrategy.ID_CARD)
    private String idCard;
}
