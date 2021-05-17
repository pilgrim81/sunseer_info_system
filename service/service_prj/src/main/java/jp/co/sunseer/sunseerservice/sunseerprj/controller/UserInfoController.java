package jp.co.sunseer.sunseerservice.sunseerprj.controller;


import jp.co.sunseer.sunseerservice.sunseerprj.entity.UserInfo;
import jp.co.sunseer.sunseerservice.sunseerprj.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Group B
 * @since 2021-05-17
 */
@RestController
@RequestMapping("/sunseerprj/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("findAll")
    public List<UserInfo> findAllUser(){
        return userInfoService.list(null);
    }

}

