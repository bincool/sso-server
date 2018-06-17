/**
 * Filename: UserCredential.java
 * Package: io.github.bincool.sso.model
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: UserCredential.java
 * Author: wchy.
 * Date: 2018/3/15 14:24.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.sso.model;

import org.jasig.cas.authentication.UsernamePasswordCredential;

/**
 * <p>
 * Description: SSO用户认证实体bean.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/3/15.14:24.
 */
public class UserCredential extends UsernamePasswordCredential
{

    /**
     * 图形验证码.
     */
    private String captcha;

    /**
     * 获取图形验证码.
     * @return
     */
    public String getCaptcha()
    {
        return captcha;
    }

    /**
     * 设置图形验证码.
     * @param captcha
     */
    public void setCaptcha(String captcha)
    {
        this.captcha = captcha;
    }

}
