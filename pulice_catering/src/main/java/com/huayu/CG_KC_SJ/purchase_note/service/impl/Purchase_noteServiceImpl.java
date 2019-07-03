package com.huayu.CG_KC_SJ.purchase_note.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.CG_KC_SJ.purchase_note.entity.Purchase_note;
import com.huayu.CG_KC_SJ.purchase_note.mapper.Purchase_noteMapper;
import com.huayu.CG_KC_SJ.purchase_note.service.IPurchase_noteService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Purchase_noteServiceImpl extends ServiceImpl<Purchase_noteMapper, Purchase_note> implements IPurchase_noteService {
    @Autowired
    private Purchase_noteMapper purchase_noteMapper;

    public List<Purchase_note> query(Purchase_note purchase_note) {
        return purchase_noteMapper.query(purchase_note);

    }
}
