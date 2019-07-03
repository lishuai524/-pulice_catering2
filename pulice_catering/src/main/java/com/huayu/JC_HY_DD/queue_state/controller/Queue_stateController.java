package com.huayu.JC_HY_DD.queue_state.controller;

import com.huayu.JC_HY_DD.queue_state.service.impl.Queue_stateServiceImpl;
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
@RequestMapping("/queue_state/queue-state")
public class Queue_stateController {
    @Autowired
    private Queue_stateServiceImpl stateService;
}
