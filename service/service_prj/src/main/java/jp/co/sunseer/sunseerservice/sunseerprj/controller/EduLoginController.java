package jp.co.sunseer.sunseerservice.sunseerprj.controller;

import jp.co.sunseer.commonutils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/user")
public class EduLoginController {
    //login
    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }
    //info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}