/**
 * Filename: AuthenticationViaUserFormAction.java
 * Package: io.github.bincool.sso.authentication
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: AuthenticationViaUserFormAction.java
 * Author: wchy.
 * Date: 2018/3/15 15:09.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.sso.authentication;

import io.github.bincool.sso.model.UserCredential;
import io.github.bincool.util.common.Const;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.web.flow.AuthenticationViaFormAction;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * Description: 认证用户校验表单.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/3/15.15:09.
 */
@Component("authenticationViaUserFormAction")
public class AuthenticationViaUserFormAction extends AuthenticationViaFormAction
{

    /**
     * 成功.
     */
    private static final String SUCCESS = "success";

    /**
     * 失败.
     */
    private static final String ERROR = "error";

    /**
     * 校验图形验证码.
     * @param context
     * @param credential
     * @param messageContext
     * @return
     */
    public final String validateCaptcha(final RequestContext context, final Credential credential, final MessageContext messageContext)
    {
        // 获取用户输入参数-图形验证码.
        UserCredential userCredential = (UserCredential)credential;
        String captcha = userCredential.getCaptcha();

        // 校验用户输入参数-图形验证码.
        if (StringUtils.isEmpty(captcha))
        {
            messageContext.addMessage(new MessageBuilder().warning().code("required.captcha").build());
            return SUCCESS_WITH_WARNINGS;
        }

        // 获取session-图形验证码.
        HttpServletRequest request = WebUtils.getHttpServletRequest(context);
        HttpSession session = request.getSession();
        String sessionCaptcha = (String)session.getAttribute(Const.SESSION_CAPTCHA);

        // 校验-图形验证码.
        if (captcha.equalsIgnoreCase(sessionCaptcha))
        {
            return SUCCESS;
        }
        else
        {
            messageContext.addMessage(new MessageBuilder().error().code("error.authentication.captcha.bad").build());
            return ERROR;
        }
    }

}
