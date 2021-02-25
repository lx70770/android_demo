package org.devio.as.proj.log;/*
 * @Author: lixiang16@corp.netease.com
 * @Date: 2021/2/19
 * @FilePath: org.devio.hi.library.log
 */

public interface HiLogFormatter<T> {
    String format(T data);
}
