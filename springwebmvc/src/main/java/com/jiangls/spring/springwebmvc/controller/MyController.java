package com.jiangls.spring.springwebmvc.controller;

import com.jiangls.spring.springwebmvc.model.Dto;
import com.jiangls.spring.springwebmvc.model.Vo;
import org.springframework.context.ApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.time.LocalDateTime;

/**
 * @author Jiangls
 * @date 2023/2/23
 */
@RestController
@RequestMapping("my")
public class MyController {

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("hello")
    public Vo hello(@RequestParam(value = "key", required = false) String key,
                        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(value = "dt", required = false) LocalDateTime dt,
                        @RequestBody Dto dto,
                        @RequestHeader(value = "head", required = false) String head,
                        ServletRequest req,
                        ServletResponse resp) {
        System.out.println("key: " + key);
        System.out.println("dt: " + dt);
        System.out.println("dto: " + dto.toString());
        System.out.println("head: " + head);
        System.out.println("req: " + req);
        System.out.println("resp: " + resp);

        Vo vo = new Vo();
        vo.setId(dto.getId());
        vo.setName(dto.getName());
        vo.setDt(dto.getDt());
        return vo;
    }

    @PostMapping("hello1")
    public String hello1(@RequestBody Dto dto) {
        System.out.println("dto: " + dto.toString());

        return "success";
    }

    /**
     * 发生异常
     */
    @GetMapping("exception")
    public Vo exception(@RequestParam(value = "key", required = false) String key) {
        if (true) {
            throw new RuntimeException("异常");
        }

        return new Vo();
    }
}
