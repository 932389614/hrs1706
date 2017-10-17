package com.mlz.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * 通用的数据访问接口
 * @author Administrator
 *
 * @param <E>数据实体类型
 * @param <K>标识字段类型
 */
public interface BaseDao <E,K extends Serializable>{
	/**
	 * 保存
	 * @return
	 */
	K save(E entity);
	/**
	 * 删除
	 * @return
	 */
	boolean deleteById(K id);
	/**
	 * 更新
	 * @return
	 */
	E update(E entity);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	E findById(K id);

	/**
	 * 查询所有
	 * @return
	 */
	List<E> findAll();
}
