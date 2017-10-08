package com.larrylian.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lianjw22529 08/10/2017
 */
@Controller
public class LogController {
    private static Logger log = LoggerFactory.getLogger(LogController.class);
    @ResponseBody
    @RequestMapping("log/test")
    public String test() {
        Exception e = new Exception("这是个异常信息");
        log.error("打印错误信息", e);
        log.debug("这是个debug日志");
        return "日志打印成功";
    }
    @ResponseBody
    @RequestMapping("log/logger")
    public String logger() {
        Logger log2 = LoggerFactory.getLogger("com.larrylian.testLogger");
        Logger logController = LoggerFactory.getLogger("com.larrylian.demo.controller.LogController");
        log2.info("其他Logger日志测试");
        logController.info("logController 测试");
        System.out.println("log2 : " + log2.toString());
        System.out.println("logConntroller : " + logController);
        System.out.println("log : " + log);
        if (logController == log) {
            System.out.println("同个命名的logger是单例");
        } else {
            System.out.println("同个命名的logger不是单例");
        }
        return "logger测试成功";
    }
}
