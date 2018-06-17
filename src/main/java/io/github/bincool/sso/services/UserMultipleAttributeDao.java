/**
 * Filename: UserMultipleAttributeDao.java
 * Package: io.github.bincool.sso.services
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: UserMultipleAttributeDao.java
 * Author: wchy.
 * Date: 2018/3/19 16:24.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.sso.services;

import io.github.bincool.entity.system.user.User;
import io.github.bincool.service.system.user.UserService;
import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.AttributeNamedPersonImpl;
import org.jasig.services.persondir.support.StubPersonAttributeDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Description: 扩展返回更多关于用户的信息.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/3/19.16:24.
 */
@Component("attributeRepository")
public class UserMultipleAttributeDao extends StubPersonAttributeDao
{

    /**
     * 用户服务类.
     */
    @Resource(name = "userService")
    private UserService userService;

    @Override
    public IPersonAttributes getPerson(String uid)
    {
        Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();
        attributes.put("from_name", Collections.singletonList(uid));

        try
        {
            // 获取用户信息-将密码信息移除.
            User user = userService.queryUserByLoginName(uid);
            user.setLoginPassword(null);

            attributes.put("userInfo", Collections.singletonList(user));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return new AttributeNamedPersonImpl(attributes);
    }

}
