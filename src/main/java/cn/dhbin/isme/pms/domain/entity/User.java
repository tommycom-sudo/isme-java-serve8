package cn.dhbin.isme.pms.domain.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("\"USER\"")
public class User {
    @TableId(type = IdType.AUTO)
    private  Long id;

    private String username;
    private String password;
    private Boolean enable;
    @TableField("createTime")
    private LocalDateTime createTime;
    @TableField("createTime")
    private LocalDateTime updateTime;
}
