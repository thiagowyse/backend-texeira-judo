package com.projetojudo.judotexeira.infrastructure.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseController<T> {

    String message;
    T responseObject;

    public ResponseController(String message, T responseObject) {
        this.message = message;
        this.responseObject = responseObject;
    }

    public Map<String, Object> getResponseMessage() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("data", responseObject);
        return response;
    }
}
