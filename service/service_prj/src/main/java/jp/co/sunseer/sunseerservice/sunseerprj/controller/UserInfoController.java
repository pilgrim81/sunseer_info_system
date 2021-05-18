package jp.co.sunseer.sunseerservice.sunseerprj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jp.co.sunseer.commonutils.R;
import jp.co.sunseer.sunseerservice.sunseerprj.entity.UserInfo;
import jp.co.sunseer.sunseerservice.sunseerprj.entity.vo.UserQuery;
import jp.co.sunseer.sunseerservice.sunseerprj.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    //1.全件取得する
    @ApiOperation(value = "ユーザー全件")
    @GetMapping("findAll")
    public R findAllUser(){
        List<UserInfo> list = userInfoService.list(null);
        return R.ok().data("item",list);
    }

    //ユーザーをロジック削除
    @ApiOperation(value = "IDよりユーザーを削除")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "ユーザーID", required = true)
            @PathVariable String id){
        boolean flag = userInfoService.removeById(id);
        if(flag){
            return R.ok();
        } else {
            return R.error();
        }
    }

    //3.ページング
    //current カレントページ
    //limit ページ毎に表示数
    @ApiOperation(value = "ページング")
    @GetMapping("pageUser/{current}/{limit}")
    public R pageListUsers(@PathVariable long current,
                           @PathVariable long limit) {
        //ページング　オブジェクト生成
        Page<UserInfo> pageTeacher = new Page<>(current,limit);

        //ページング実現
        userInfoService.page(pageTeacher,null);

        long total = pageTeacher.getTotal();//Total数
        List<UserInfo> records = pageTeacher.getRecords(); //ページングデータを取得

        return R.ok().data("total",total).data("rows",records);
    }

    //4.条件付き、ページング
    @ApiOperation(value = "検索条件付きページング")
    @PostMapping("pageUserCondition/{current}/{limit}")
    public R pageUsersCondition(@PathVariable long current,@PathVariable long limit,
                                @RequestBody(required = false) UserQuery userQuery) {
        //ページングオブジェクト生成
        Page<UserInfo> pageTeacher = new Page<>(current,limit);

        //条件作る
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();

        // 条件の組み合わせ
        String name = userQuery.getName();
        Integer age = userQuery.getAge();
        String email = userQuery.getEmail();

        //条件はNULLかを判断して、NULLではない場合、条件付き
        if(!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(age)) {
            wrapper.eq("age",age);
        }
        if(!StringUtils.isEmpty(email)) {
            wrapper.eq("email",email);
        }

        //ソート
        wrapper.orderByDesc("name");

        //条件検索
        userInfoService.page(pageTeacher,wrapper);

        long total = pageTeacher.getTotal();//トータルレコード数
        List<UserInfo> records = pageTeacher.getRecords(); //データList
        return R.ok().data("total",total).data("rows",records);
    }

    //5.ユーザー追加
    @ApiOperation(value = "ユーザー情報追加")
    @PostMapping("addUser")
    public R addUser(@RequestBody UserInfo userInfo) {
        System.out.println("================================");
        System.out.println(userInfo.getIsDeleted());
        boolean save = userInfoService.save(userInfo);
        if(save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //6.IDでUserを検索
    @ApiOperation(value = "IDよりユーザー情報を取得")
    @GetMapping("getUser/{id}")
    public R getUserByID(@PathVariable String id) {

        UserInfo userInfo = userInfoService.getById(id);
        return R.ok().data("userInfo",userInfo);
    }

    //7.ユーザー情報を更新
    @PostMapping("updateUser")
    public R updateUser(@RequestBody UserInfo userInfo) {
        boolean flag = userInfoService.updateById(userInfo);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}

