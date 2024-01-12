package cn.dhbin.isme.common.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Header {
    public Header(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    String code;

    String msg;
}
