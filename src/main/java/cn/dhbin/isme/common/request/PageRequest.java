package cn.dhbin.isme.common.request;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageRequest {
    private Integer pageNo = 1;
    private Integer pageSize = 10;

    public <T>IPage<T> toPage(){
        Page<T> page = new Page<>();
        page.setSize(pageSize);
        page.setMaxLimit(500L);
        page.setCurrent(pageNo);
        return page;
    }
}
