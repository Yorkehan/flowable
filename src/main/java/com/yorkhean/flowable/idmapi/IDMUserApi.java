package com.yorkhean.flowable.idmapi;

import org.flowable.idm.api.*;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName IDMUserApi
 * @Description 组织架构
 * @Author yorkehan
 * @Date 2019/4/11 21:46
 */

public class IDMUserApi {

    @Autowired
    IdmIdentityService idmIdentityService;
    @Autowired
    IdmManagementService idmManagementService;

    /**
     * @Description 添加用户
     * @Author yorkehan
     * @Params []
     * @Date 2019/4/11
     */
    public void testAddUser(){
        UserEntityImpl userEntity = new UserEntityImpl();
        userEntity.setId("yorkehan");
        userEntity.setDisplayName("yorkehan");
        userEntity.setEmail("740081506@qq.com");
        userEntity.setPassword("111111");
//        设置版本号
        userEntity.setRevision(0);
        idmIdentityService.saveUser(userEntity);
    }

    /**
     * @Description 添加组
     * @Author yorkehan
     * @Params
     * @Date 2019/4/11
     */
    public void testAddGroup(){
        GroupEntityImpl groupEntity = new GroupEntityImpl();
        groupEntity.setName("研发部");
        groupEntity.setId("yanfabu");
        groupEntity.setRevision(0);
        idmIdentityService.saveGroup(groupEntity);
    }

    /**
     * @Description 将用户添加到组
     * @Author yorkehan
     * @Params
     * @Date 2019/4/11
     */
    public void testUserAddGroup(){
        String userID="yorkehan";
        String groupId="yanfabu";
        idmIdentityService.createMembership(userID,groupId);
    }

    /**
     * @Description 查询用户
     * @Author yorkehan
     * @Params
     * @Date 2019/4/11 21:59
     */
    public void testUserQuery(){
        List<User> list = idmIdentityService.createUserQuery().list();
        list.forEach(user -> {
            System.out.println(user.getDisplayName());
        });
    }

    /**
     * @Description 查询组
     * @Author yorkehan
     * @Params
     * @Date 2019/4/11 22:01
     */
    public void testGroupQuery(){
        List<Group> list = idmIdentityService.createGroupQuery().list();
        list.forEach(group -> {
            System.out.println(group.getName());
        });
    }

    /**
     * @Description 查询权限
     * @Author yorkehan
     * @Params
     * @Date 2019/4/11 22:02
     */
    public  void testPrivilegeQuery(){
        List<Privilege> list = idmIdentityService.createPrivilegeQuery().list();
        list.forEach(privilege -> {
            System.out.println(privilege.getName());
        });
    }

    /**
     * @Description 创建权限
     * @Author yorkehan
     * @Params
     * @Date 2019/4/11 22:07
     */
    public void testCreateprivilege(){
        String privilegeName="admin-add";
        idmIdentityService.createPrivilege(privilegeName);
    }


    /**
     * @Description 将用户或组关联权限
     * @Author yorkehan
     * @Params
     * @Date 2019/4/11 22:03
     */
    public void testCreatePrivilege(){
        String privilegeId="pr1";
        String groupId="gp1";
        String userId="us1";
        idmIdentityService.addGroupPrivilegeMapping(privilegeId,groupId);
        idmIdentityService.addUserPrivilegeMapping(privilegeId,userId);

    }

}
