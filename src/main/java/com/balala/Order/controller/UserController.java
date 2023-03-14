package com.balala.Order.controller;


import com.balala.Order.Utils.SMSUtils;
import com.balala.Order.Utils.ValidateCodeUtils;
import com.balala.Order.common.R;
import com.balala.Order.entity.User;
import com.balala.Order.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
   @Autowired
    private UserService userService;


    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession httpSession){
        //获取手机号
        String phone = user.getPhone();

        if(StringUtils.isNotEmpty(phone)){
        //生成四位的验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();

            log.info(code);
            //调用api发送短信
//            SMSUtils.sendMessage("测试","",phone,code);

        //存起来
            httpSession.setAttribute(phone,code);
            return R.success("短信发送成功");
        }

        return R.error("短信发送失败");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map,HttpSession session){

        log.info(map.toString());

        String phone = map.get("phone").toString();

        String code = map.get("code").toString();

        Object attribute = session.getAttribute(phone);

        if(attribute!=null && attribute.equals(code)){

            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);

            User user = userService.getOne(queryWrapper);



            if(user == null){
//                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }

            session.setAttribute("user",user.getId());
            return R.success(user);
        }


        return R.error("登录失败");
    }

}
