package com.wyq.emailcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description: //TODO
 * @Author wyq
 * @Date 2022/4/18 21:08
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//我们的实体类全部需要序列化！
public class User implements Serializable {
    private String name;
    private int age;
}
