package jp.co.sunseer.sunseerservice.sunseerprj.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Group AB
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserInfoオブジェクト", description="ユーザー情報")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主キーID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "名前")
    private String name;

    @ApiModelProperty(value = "年齢")
    private Integer age;

    @ApiModelProperty(value = "メアド")
    private String email;

//    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "ロジック削除")
    @TableLogic
    private Boolean isDeleted;


}
