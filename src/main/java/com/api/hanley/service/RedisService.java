package com.api.hanley.service;

import java.util.List;
import java.util.Set;

/**
 * @author hanley
 * @date 2019/4/25 13:44
 * 风萧萧兮易水寒
 */
public interface RedisService {



    //删除对应的value
    void remove(final String key);

    //批量删除key
    void removePattern(final String pattern);

    //批量删除对应的value
    void remove(final String... keys);

    //判断缓存中是否有对应的value
    public boolean exists(final String key);

    /**
     * redis提供五种数据类型：string，hash，list，set及zset(sorted set)。
     */
    
    //写入缓存 -------------------------(数据类型：String)
    boolean set(String key,Object value);

    //写入缓存设置时效时间 ---------------(数据类型：String)
    boolean set(String key,Object value,long seconds);

    //读取缓存 -------------------------(数据类型：String)
    Object get(final String key);

    //哈希 添加 -----------------------(数据类型：hash)
    public void hmSet(String key, Object hashKey, Object value);

    //哈希获取数据 --------------------(数据类型：String)
    public Object hmGet(String key, Object hashKey);

    //列表添加 -----------------------(数据类型：list)
    public void lPush(String k,Object v);

    //列表获取 -----------------------(数据类型：list)
    public List<Object> lRange(String k, long l, long l1);

    //集合添加 -----------------------(数据类型：set)
    public void add(String key,Object value);

    //集合获取 -----------------------(数据类型：set)
    public Set<Object> setMembers(String key);

    //有序集合添加 -----------------------(数据类型：zset)
    public void zAdd(String key,Object value,double scoure);

    //有序集合获取 -----------------------(数据类型：zset)
    public Set<Object> rangeByScore(String key,double scoure,double scoure1);



}
