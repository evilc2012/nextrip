package com.nextrip.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by EvilC on 2016/4/25.
 */

@Controller
public class StartController {

    private static final Logger logger = LoggerFactory.getLogger(StartController.class);

    //处理HEAD类型的”/”请求
    @RequestMapping(value={"/"},method= {RequestMethod.HEAD})
    public String head() {
        return "index";
    }

    //处理GET类型的"/index"和”/”请求
    @RequestMapping(value={"/index.html","/"},method= {RequestMethod.GET})
    public String index(Model model) throws Exception {
        logger.info("======processed by index=======");
        //返回msg参数
        model.addAttribute("msg", "Go Go Go!");
        return "index";
    }

}
