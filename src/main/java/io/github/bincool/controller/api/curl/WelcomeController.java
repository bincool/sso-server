/**
 * Filename: WelcomeController.java
 * Package: io.github.bincool.controller.api.curl
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: WelcomeController.java
 * Author: wchy.
 * Date: 2018/3/19 9:52.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.controller.api.curl;

import io.github.bincool.controller.base.impl.BaseMultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Description: 测试类.
 * </p>
 * <p>
 * 详细描述:public ModelAndView functionName(HttpServletRequest request, HttpServletResponse response){...}.
 * </p>
 * <p>
 * 示例代码:
 * http://cas.hrorg.cn:8088/ctl/welcome.html?method=addUser.
 * </p>
 * Author: wchy.
 * Since: 2018/3/19.9:52.
 */
public class WelcomeController extends BaseMultiActionController
{
    private String successView;

    public String getSuccessView()
    {
        return successView;
    }

    public void setSuccessView(String successView)
    {
        this.successView = successView;
    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response)
    {
        Map model = new HashMap();
        model.put("success", "成功");
        return new ModelAndView(this.getSuccessView(), model);
    }

    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response)
    {
        Map model = new HashMap();
        model.put("success", "增加用户成功");
        return new ModelAndView(this.getSuccessView(), model);
    }

    public ModelAndView queryByUserId()
    {
        Map model = new HashMap();
        model.put("success", "增加用户成功");
        return new ModelAndView(this.getSuccessView(), model);
    }
}
