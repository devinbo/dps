package com.ah_service.dps.controller;


import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.service.BaseService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/**
 * 获取所有的基础信息
 */
@RestController
@RequestMapping("base")
public class BaseController {

    @Autowired
    private DefaultKaptcha captchaProducer;

    @Autowired
    private BaseService baseService;

    @RequestMapping("getAllGrade")
    public Result<List> getAllGrade() {
        return baseService.getAllGrade();
    }

    @RequestMapping("getAllCity")
    public Result<List> getAllCity() {
        return baseService.getAllCity();
    }

    @RequestMapping("getArea")
    public Result<List> getArea(String city_id) {
        return baseService.getArea(city_id);
    }


    /**
     * 获取验证码 的 请求路径
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    @RequestMapping("/getAllMedicine")
    public Result getAllMedicine(String rawHosId) {
        return baseService.getAllMedicine(rawHosId);
    }


    @RequestMapping("/getHosByKey")
    public Result getHosByKey(String key) {
        return baseService.getHosByKey(key);
    }
}
