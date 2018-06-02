package com.khadi.mytransport.service.impl;

import com.khadi.mytransport.service.CaptchaService;
import org.springframework.stereotype.Service;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Override
    public boolean isValid(String captcha) {
        return true;
    }
}
