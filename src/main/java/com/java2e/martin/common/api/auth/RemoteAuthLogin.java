package com.java2e.martin.common.api.auth;

import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 狮少
 * @version 1.0
 * @date 2021/8/6
 * @describtion RemoteAuthLogin
 * @since 1.0
 */
@FeignClient(contextId = "RemoteAuthLogin", name = ServiceNameConstants.MARTIN_BIZ_AUTH_SERVICE)
public interface RemoteAuthLogin {
    /**
     * 社交登录生成本系统的token
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/oauth/token?grant_type=password&username={username}&password={password}&grant_type=password&scope=select")
    Object socialLoginToken(@PathVariable("username") String username, @PathVariable("password") String password);
}
