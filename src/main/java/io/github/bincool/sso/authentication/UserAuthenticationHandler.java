/**
 * Filename: UserAuthenticationHandler.java
 * Package: io.github.bincool.sso.authentication
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: UserAuthenticationHandler.java
 * Author: wchy.
 * Date: 2018/3/15 16:18.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.sso.authentication;

import io.github.bincool.entity.system.user.User;
import io.github.bincool.service.system.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.PasswordEncoder;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;

/**
 * <p>
 * Description: 用户认证.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/3/15.16:User18.
 */
@Component("userAuthenticationHandler")
public class UserAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler
{

    /**
     * 用户服务类.
     */
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 认证用户名和密码.
     * @param credential
     * @return
     * @throws GeneralSecurityException
     * @throws PreventedException
     */
    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential) throws GeneralSecurityException, PreventedException
    {
        // 获取用户输入的登录帐号和登录名.
        String username = credential.getUsername();
        String password = credential.getPassword();

        // 先校验用户输入的合法性.
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
        {
            this.logger.debug("{} was not found in the map.", username);
            throw new AccountNotFoundException(username + " not found in backing map.");
        }
        else
        {
            // 根据登录帐号查询用户信息.
            User user;
            try
            {
                user = userService.queryUserByLoginName(username);
                if (null == user)
                {
                    this.logger.debug("{} was not found in the map.", username);
                    throw new AccountNotFoundException(username + " not found in backing map.");
                }
            }
            catch (Exception e)
            {
                this.logger.debug("{} was not found in the map.", username);
                throw new AccountNotFoundException(username + " not found in backing map.");
            }

            // 设置加密方式.
            PasswordEncoder passwordEncoder = new PasswordEncoderSimpleHash(username);
            this.setPasswordEncoder(passwordEncoder);

            // 加密后和数据库信息对比.
            String encodedPassword = this.getPasswordEncoder().encode(password);
            if (username.equals(user.getLoginName()) && encodedPassword.equals(user.getLoginPassword()))
            {
                return createHandlerResult(credential, this.principalFactory.createPrincipal(username), null);
            }
            else
            {
                throw new FailedLoginException();
            }
        }
    }

}
