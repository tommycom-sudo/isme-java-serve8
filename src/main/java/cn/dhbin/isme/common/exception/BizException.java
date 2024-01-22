package cn.dhbin.isme.common.exception;

import cn.dhbin.isme.common.response.BizResponseCode;

public class BizException extends RuntimeException{
    private final BizResponseCode code;

    public BizException(BizResponseCode bizResponseCode) {
        super(bizResponseCode.getMsg());
        this.code = bizResponseCode;
    }

    public BizException(BizResponseCode bizResponseCode, String msg) {
        super(msg);
        this.code = bizResponseCode;
    }
}
