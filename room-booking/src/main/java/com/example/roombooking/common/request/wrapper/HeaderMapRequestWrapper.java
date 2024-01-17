package com.example.roombooking.common.request.wrapper;

import com.google.common.base.Strings;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.HashMap;
import java.util.Map;

public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {

    private final Map<String, String> headerMap = new HashMap<>();

    public HeaderMapRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public  void addHeader(String name, String value){
        headerMap.remove(name);
        headerMap.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        String headerValue = super.getHeader(name);
        String value = this.headerMap.get(name);

        if(!Strings.isNullOrEmpty(value)){
            return value;
        }

        return headerValue;
    }
}
