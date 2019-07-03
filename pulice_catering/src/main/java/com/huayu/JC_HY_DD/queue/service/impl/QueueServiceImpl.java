package com.huayu.JC_HY_DD.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.JC_HY_DD.queue.entity.Queue;
import com.huayu.JC_HY_DD.queue.mapper.QueueMapper;
import com.huayu.JC_HY_DD.queue.service.IQueueService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@Service
public class QueueServiceImpl extends ServiceImpl<QueueMapper, Queue> implements IQueueService {
    public List<Queue> queryAll(Queue que){
        return baseMapper.queryAll(que);
    }
    public List<Queue> query(){
        return baseMapper.query();
    }
    public Queue toupdate(int id){
        return baseMapper.toupdate(id);
    }
    public boolean update(Queue queue){
        return baseMapper.update(queue);
    }
}
