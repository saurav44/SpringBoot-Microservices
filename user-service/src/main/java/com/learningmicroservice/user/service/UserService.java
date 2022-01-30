package com.learningmicroservice.user.service;

import com.learningmicroservice.user.VO.Department;
import com.learningmicroservice.user.VO.ResponseTemplateVO;
import com.learningmicroservice.user.entity.User;
import com.learningmicroservice.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService.");
        return userRepository.save(user);
    }

//    public User findUserById(Long userId) {
//        log.info("Inside findUserById method of UserService.");
//        return userRepository.findUserById(userId);
//    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService.");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        System.out.println(user);

        // To get the department, we need to call the Department Microservice
        // For that RestTemplate is needed in MainClass
        Department department =
                // url should be - http://........
                // restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
                // Department.class);

                // after Service Registry
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                        Department.class);


        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
