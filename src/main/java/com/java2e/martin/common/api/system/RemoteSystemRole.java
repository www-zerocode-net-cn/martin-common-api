package com.java2e.martin.common.api.system;

import com.java2e.martin.common.api.dto.ProjectUserDto;
import com.java2e.martin.common.api.dto.RoleUserDto;
import com.java2e.martin.common.bean.system.Role;
import com.java2e.martin.common.bean.system.User;
import com.java2e.martin.common.core.api.R;
import com.java2e.martin.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author 狮少
 * @version 1.0
 * @date 2019/9/2
 * @describtion RemoteSystemRole, system 模块对外提供的示例服务
 * @since 1.0
 */
@FeignClient(contextId = "remoteSystemRole", name = ServiceNameConstants.MARTIN_BIZ_SYSTEM_SERVICE)
public interface RemoteSystemRole {

    /**
     * 增加角色
     *
     * @param role
     * @return R
     */
    @PostMapping("/role/register")
    R<List<Role>> register(@RequestBody List<Role> roles);


    /**
     * 分页获取角色下用户
     *
     * @param projectUser
     * @return
     */
    @GetMapping("/role/users")
    R roleUsers(@SpringQueryMap ProjectUserDto projectUser);

    /**
     * 保存用户角色
     *
     * @param roleUserDto
     * @return
     */
    @PostMapping("/role/users")
    R saveRoleUsers(@RequestBody RoleUserDto roleUserDto);

    /**
     * 删除角色下用户
     *
     * @param roleUserDto
     * @return
     */
    @DeleteMapping("/role/users")
    R delRoleUsers(@RequestBody RoleUserDto roleUserDto);

    /**
     * 获取角色权限
     *
     * @param roleId
     * @return
     */
    @GetMapping("/role/permission")
    R rolePermission(@RequestParam("roleId") String roleId);

    @PostMapping("/saveCheckedOperations")
    R saveCheckedOperations(@RequestBody Map map);

    /**
     * 查询角色被授予的权限码
     *
     * @param roleId
     * @return
     */
    @GetMapping("/role/roleCheckedPermission")
    R roleCheckedPermission(@RequestParam("roleId") String roleId);



}
