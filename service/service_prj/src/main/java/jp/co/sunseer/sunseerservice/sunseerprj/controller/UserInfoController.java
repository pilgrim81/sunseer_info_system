package jp.co.sunseer.sunseerservice.sunseerprj.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.sunseer.sunseerservice.sunseerprj.entity.UserInfo;
import jp.co.sunseer.sunseerservice.sunseerprj.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  コントローラー
 * </p>
 *
 * @author Group AB
 * @since 2021-05-17
 */
@Api(description = "ユーザー管理システム")
@RestController
@RequestMapping("/sunseerprj/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "ユーザー全件")
    @GetMapping("findAll")
    public List<UserInfo> findAllUser(){
        return userInfoService.list(null);
    }

}

