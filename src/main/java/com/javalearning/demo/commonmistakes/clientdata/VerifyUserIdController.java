package com.javalearning.demo.commonmistakes.clientdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/clientdata")
public class VerifyUserIdController {

    @GetMapping("/right")
    public void right(@LoginRequired Long userId){
        log.info("userId = {}", userId);
    }

    @PostMapping("/login")
    public boolean login(@RequestParam("userName") String userName,
                         @RequestParam("password") String password,
                         HttpServletRequest request){

        if (userName.equals("admin") && password.equals("admin")){
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", 1L);
            return true;
        }

        return false;

    }

}
