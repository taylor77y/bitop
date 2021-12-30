package com.fcg.bitop.api.otc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fcg.bitop.api.otc.entity.OtcBankCard;
import com.fcg.bitop.api.otc.entity.resp.BankCardRespDto;

import java.util.List;

public interface OtcBankCardService extends IService<OtcBankCard> {


    List<BankCardRespDto> userBankCardList(String userId);
}
