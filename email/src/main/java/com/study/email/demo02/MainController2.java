package com.study.email.demo02;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController2 {

    /**
     * 这里测试的目的：使用freemarker发送邮件
     * <p>
     * 参考博客：// https://blog.csdn.net/qq_39241443/article/details/81293939  (很重要)
     * <p>
     * 参考博客：使用freemarker发送邮件   https://blog.csdn.net/system_linux/article/details/78792028
     */

    @Autowired
    private MailServiceImpl2 mailService;

    // 使用freemarker模板发送邮件，成功
    @RequestMapping(value = "sendMainToMyQQ51", method = RequestMethod.GET)
    @ResponseBody
    public String sendMainToMyQQ5() {
        try {
            Map<String, Object> model = new HashMap<>();

            List<EventSa> historyData = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                EventSa eventSa = new EventSa("mtm", "packingBomName", "waveAndFactorySite", "country", new Date(), new Date());
                eventSa.setId(new BigInteger("10"));
                historyData.add(eventSa);
            }

            EventSa eventSa2 = new EventSa("mtm", "packingBomName", "waveAndFactorySite", "country", new Date(),
                    new Date());
            //model.put("historyData", historyData);
            model.put("internalName", "internalName");
            model.put("marketingName", "marketingName");
            model.put("customerSw", "customerSw");
            model.put("inhouse", "inhouse");

            model.put("expireDate", new Date());
            model.put("host", "127.0.0.1");
            model.put("no", "SA201907030001");
            model.put("status", "Closed");


            mailService.sendMessageMail(model, "测试消息通知", "mail_SA.ftl");
            System.out.println("成功了");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

}
