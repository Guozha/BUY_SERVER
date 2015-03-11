package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BasFrontType;

/**
 * 产品类目
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-10 下午2:42:02
 */
@Repository
public interface BasFrontTypeMapper  extends BaseMapper<BasFrontType, Integer>{
	/**
	 * 查询一级类目
	 * @return
	 */
	List<BasFrontType> findFirst();
	
	/**
	 * 查询二级类目(子类目)
	 * @param parentId
	 * @return
	 */
	List<BasFrontType> findSecond(int parentId);

}
