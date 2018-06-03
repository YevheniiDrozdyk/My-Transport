package com.khadi.mytransport.service;

public interface CaptchaService {

    String verify(String remoteIp, String captchaResponse);
}
