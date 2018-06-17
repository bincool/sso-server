/**
 * Filename: CurlResourceVersionInterface.java
 * Package: io.github.bincool.controller.api.curl
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: CurlResourceVersionInterface.java
 * Author: wchy.
 * Date: 2018/3/9 10:34.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.controller.api.curl;

import io.github.bincool.controller.base.impl.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Description: curl命令：临时修改静态资源版本号.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/3/9.10:34.
 */
public class CurlResourceVersionInterface extends BaseController
{

    /**
     * 获取servletContext.
     */
    @Autowired
    private ServletContext servletContext;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mv = getModelAndView();
        try
        {
            servletContext.setAttribute("resourceVersion", System.currentTimeMillis());
            mv.addObject("success", "ok");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            mv.addObject("error", "fail");
        }
        return mv;
    }

}
