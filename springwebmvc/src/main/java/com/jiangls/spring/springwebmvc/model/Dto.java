package com.jiangls.spring.springwebmvc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Jiangls
 * @date 2023/2/28
 */
public class Dto {
    @NotBlank(message = "id不能为空")
    private String id;
    @NotBlank(message = "name不能为空")
    private String name;
    @NotNull(message = "dt不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime dt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dt=" + dt +
                '}';
    }
}
