package org.devio.as.proj.main.route;/*
 * @Author: lixiang16@corp.netease.com
 * @Date: 2021/2/24
 * @FilePath: org.devio.as.proj.main.route
 */

public interface RouterFlag {
    int FLAG_LOGIN = 0x01;

    int FLAG_AUTHENTICATION = FLAG_LOGIN << 1;

    int FLAG_VIP = FLAG_AUTHENTICATION << 1;
}
