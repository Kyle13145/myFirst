package com.sw.digital.utils;

/**
 * RedisKey工具类
 * @author Kyle
 *
 */

public class RedisKeyUtil {

	/**
     * redis的key
     * 形式为：
     * 表名:主键名:主键值:列名
     *
     * @param tableName 表名
     * @param majorKey 主键名
     * @param majorKeyValue 主键值
     * @param column 列名
     * @return
     */
	
	public static String getKeyWithCloumn(String tableName,String majorKey,String majorKeyValue,String cloumn) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tableName).append(":");
		buffer.append(majorKey).append(":");
		buffer.append(majorKeyValue).append(":");
		buffer.append(cloumn).append(":");
		return buffer.toString();
	}
	
	/**
	 * redis的Key
	 * 形式为：
	 * 表名：主键名：主键值
	 * @param tableName
	 * @param majorKey
	 * @param majorKeyValue
	 * @return
	 */
	public static String getKey(String tableName,String majorKey,String majorKeyValue) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tableName).append(":");
		buffer.append(majorKey).append(":");
		buffer.append(majorKeyValue).append(":");
		return buffer.toString();
	}
	
	
	
}
