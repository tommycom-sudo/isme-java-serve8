package cn.dhbin.isme.common.response;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R<T> {
    private T data;
    private int code;
    private String message;


//    public static <H, T> R<H, T> ok(H header, T data){
//        R<H, T> r = new R<>();
//        r.setHeader(header);
//        r.setResponse(data);
//        return r;
//    }
    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setData(data);
        r.setCode(BizResponseCode.OK.getCode());
        r.setMessage(BizResponseCode.OK.getMsg());
        return r;
    }
}
