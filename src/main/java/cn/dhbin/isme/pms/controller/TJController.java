package cn.dhbin.isme.pms.controller;

import cn.dhbin.isme.pms.domain.dto.SrvOrgResponse;
import cn.dhbin.isme.pms.domain.request.SrvOrgRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tj")
@RequiredArgsConstructor
public class TJController {
    @PostMapping("/getSrvDetail1")
    public SrvOrgResponse getSrvDetail1(@RequestBody @Validated  SrvOrgRequest req){
        SrvOrgResponse  res  = new SrvOrgResponse();
        res.setItem("2222");
        res.setText("bbbbb");
        return res;

    }
}
