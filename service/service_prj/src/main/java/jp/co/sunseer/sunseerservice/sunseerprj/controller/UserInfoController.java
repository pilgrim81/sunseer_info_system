package jp.co.sunseer.sunseerservice.sunseerprj.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jp.co.sunseer.commonutils.R;
import jp.co.sunseer.sunseerservice.sunseerprj.entity.UserInfo;
import jp.co.sunseer.sunseerservice.sunseerprj.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public R findAllUser(){
        List<UserInfo> list = userInfoService.list(null);
        return R.ok().data("item",list);
    }

    @ApiOperation(value = "IDよりユーザーを削除")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "ユーザーID", required = true)
            @PathVariable String id){
        userInfoService.removeById(id);
        return R.ok();
    }
}

