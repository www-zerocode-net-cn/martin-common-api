package com.java2e.martin.common.api.ncnb;

import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2022/4/10 10:37 下午
 * @describtion: RemoteNcnbLoginSocketIO
 */
@FeignClient(contextId = "remoteNcnbLoginSocketIO", name = ServiceNameConstants.MARTIN_BIZ_NCNB_SERVICE)
public interface RemoteNcnbLoginSocketIO {
    /**
     * 发送社交登录成功信息
     *ø
     * @param params
     * @return R
     */
    @PostMapping("/social/login/success")
    R sendSocialLoginSuccessInfo(@RequestParam Map params);
}
