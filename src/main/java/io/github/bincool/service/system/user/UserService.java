/**
 * Filename: UserService.java
 * Package: io.github.bincool.service.system.user
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: UserService.java
 * Author: wchy.
 * Date: 2018/2/6 15:20.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.service.system.user;

import io.github.bincool.entity.system.user.User;
import io.github.bincool.service.base.impl.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Description: 用户服务类.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/2/6.15:20.
 */
@Service("userService")
public class UserService extends BaseService<User>
{

    /*
    * 通过loginName获取合法用户数据(状态为0),实例化user对象会初始化状态为0.
    */
    public User queryUserByLoginName(String loginName) throws Exception
    {
        User user = new User();
        user.setLoginName(loginName);
        user = (User)dao.selectOne("UserMapper.queryUserByLoginName", user);
        return user;
    }

}
