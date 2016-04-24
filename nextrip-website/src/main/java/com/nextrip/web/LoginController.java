package com.nextrip.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by EvilC on 2016/4/25.
 */

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @RequestMapping(value = "/login.html")
    public String loginPage() {
        return "login";
    }

}
