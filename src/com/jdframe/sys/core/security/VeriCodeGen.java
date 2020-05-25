package com.jdframe.sys.core.security;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
 

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.security.VeriCodeGen.java
 * The Class VeriCodeGen.
 * Last-Modified-Time : 2013-11-8 10:47:08
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class VeriCodeGen extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public VeriCodeGen() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		__securityCode(request, response);
	}

	/**
	 * Security code.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void __securityCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//设置页面不缓存
		 response.setHeader("Pragma", "No-cache");
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expires", 0);
		 // 在内存中创建图象
		 int __$$width = 80, __$$height = 20;
		 BufferedImage __image = new BufferedImage(__$$width, __$$height, BufferedImage.TYPE_INT_RGB);

		 // 获取图形上下文
		 Graphics __g = __image.getGraphics();

		 //生成随机类
		 Random __random = new Random();

		 // 设定背景色
		 __g.setColor(getRandColor(200, 250));
		 __g.fillRect(0, 0, __$$width, __$$height);

		 //设定字体
		 __g.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 //画边框
		 __g.setColor(new Color(0, 0, 0));
		 __g.drawRect(0, 0, __$$width - 1, __$$height - 1);

		 // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		 __g.setColor(getRandColor(160, 200));
		 for (int i = 0; i < 155; i++) {
		  int ___x = __random.nextInt(__$$width);
		  int ___y = __random.nextInt(__$$height);
		  int ___xl = __random.nextInt(12);
		  int ___yl = __random.nextInt(12);
		  __g.drawLine(___x, ___y, ___x + ___xl, ___y + ___yl);
		 }

		 // 取随机产生的认证码(4位数字)
		 String _$_sRand = "";
		 for (int i = 0; i < 4; i++) {
		  String _rand = null;
		  //随机生成数字或者字母
		  if (__random.nextInt(10) > 5) {
		   _rand = String.valueOf((char)(__random
		     .nextInt(10) + 48));
		  } else {
		  	 _rand = String.valueOf((char)(__random
		     .nextInt(26) + 65));
		  }
		  _$_sRand += _rand;
		  // 将认证码显示到图象中
		  __g.setColor(new Color(__random.nextInt(80), __random
		    .nextInt(80), __random.nextInt(80)));
		  //调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
		  __g.drawString(_rand, 15 * i + 10, 16);
		 }

		 // 将认证码存入SESSION
		 request.getSession(true).setAttribute("veriCode", _$_sRand);
		 // 图象生效
		 __g.dispose();
		 // 输出图象到页面
		 ImageIO.write(__image, "JPEG", response.getOutputStream());
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
    
	/**
	 * Gets the rand color.
	 *
	 * @param __fc the fc
	 * @param __bc the bc
	 * @return the rand color
	 */
	private Color getRandColor(int __fc, int __bc) {//给定范围获得随机颜色
		  Random __random = new Random();
		  if (__fc > 255)
		   __fc = 255;
		  if (__bc > 255)
		   __bc = 255;
		  int _r = __fc + __random.nextInt(__bc - __fc);
		  int _g = __fc + __random.nextInt(__bc - __fc);
		  int _b = __fc + __random.nextInt(__bc - __fc);
		  return new Color(_r, _g, _b);
		 }
}
