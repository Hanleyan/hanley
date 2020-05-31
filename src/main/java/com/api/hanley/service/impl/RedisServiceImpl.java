
package com.api.hanley.service.impl;

import com.api.hanley.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.directory.SearchControls;
import java.io.ObjectInput;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @author hanley
 * @date 2019/4/25 13:47
 * 风萧萧兮易水寒
 */

//@Slf4j
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    private Logger log = LoggerFactory.getLogger(RedisServiceImpl.class);

/*
        redisTemplate.opsForList();//操作list
        redisTemplate.opsForValue();//操作字符串
        redisTemplate.opsForCluster();//集群时使用
        redisTemplate.opsForGeo();//地理位置时使用
        redisTemplate.opsForHash();//操作hash
        redisTemplate.opsForSet();//操作set
        redisTemplate.opsForZSet();//操作有序set
    */



/**
     * RedisTemplate是Spring对于Redis的封装。
     * 如上所示，RedisTemplate中定义了对5种数据结构操作。
     *
     * StringRedisTemplate继承RedisTemplate。
       它们采用的序列化策略不同:
     * StringRedisTemplate默认采用的是String的序列化策略，保存的key和value都是采用此策略序列化保存的。
     * RedisTemplate默认采用的是JDK的序列化策略，保存的key和value都是采用此策略序列化保存的。
     * RedisTemplate和StringRedisTemplate它们存取的数据是相互独立的。
     *
     * 解决办法
     上文已经提及，在动手的过程中，我采用的是RedisTemplate,在传递String类型的数据结构后，查看缓存会发现数据乱码现象。
     这时候我们需要修改RedisTemplate的序列化策略。

     但是注意一点，由于采用了String的序列化策略，所以只接受value值类型为String的参数。
     如果像我一样传递了Integer类型的参数，直接使用toString()方法存入缓存。
     *
     * */



/**
     * redis主要功能:
         存储登录的用户
         存储最近登录的用户列表
         存储用户最近浏览的项目
         存储用户的购物车
         缓存请求内容/数据行

     redis数据结构选择:
         用map存储登陆用户
         用zset存储最近登陆的用户
         用zset存储最近被浏览的item
         用zset存储用户最近浏览的item
         用map存储用户的购物车
     */


    private RedisTemplate<String,Object> redisTemplate;

    @Autowired(required = false)
    @SuppressWarnings("unchecked")
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }



/**
     * 写入redis缓存
     * @param key 键
     * @param value 值
     * @return boolean
     */

    @Override
    public boolean set(String key, Object value) {
        boolean b = false;
        try {
            ValueOperations<String,Object> vo = redisTemplate.opsForValue();
            vo.set(key,value);
            b = true;
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return  b;
    }


/**
     * 写入缓存设置时效时间
     * @param key 键
     * @param value 值
     * @param expireTime 时效时间
     * @return boolean
     */

    @Override
    public boolean set(final String key, Object value, long expireTime) {
        boolean b = false;
        try{
            ValueOperations<String,Object> vo = redisTemplate.opsForValue();
            vo.set(key,value);
            redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            b = true;
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return b;
    }


/**
     * 读取缓存
     * @param key key
     * @return Object
     */

    @Override
    public Object get(String key) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }


/**
     * 批量删除对应的value
     * @param keys keys
     */

    @Override
    public void remove(final String... keys) {
        for (String key:keys) {
            remove(key);
        }
    }


/**
     * 删除对应的value
     * @param key key
     */

    @Override
    public void remove(final String key) {
        if(exists(key)){
            redisTemplate.delete(key);
        }
    }


/**
     * 批量删除key
     * @param pattern pattern
     */

    @Override
    public void removePattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if(keys.size() > 0){
            redisTemplate.delete(keys);
        }
    }


/**
     * 判断缓存中是否有对应的value
     * @param key key
     * @return boolean
     */

    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }


/**
     * 哈希 添加
     * @param key key
     * @param hashKey hashKey
     * @param value value
     */

    @Override
    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String,Object,Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }


/**
     * 哈希获取数据
     * @param key key
     * @param hashKey hashKey
     * @return Object
     */

    @Override
    public Object hmGet(String key, Object hashKey) {
        HashOperations<String,Object,Object> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(key,hashKey);
    }


/**
     * 列表添加
     * @param k k
     * @param v v
     */

    @Override
    public void lPush(String k, Object v) {
        ListOperations<String,Object> listOperations = redisTemplate.opsForList();
        listOperations.rightPush(k,v);
    }


/**
     * 列表获取
     * @param k k
     * @param l l
     * @param l1 l1
     * @return List
     */

    @Override
    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String,Object> listOperations = redisTemplate.opsForList();
        return listOperations.range(k,l,l1);
    }


/**
     * 集合添加
     * @param key key
     * @param value value
     */

    @Override
    public void add(String key, Object value) {
        SetOperations<String,Object> setOperations = redisTemplate.opsForSet();
        setOperations.add(key,value);
    }


/**
     * 集合获取
     * @param key key
     * @return Set
     */

    @Override
    public Set<Object> setMembers(String key) {
        SetOperations<String,Object> setOperations = redisTemplate.opsForSet();
        return setOperations.members(key);
    }



/**
     * 有序集合添加
     * @param key key
     * @param value value
     * @param scoure scoure
     */

    @Override
    public void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String,Object> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(key,value,scoure);

    }


/**
     * 有序集合获取
     * @param key key
     * @param scoure scoure
     * @param scoure1 scoure1
     * @return Set
     */

    @Override
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String,Object> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.rangeByScore(key,scoure,scoure1);
    }


}

