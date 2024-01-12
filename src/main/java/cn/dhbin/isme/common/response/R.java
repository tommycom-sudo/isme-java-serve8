package cn.dhbin.isme.common.response;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R<H, T> {

    private H header;

    private T response;

    public static <H, T> R<H, T> ok(H header, T data){
        R<H, T> r = new R<>();
        r.setHeader(header);
        r.setResponse(data);
        return r;
    }
}
