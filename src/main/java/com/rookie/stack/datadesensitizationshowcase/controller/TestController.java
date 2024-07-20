package com.rookie.stack.datadesensitizationshowcase.controller;

import com.rookie.stack.datadesensitizationshowcase.logger.SensitiveDataLogger;
import com.rookie.stack.datadesensitizationshowcase.pojo.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eumenides
 * @description
 * @date 2024/7/20
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public Person test(){
        Person user = new Person();
        user.setRealName("小刘同学");
        user.setPhoneNumber(" 15129390011");
        user.setAddress("陕西省西安市雁塔区....");
        user.setIdCard("4333333333334334333");
        return user;
    }

    @GetMapping("/log")
    public String log() {
        SensitiveDataLogger.info("用户名: 张三, 身份证: 123456789012345678, 手机号: 13800138000, 地址: 北京市朝阳区幸福街123号");
        return "Logged";
    }
}
