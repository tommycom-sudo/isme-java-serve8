package cn.dhbin.isme.pms.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.security.PrivateKey;

@Data
@TableName("role")
public class Role {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String code;

    private String name;

    private Boolean enable;

}
