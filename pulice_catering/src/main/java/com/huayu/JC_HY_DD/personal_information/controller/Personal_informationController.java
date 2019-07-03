package com.huayu.JC_HY_DD.personal_information.controller;

import com.huayu.JC_HY_DD.personal_information.service.impl.Personal_informationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Controller
@RequestMapping("/personal_information/personal-information")
public class Personal_informationController {
    @Autowired
    private Personal_informationServiceImpl informationService;


}
