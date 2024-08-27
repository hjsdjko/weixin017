package com.cl.dao;

import com.cl.entity.JiajuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiajuxinxiView;


/**
 * 家具信息
 * 
 * @author 
 * @email 
 * @date 2024-04-07 11:14:21
 */
public interface JiajuxinxiDao extends BaseMapper<JiajuxinxiEntity> {
	
	List<JiajuxinxiView> selectListView(@Param("ew") Wrapper<JiajuxinxiEntity> wrapper);

	List<JiajuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiajuxinxiEntity> wrapper);
	
	JiajuxinxiView selectView(@Param("ew") Wrapper<JiajuxinxiEntity> wrapper);
	

}
