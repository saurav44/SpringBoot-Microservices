package com.learningmicroservice.user.controller;

import com.learningmicroservice.user.VO.ResponseTemplateVO;
import com.learningmicroservice.user.entity.User;
import com.learningmicroservice.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController.");
        return userService.saveUser(user);
    }

//    @GetMapping("/{id}")
//    public User findUserById(@PathVariable("id") Long userId) {
//        log.info("Inside findUserById method of UserController.");
//        return userService.findUserById(userId);
//    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment method of UserController.");
        return  userService.getUserWithDepartment(userId);
    }

}
