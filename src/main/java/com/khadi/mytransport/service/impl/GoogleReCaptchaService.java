package com.khadi.mytransport.service.impl;

import com.khadi.mytransport.service.CaptchaService;
import com.khadi.mytransport.util.ReCaptchaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GoogleReCaptchaService implements CaptchaService {
    private static final String GOOGLE_RE_CAPTCHA_VERIFY_URL =
            "https://www.google.com/recaptcha/api/siteverify";

    @Value("${google.recaptcha.secret}")
    private String recaptchaSecret;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private ReCaptchaUtil reCaptchaUtil;

    @Override
    public String verify(String remoteIp, String captchaResponse) {
        Map<String, String> body = new HashMap<>();
        body.put("secret", recaptchaSecret);
        body.put("response", captchaResponse);
        body.put("remoteip", remoteIp);

        ResponseEntity<Map> reCaptchaResponseEntity =
                restTemplateBuilder.build()
                        .postForEntity(GOOGLE_RE_CAPTCHA_VERIFY_URL +
                                        "?secret={secret}&response={response}&remoteip={remoteip}",
                                body, Map.class, body);
        Map<String, Object> responseBody = reCaptchaResponseEntity.getBody();
        boolean success = (boolean) responseBody.get("success");
        if (success) {
            return StringUtils.EMPTY;
        }

        List<String> errorCodes = (List<String>) responseBody.get("error-codes");
        String errorMessage = errorCodes.stream()
                .map(s -> reCaptchaUtil.getErrorCodes().get(s))
                .collect(Collectors.joining(", "));

        return errorMessage;
    }
}
