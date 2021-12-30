package com.fcg.bitop.api.otc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fcg.bitop.api.otc.entity.OtcBankCard;
import com.fcg.bitop.api.otc.entity.resp.BankCardRespDto;
import com.fcg.bitop.api.otc.mapper.OtcBankCardMapper;
import com.fcg.bitop.api.otc.service.OtcBankCardService;
import com.fcg.bitop.util.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtcBankCardServiceImpl extends ServiceImpl<OtcBankCardMapper, OtcBankCard> implements OtcBankCardService {

    @Override
    public List<BankCardRespDto> userBankCardList(String userId) {
        LambdaQueryWrapper<OtcBankCard> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OtcBankCard::getUserId, userId);
        List<OtcBankCard> lists = baseMapper.selectList(lambdaQueryWrapper);
        return BeanUtils.copyListProperties(lists, BankCardRespDto::new);
    }
}
