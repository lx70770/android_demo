package org.devio.as.proj.log;/*
 * @Author: lixiang16@corp.netease.com
 * @Date: 2021/2/19
 * @FilePath: org.devio.hi.library.log
 */

import org.jetbrains.annotations.NotNull;

public interface HiLogPrinter {
    void print(@NotNull HiLogConfig config, int level, String tag, @NotNull String printString);
}
