package org.devio.as.proj.log;/*
 * @Author: lixiang16@corp.netease.com
 * @Date: 2021/2/19
 * @FilePath: org.devio.hi.library.log
 */

public class HiThreadFormatter implements HiLogFormatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread" + data.getName();
    }
}
