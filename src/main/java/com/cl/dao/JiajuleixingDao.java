package com.cl.dao;

import com.cl.entity.JiajuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiajuleixingView;


/**
 * 家具类型
 * 
 * @author 
 * @email 
 * @date 2024-04-07 11:14:20
 */
public interface JiajuleixingDao extends BaseMapper<JiajuleixingEntity> {
	
	List<JiajuleixingView> selectListView(@Param("ew") Wrapper<JiajuleixingEntity> wrapper);

	List<JiajuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<JiajuleixingEntity> wrapper);
	
	JiajuleixingView selectView(@Param("ew") Wrapper<JiajuleixingEntity> wrapper);
	

}
