package cn.ekgc.witmed.base.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <b>智慧医疗- Redis 工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>将所给定的对象存储到 Redis 中</b>
	 * @param key
	 * @param obj
	 * @param expireMillis
	 * @throws Exception
	 */
	public void saveToRedis(String key, Object obj, Long expireMillis) throws Exception {
		// 创建 JsonMapper 对象
		JsonMapper jsonMapper = new JsonMapper();
		// 将给定的对象变为 JSON 格式
		// 将其中的双引号替换为单引号，否则在存入 Redis 中后，会增加 \ 来对双引号进行转义，
		// 导致再次从 Redis 中获取数据时，是无法完成恢复成对象的
		String jsonStr = jsonMapper.writeValueAsString(obj).replace("\"", "'");
		// 将对应的数据存储到 Redis 中
		redisTemplate.opsForValue().set(key, jsonStr);
		// 设定存储到 Redis 的过期时间
		redisTemplate.expire(key, expireMillis, TimeUnit.MILLISECONDS);
	}

	/**
	 * <b>根据 key 从 Redis 中获得数据并恢复成相关对象</b>
	 * @param key
	 * @param objType
	 * @return
	 * @throws Exception
	 */
	public Object findFromRedis(String key, Class objType) throws Exception {
		// 通过 key 从 Redis 中获得对应的 JSON
		String jsonStr = redisTemplate.opsForValue().get(key);
		// 判断是否能够从 Redis 中获取对应的数据
		if (jsonStr != null) {
			// 此时通过 key 从 Redis 中获得数据，那么将该数据恢复成对应的对象
			// 创建 JsonMapper 对象
			JsonMapper jsonMapper = new JsonMapper();
			return jsonMapper.readValue(jsonStr, objType);
		}

		return null;
	}
}
