/**
 * Filename: BaseMultiActionController.java
 * Package: io.github.bincool.controller.base.impl
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: BaseMultiActionController.java
 * Author: wchy.
 * Date: 2018/3/16 17:51.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.controller.base.impl;

import io.github.bincool.controller.base.IBaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Description: 控制层基类-多方法.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/3/16.17:51.
 */
public class BaseMultiActionController extends MultiActionController implements IBaseController
{

    /**
     * 日志对象.
     */
    protected Log LOGGER = LogFactory.getLog(this.getClass());

    /**
     * 得到ModelAndView.
     * @return
     */
    public ModelAndView getModelAndView()
    {
        return new ModelAndView();
    }

    /**
     * 得到request对象.
     * @return
     */
    public HttpServletRequest getRequest()
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * .
     * @param logger
     * @param interfaceName
     */
    public void logBefore(Log logger, String interfaceName)
    {
        logger.info("");
        logger.info("start");
        logger.info(interfaceName);
    }

    /**
     * .
     * @param logger
     */
    public void logAfter(Log logger)
    {
        logger.info("end");
        logger.info("");
    }

}
