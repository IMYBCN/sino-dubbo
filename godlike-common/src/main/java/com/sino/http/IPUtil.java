package com.sino.http;

import com.sino.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2015/5/27.
 */
public class IPUtil {
    /**
     * 获得真实的IP地址。如果使用了代理，则需要代理正确的往消息头中加入X-Forwarded-For或者X-Real-IP
     *
     * @param request
     * @return
     */
    public static String getIP(final HttpServletRequest request) {
        try {
            String remoteIP = request.getHeader("X-Forwarded-For");
            if (isValid(remoteIP) && (remoteIP.indexOf(",") > -1)) {
                String[] array = remoteIP.split(",");
                for (String element : array) {
                    if (isValid(element)) {
                        return element;
                    }
                }
            }
            if (isValid(remoteIP)) {
                remoteIP = request.getHeader("X-Real-IP");
            }
            if (isValid(remoteIP)) {
                remoteIP = request.getRemoteAddr();
            }
            return remoteIP;
        } catch (Exception e) {
            return "解析地址出现错误";
        }
    }

    private static boolean isValid(String remoteIP) {
        return !StringUtil.isNotBlank(remoteIP) && !StringUtil.isNotUnknown(remoteIP);
    }


}
