package com.qtt.wx.util;

import org.apache.log4j.Logger;

public class CMyLog {
    private static Logger logger = null;
    
    public static void InfoLog(String msg) {
        if ( logger == null )
        {
            logger = Logger.getRootLogger();
        }
        logger.info(msg);
        System.out.println(msg);
    }
}
