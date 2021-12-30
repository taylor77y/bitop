package com.fcg.bitop.api.otc.controller;

import com.fcg.bitop.api.otc.entity.resp.BankCardRespDto;
import com.fcg.bitop.api.otc.service.OtcBankCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "OTC-用户银行卡模块")
@RequestMapping("/otc/bankcard")
public class OtcBankCardController {


    @Autowired
    private OtcBankCardService otcBankCardService;

    @ApiOperation(value = "用户银行卡列表")
//    @AuthToken
    @GetMapping("userBankCardList")
    public ResponseEntity<List<BankCardRespDto>> userBankCardList(){
        List<BankCardRespDto> results = otcBankCardService.userBankCardList("123456");
        return new ResponseEntity<>(results, HttpStatus.OK);
    }


//    @ApiOperation(value = "添加/修改 用户银行卡信息")
//    @AuthToken
//    @PostMapping("addOrUpdateUserBankCard")
//    @Log(title = "添加/修改 用户银行卡信息", businessType = BusinessType.INSERT, operatorType = OperatorType.MOBILE)
//    public Response addOrUpdateUserBankCard(@RequestBody @Valid UserBankCardAddrReqDto bankCardReqDto){
//        return ezPaymentBankService.addOrUpdateUserBankCard(bankCardReqDto);
//    }


//    @ApiOperation(value = "修改用户 银行卡 状态")
//    @AuthToken
//    @PostMapping("updateUserBankCardStatus")
//    @Log(title = "修改用户 银行卡 状态", businessType = BusinessType.INSERT, operatorType = OperatorType.MOBILE)
//    public Response updateUserBankCardStatus(@RequestBody @Valid UserBankCardAddrReqDto bankCardReqDto){
//        return ezPaymentBankService.updateUserBankCardStatus(bankCardReqDto);
//    }
}
