package jp.co.sunseer.sunseerservice.sunseerprj.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQuery {
    @ApiModelProperty(value = "名前、検索用")
    private String name;

    @ApiModelProperty(value = "年齢、検索用")
    private Integer age;

    @ApiModelProperty(value = "メアド、検索用")
    private String email;
}
