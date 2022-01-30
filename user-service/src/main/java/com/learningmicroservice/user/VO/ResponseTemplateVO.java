package com.learningmicroservice.user.VO;

import com.learningmicroservice.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {       // vo - value object

    private User user;
    private Department department;
}
