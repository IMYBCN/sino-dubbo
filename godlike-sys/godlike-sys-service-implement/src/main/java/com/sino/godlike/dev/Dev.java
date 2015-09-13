package com.sino.godlike.dev;


/**
 * Created by pierce-deng on 2015/9/8.
 */

/**
 * 方便开发阶段进行测试，不再需要使用脚本进行启动了，直接运行下边的main方法就行
 */
public class Dev {
    public static void main(String[] args) throws Exception {
        com.alibaba.dubbo.container.Main.main(args);
    }
}
