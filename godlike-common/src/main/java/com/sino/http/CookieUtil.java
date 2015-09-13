package com.sino.http;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2015/5/22.
 */
public class CookieUtil {
    /**
     * 设置cookie，同一应用服务器内共享
     *
     * @param response HttpServletResponse
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期  以秒为单位
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 将cookie封装成Map
     *
     * @param request
     * @return
     */
    public static Map<String, Object> makeAsMap(HttpServletRequest request) {
        Map<String, Object> cookieMap = new HashMap<>();
        Cookie[] cookies = getCookies(request);
        if (null != cookies)
            for (Cookie cookie : cookies)
                cookieMap.put(cookie.getName(), cookie.getValue());
        return cookieMap;
    }

    public static Cookie[] getCookies(HttpServletRequest request) {
        return request.getCookies();
    }
}
