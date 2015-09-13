package com.sino.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by admin on 2015/5/22.
 */
public class UploadDownload {
    private static Logger logger = Logger.getLogger(UploadDownload.class);

    /**
     * 根据请求浏览器类型(Chrome、Firefox、IE)获取下载文件名
     *
     * @param request  请求HttpServletRequest
     * @param fileName 源文件名
     * @return 根据浏览器生成的新文件名
     */
    public static String getDownloadFileName(HttpServletRequest request, String fileName) {
        String agent = request.getHeader("USER-AGENT");
        String result = "";
        try {
            if (null != agent && -1 != agent.indexOf("Chrome")) { // Chrome
                result = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
            } else if (null != agent && -1 != agent.indexOf("Firefox")) { // Firefox
                result = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";
            } else {// IE7++
                result = java.net.URLEncoder.encode(fileName, "UTF-8");
                result = StringUtils.replace(result, "+", "%20");
            }
        } catch (UnsupportedEncodingException e) {
            result = fileName;
            logger.error("生成新文件名过程中发生异常：" + e.getMessage());
        }
        return result;
    }
}
