package com.fcg.bitop.api.otc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fcg.bitop.api.otc.entity.InternetAccount;
import com.fcg.bitop.api.otc.entity.req.InternetAccountReqDto;
import com.fcg.bitop.api.otc.entity.resp.InternetAccountRespDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InternetAccountService extends IService<InternetAccount> {

    /***
     * @Description: 添加/修改 网络账号信息
     * @Param: [internetAccountReqDto]
     * @return: com.ezcoins.response.Response
     * @Author: taylor
     * @Date: 2021/12/8
     */
    ResponseEntity<Void> addOrUpdateInternetAccount(InternetAccountReqDto internetAccountReqDto);


    /***
     * @Description: 修改 网络账号状态
     * @Param: [internetAccountReqDto]
     * @return: com.ezcoins.response.Response
     * @Author: taylor
     * @Date: 2021/12/8
     */
    ResponseEntity<Void> updateUserInternetAccountStatus(InternetAccountReqDto internetAccountReqDto);

    /**
     * 用户 网络账号列表
     * @param userId
     * @return List<InternetAccountRespDto>
     */
    List<InternetAccountRespDto> internetAccountList(String userId);
}
