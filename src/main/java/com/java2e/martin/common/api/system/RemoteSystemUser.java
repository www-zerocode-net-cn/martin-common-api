package com.java2e.martin.common.api.system;

import com.java2e.martin.common.api.dto.ProjectUserDto;
import com.java2e.martin.common.api.dto.RoleUserDto;
import com.java2e.martin.common.api.dto.UserDto;
import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.common.bean.system.vo.PrivilegeVO;
import com.java2e.martin.common.bean.system.vo.UserRolePrivilegeVo;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/9/2
 * @describtion RemoteSystemUser, system 模块对外提供的示例服务
 * @since 1.0
 */
@FeignClient(contextId = "remoteSystemUser", name = ServiceNameConstants.MARTIN_BIZ_SYSTEM_SERVICE)
public interface RemoteSystemUser {
    /**
     * 获取用户、权限、菜单
     *
     * @param username
     * @return
     */
    @GetMapping("/user/loadUserByUsername/{username}")
    R<UserRolePrivilegeVo> loadUserByUsername(@PathVariable("username") String username);

    /**
     * 查询所有权限信息
     *
     * @return
     */
    @GetMapping("/user/loadDynamicSecurity")
    R<Set<PrivilegeVO>> loadSecurity();

    /**
     * 根据 openid 查询用户
     *
     * @param params
     * @return R
     */
    @GetMapping("/user/getUserByWechatOpenId")
    User getUserByWechatOpenid(@RequestParam Map params);

    /**
     * 新用户注册并授权
     *
     * @param params
     * @return R
     */
    @PostMapping("/user/social/register")
    R<User> register(@RequestBody User user);

    /**
     * 分页获取系统中的用户
     *
     * @param projectUser
     * @return
     */
    @PostMapping("/users")
    R users(@RequestBody ProjectUserDto projectUser);

    /**
     * 注册新用户
     *
     * @param userDto
     * @return
     */
    @PostMapping("/user/register")
    R userRegister(@Validated @RequestBody UserDto userDto);

    /**
     * 分页获取一批角色的用户名和邮箱
     * @param roleIds
     * @return
     */
    @PostMapping("/approval/users")
    R getApprovalUser(@RequestBody List<String> roleIds);

    @GetMapping("/totalUser")
    R totalUser();


}
