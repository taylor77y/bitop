package com.fcg.bitop.api.otc.controller;

import com.fcg.bitop.api.otc.entity.req.InternetAccountReqDto;
import com.fcg.bitop.api.otc.entity.resp.InternetAccountRespDto;
import com.fcg.bitop.api.otc.service.InternetAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@Api(tags = "OTC模块-网络账号")
@RequestMapping("/otc/internetaccount")
public class OtcInternetAccountController  {


    @Autowired
    private InternetAccountService ezInternetAccountService;

    @ApiOperation(value = "网络账号列表")
//    @AuthToken
    @GetMapping("internetAccountList")
    public ResponseEntity<List<InternetAccountRespDto>> internetAccountList(){
        return new ResponseEntity<>(ezInternetAccountService.internetAccountList("123456"), HttpStatus.OK);
    }


    @ApiOperation(value = "添加/修改 网络账号信息")
//    @AuthToken
    @PostMapping("addOrUpdateInternetAccount")
//    @Log(title = "添加/修改 用户网络账号信息", businessType = BusinessType.INSERT, operatorType = OperatorType.MOBILE)
    public ResponseEntity<Void> addOrUpdateInternetAccount(@RequestBody @Valid InternetAccountReqDto internetAccountReqDto){
        return ezInternetAccountService.addOrUpdateInternetAccount(internetAccountReqDto);
    }

    @ApiOperation(value = "修改 网络账号状态")
//    @AuthToken
    @PostMapping("updateUserInternetAccountStatus")
//    @Log(title = "修改 网络账号状态", businessType = BusinessType.INSERT, operatorType = OperatorType.MOBILE)
    public ResponseEntity<Void> updateUserInternetAccountStatus(@RequestBody @Valid InternetAccountReqDto internetAccountReqDto){
        return ezInternetAccountService.updateUserInternetAccountStatus(internetAccountReqDto);
    }

}
