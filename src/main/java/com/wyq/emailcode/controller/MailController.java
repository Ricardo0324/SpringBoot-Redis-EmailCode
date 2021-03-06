package com.wyq.emailcode.controller;

import com.wyq.emailcode.common.ResultJson;
import com.wyq.emailcode.service.MailService;
import com.wyq.emailcode.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.TimeUnit;

/**
 * @ClassName MailController
 * @Description: //TODO 邮件
 * @Author wyq
 * @Date 2022/4/18 21:47
 */
@RestController
@RequestMapping("api/email")
public class MailController {
    @Autowired
    private MailService mailService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //发送邮箱验证码
    @GetMapping("send/{email}")
    public ResultJson sendEmail(@PathVariable String email) {
        //key 邮箱号  value 验证码
        String code = redisTemplate.opsForValue().get(email);
        //从redis获取验证码，如果获取获取到，返回ok
        if (!StringUtils.isEmpty(code)) {
            return ResultJson.success();
        }
        //如果从redis获取不到，生成新的6位验证码
        code = RandomUtil.getSixBitRandom();
        //调用service方法，通过邮箱服务进行发送
        boolean isSend = mailService.sendMail(email, code);
        //生成验证码放到redis里面，设置有效时间为5分钟
        if (isSend) {
            redisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES);
            return ResultJson.success();
        } else {
            return ResultJson.error();
        }
    }
}

