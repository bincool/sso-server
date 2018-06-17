/**
 * Filename: SecCodeController.java
 * Package: io.github.bincool.controller.system.seccode
 * Copyright: Wchy-bingV All Rights Reserved.QQ:891946049.
 * Description: SecCodeController.java
 * Author: wchy.
 * Date: 2018/3/8 9:37.
 * Content: 新增.
 * Version: V1.0.
 */
package io.github.bincool.controller.system.seccode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.github.bincool.controller.base.impl.BaseController;
import io.github.bincool.util.common.Const;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * Description: 图形验证码.
 * </p>
 * <p>
 * 详细描述.
 * </p>
 * Author: wchy.
 * Since: 2018/3/8.9:37.
 */
public class ImgCodeController extends BaseController
{

	/**
	 * 获取图形验证码.
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String code = drawImg(output);

		HttpSession session = request.getSession();
		session.setAttribute(Const.SESSION_CAPTCHA, code);

		try
		{
			ServletOutputStream out = response.getOutputStream();
			output.writeTo(out);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成图形验证码.
	 * @param output
	 * @return
	 */
	private String drawImg(ByteArrayOutputStream output)
	{
		String code = "";
		for(int i=0; i<4; i++)
		{
			code += randomChar();
		}
		int width = 70;
		int height = 25;
		BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
		Font font = new Font("Times New Roman",Font.PLAIN,20);
		Graphics2D g = bi.createGraphics();
		g.setFont(font);
		Color color = new Color(254,255,255);
		g.setColor(color);
		g.setBackground(new Color(60,141,188));
		g.clearRect(0, 0, width, height);
		FontRenderContext context = g.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(code, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = bounds.getY();
		double baseY = y - ascent;
		g.drawString(code, (int)x, (int)baseY);
		g.dispose();
		try
		{
			ImageIO.write(bi, "jpg", output);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return code;
	}

	/**
	 * 获取随机字符.
	 * @return
	 */
	private char randomChar()
	{
		Random r = new Random();
		String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
		return s.charAt(r.nextInt(s.length()));
	}

}
