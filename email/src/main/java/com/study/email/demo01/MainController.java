package com.study.email.demo01;

import com.study.email.demo01.entity.Message;
import com.study.email.entity.EventSa;
import com.study.email.utils.ApplicationContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {
	
	/**
	 * 参考博客：// https://blog.csdn.net/qq_39241443/article/details/81293939  (很重要)
	 * 
	 * 参考博客：使用freemarker发送邮件   https://blog.csdn.net/system_linux/article/details/78792028
	 * 
	 */
	
	@Autowired
	private MailServiceImpl mailService;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	// 简单邮件发送，成功
	@RequestMapping(value = "sendMainToMyQQ", method = RequestMethod.GET)
	@ResponseBody
	public String sendMainToMyQQ() {
		// 遇到的问题: 原因是使用SQM的邮件发送失败，改成我自己的邮箱发送就成功了
		// com.sun.mail.smtp.SMTPSendFailedException: 553 Mail from must equal authorized user
		// String to = "18010626471@163.com"; // 发送给我自己，成功
		String to = "1915418799@qq.com"; // 发送给我自己，成功
		String subject = "main subject";
		String content = "邮件内容，巴拉巴拉...";

		// 获取到的是@Primary标注的JavaMailSenderImpl
		JavaMailSenderImpl mailSender = ApplicationContextUtils.getBean(JavaMailSenderImpl.class);
		JavaMailSenderImpl saMailSender = (JavaMailSenderImpl) ApplicationContextUtils.getBean("saMailSender");

		mailService.sendSimpleMail(to, subject, content);

		return "success";
	}
	
	// 发送带照片的邮件，成功；不需要设置什么，在QQ中就直接展示(网上说需要添加信任，我的不需要)
	@RequestMapping(value = "sendMainToMyQQ2", method = RequestMethod.GET)
	@ResponseBody
	public String sendMainToMyQQ2() {
		try {
			//String to = "1915418799@qq.com";
			String to = "18010626471@163.com";
			String subject = "带图片邮件";
			String rscId = "img110";
			String content = "<html><body><img width='250px' src=\'cid:" + rscId + "\'></body></html>";
			// 此处为linux系统路径
			String imgPath = "D:\\testDir\\1_fastDFS\\007.jpg";
			mailService.sendInlineResourceMail(to, subject, content, imgPath, rscId);
			System.out.println("成功了");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	// 发送带附件的邮件，成功
	@RequestMapping(value = "sendMainToMyQQ3", method = RequestMethod.GET)
	@ResponseBody
	public String sendMainToMyQQ3() {
		try {
			String to = "1915418799@qq.com";
			String subject = "今晚要加班，不用等我了";
			String rscId = "img110";
			String content = "<html><body><img width='250px' src=\'cid:" + rscId + "\'></body></html>";
			// 此处为linux系统路径
			String imgPath = "C:\\Users\\issuser\\Downloads\\20180904141504_fb127061-0c93-4cd1-be51-50c990dcf9c8.csv";
			mailService.sendAttachmentsMail(to, subject, content, imgPath);
			System.out.println("成功了");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	// 发送HTML邮件，成功
	@RequestMapping(value = "sendMainToMyQQ4", method = RequestMethod.GET)
	@ResponseBody
	public String sendMainToMyQQ4() {
		try {
			String to = "1915418799@qq.com";
			String subject = "今晚要加班，不用等我了";
			String rscId = "img110";
			String content = "<html><head></head><body><h3>哈哈，什么都没有</h3></body></html>";
			// 此处为linux系统路径
			mailService.sendHtmlMail(to, subject, content);
			System.out.println("成功了");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}

	@RequestMapping(value = "getEnterMsg", method = RequestMethod.GET)
	@ResponseBody
	public String getEnterMsg() {
		String result = "222222;\n" +
				"333;\n" +
				"444;";
		return result;
	}
	
	// 使用freemarker模板发送邮件，成功
	@RequestMapping(value = "sendMainToMyQQ5", method = RequestMethod.GET)
	@ResponseBody
	public String sendMainToMyQQ5() {
		try {
			String sql = "select email_content from sa_email where id = 1";
			Map<String, Object> params = new HashMap<>();


			// 错误的写法：
			// BeanPropertyRowMapper<String> rowMapper = new BeanPropertyRowMapper<>(String.class); // 映射不到返回值
			// String result = namedJdbcTemplate.queryForObject(sql, params, rowMapper);

			// 正确的写法: 属性名映射字段名
			BeanPropertyRowMapper<EventSa> rowMapper = new BeanPropertyRowMapper<>(EventSa.class); // 映射不到返回值
			EventSa emailInfo = namedJdbcTemplate.queryForObject(sql, params, rowMapper);
			String content = emailInfo.getEmail_content().replace("\n", "<br/>");

			// 出现的错误：java.lang.IllegalStateException: Mapped class was not specified
			// 解决方案：BeanPropertyRowMapper<EventSa> rowMapper = new BeanPropertyRowMapper<>(EventSa.class);

			Message message = new Message();

			message.setMessageCode("MissingParameter");
			message.setMessageStatus("Failed");
			message.setCause(content);

			mailService.sendMessageMail(message, "测试消息通知", "message.ftl");
			System.out.println("成功了");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	// 使用freemarker模板发送带有图片的邮件，成功
	@RequestMapping(value = "sendImgMail", method = RequestMethod.GET)
	@ResponseBody
	public String sendImgMailToMyQQ5() throws Exception{

		String to = "18010626471@163.com";
		String subject = "照片邮件";
		String content = "照片邮件内容";
		String imgPath = "templates\\claims\\mcar_email_photo.png"; // 失败
//		String imgPath = "D:\\testDir\\1_fastDFS\\mcar_email_photo.png"; // 成功
		String imgId = "rscId_mcar";
		String templateName = "message_img.ftl";

		Map<String, Object> model = new HashMap<>();
		mailService.sendImgMail(to, subject, content, imgPath, imgId, templateName, model);

		System.out.println("成功了");
		return "success";
	}

}
