package com.valen.lark.dao;

import java.util.List;
import java.util.Map;

/**
 * @author fengling
 * @create 2017-11-23
 * @Description 数据库表基本操作接口
 */
public interface BaseDAO<E> {
	
	public int insert(E e);
	
	public int create(E e);
	
	public int batchCreate(List<E> list);
	
	public int delete(E e);
	
	public int delete(int id);
	
	public int update(E e);
	
	public E findById(int id);
	
	public List<E> findByParam(Map<String, Object> param) ;
	
	public int count(Map<String, Object> param);
}
