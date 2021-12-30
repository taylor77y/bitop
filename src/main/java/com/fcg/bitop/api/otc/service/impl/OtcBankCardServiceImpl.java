package com.fcg.bitop.api.otc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fcg.bitop.api.otc.entity.OtcBankCard;
import com.fcg.bitop.api.otc.entity.req.BankCardReqDto;
import com.fcg.bitop.api.otc.entity.resp.BankCardRespDto;
import com.fcg.bitop.api.otc.mapper.OtcBankCardMapper;
import com.fcg.bitop.api.otc.service.OtcBankCardService;
import com.fcg.bitop.context.ContextHandler;
import com.fcg.bitop.util.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public ResponseEntity<Void> addOrUpdateUserBankCard(BankCardReqDto bankCardReqDto) {
        String userId = ContextHandler.getUserId();
        OtcBankCard paymentBank = new OtcBankCard();
        BeanUtils.copyProperties(paymentBank,bankCardReqDto);
        paymentBank.setUserId(userId);
        if (StringUtils.isEmpty(bankCardReqDto.getId())){
//            userWalletAddr.setCreateBy(userId);
            baseMapper.insert(paymentBank);
        }else {
//            userWalletAddr.setUpdateBy(userId);
            baseMapper.updateById(paymentBank);
        }
        return ResponseEntity.ok().build();
    }


    @Override
    public ResponseEntity<Void> updateUserBankCardStatus(BankCardReqDto bankCardReqDto) {
        String userId = ContextHandler.getUserId();
        OtcBankCard paymentBank = new OtcBankCard();
        BeanUtils.copyProperties(paymentBank,bankCardReqDto);
        paymentBank.setUserId(userId);
        if (StringUtils.hasLength(bankCardReqDto.getId())){
//            userWalletAddr.setCreateBy(userId);
            baseMapper.updateById(paymentBank);
        }
        return ResponseEntity.ok().build();
    }
}
