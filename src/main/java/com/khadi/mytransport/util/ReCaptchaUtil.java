package com.khadi.mytransport.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ReCaptchaUtil {
    private final Map<String, String> errorCodes;

    public ReCaptchaUtil() {
        this.errorCodes = new HashMap<>();
        errorCodes.put("missing-input-secret",
                "The secret parameter is missing");
        errorCodes.put("invalid-input-secret",
                "The secret parameter is invalid or malformed");
        errorCodes.put("missing-input-response",
                "The response parameter is missing");
        errorCodes.put("invalid-input-response",
                "The response parameter is invalid or malformed");
        errorCodes.put("bad-request",
                "The request is invalid or malformed");
    }

    public Map<String, String> getErrorCodes() {
        return errorCodes;
    }
}
