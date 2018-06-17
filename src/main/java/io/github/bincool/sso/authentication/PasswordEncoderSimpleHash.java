/**
 * Filename: PasswordEncoderSimpleHash.java
 * Package: io.github.bincool.sso.authentication
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: PasswordEncoderSimpleHash.java
 * Author: wchy.
 * Date: 2018/3/19 14:25.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.sso.authentication;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.jasig.cas.authentication.handler.PasswordEncoder;

/**
 * <p>
 * Description: 一句话描述该类.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/3/19.14:25.
 */
public class PasswordEncoderSimpleHash implements PasswordEncoder
{

    /**
     * 算法名.
     */
    private static final String ALGORITHM_NAME = "SHA-1";

    /**
     * 用户名.
     */
    private String username;

    /**
     * 构造函数.
     * @param username
     */
    public PasswordEncoderSimpleHash(String username)
    {
        this.username = username;
    }

    /**
     * 加密.
     * @param password
     * @return
     */
    @Override
    public String encode(String password)
    {
        return new SimpleHash(ALGORITHM_NAME, username, password).toString();
    }

}
