package com.fcg.bitop.api.otc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fcg.bitop.api.otc.entity.InternetAccount;
import com.fcg.bitop.api.otc.entity.req.InternetAccountReqDto;
import com.fcg.bitop.api.otc.entity.resp.InternetAccountRespDto;
import com.fcg.bitop.api.otc.mapper.InternetAccountMapper;
import com.fcg.bitop.api.otc.service.InternetAccountService;
import com.fcg.bitop.context.ContextHandler;
import com.fcg.bitop.util.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class InternetAccountServiceImpl extends ServiceImpl<InternetAccountMapper, InternetAccount> implements InternetAccountService {


    /**
     * 用户 网络账号列表
     *
     * @param
     * @return
     */
    @Override
    public List<InternetAccountRespDto> internetAccountList(String userId) {
        LambdaQueryWrapper<InternetAccount> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(EzPaymentBank::getBankName,withdrawalConfigId);
        lambdaQueryWrapper.eq(InternetAccount::getUserId, ContextHandler.getUserId());
        List<InternetAccount> lists = baseMapper.selectList(lambdaQueryWrapper);
        return BeanUtils.copyListProperties(lists, InternetAccountRespDto::new);
    }


    @Override
    public ResponseEntity<Void> addOrUpdateInternetAccount(InternetAccountReqDto internetAccountReqDto) {
        String userId = ContextHandler.getUserId();
        InternetAccount internetAccount = new InternetAccount();
        BeanUtils.copyProperties(internetAccount,internetAccountReqDto);
        internetAccount.setUserId(userId);
        if (StringUtils.isEmpty(internetAccountReqDto.getId())){
//            userWalletAddr.setCreateBy(userId);
            baseMapper.insert(internetAccount);
        }else {
//            userWalletAddr.setUpdateBy(userId);
            baseMapper.updateById(internetAccount);
        }
        return ResponseEntity.ok().build();
    }



    @Override
    public ResponseEntity<Void> updateUserInternetAccountStatus(InternetAccountReqDto internetAccountReqDto) {
        String userId = ContextHandler.getUserId();
        InternetAccount internetAccount = new InternetAccount();
        BeanUtils.copyProperties(internetAccount,internetAccountReqDto);
//        internetAccount.setUserId(userId);
        if (StringUtils.hasLength(internetAccountReqDto.getId())){
//            userWalletAddr.setUpdateBy(userId);
            baseMapper.updateById(internetAccount);
        }
        return ResponseEntity.ok().build();
    }

}
