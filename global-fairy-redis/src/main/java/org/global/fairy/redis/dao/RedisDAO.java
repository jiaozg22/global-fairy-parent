package org.global.fairy.redis.dao;

import java.io.Serializable;

public interface RedisDAO {

	void sendMessage(String channel, Serializable message);

}
