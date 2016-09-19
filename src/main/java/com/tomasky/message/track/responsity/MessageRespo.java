package com.tomasky.message.track.responsity;

import com.tomasky.message.track.model.Message;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/13
 * @description:
 */
public interface MessageRespo {
    /**
     * 消息查询.
     *
     * @param msgKey 消息标识.
     * @return 是否存在此条消息.
     */
    Message query(String msgKey);
}
