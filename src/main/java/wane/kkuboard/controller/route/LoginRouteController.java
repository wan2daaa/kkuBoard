package wane.kkuboard.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginRouteController {

    @RequestMapping()
    public String login() {
        return "login/login";
    }

    @RequestMapping("/join01")
    public String join01() {
        return "login/join01";
    }

    @RequestMapping("/join02")
    public String join02() {
        return "login/join02";
    }

    @RequestMapping("/join03")
    public String join03() {
        return "login/join03";
    }

    @RequestMapping("/join_ok")
    public String joinOk() {
        return "login/join_ok";
    }

    @RequestMapping("/reset_pw")
    public String resetPw() {
        return "login/reset_pw";
    }

    @RequestMapping("/self_certification")
    public String selfCertification() {
        return "login/self_certification";
    }
}
