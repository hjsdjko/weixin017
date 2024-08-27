package com.cl.dao;

import com.cl.entity.DiscussjiajuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiajuxinxiView;


/**
 * 家具信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-07 11:14:21
 */
public interface DiscussjiajuxinxiDao extends BaseMapper<DiscussjiajuxinxiEntity> {
	
	List<DiscussjiajuxinxiView> selectListView(@Param("ew") Wrapper<DiscussjiajuxinxiEntity> wrapper);

	List<DiscussjiajuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiajuxinxiEntity> wrapper);
	
	DiscussjiajuxinxiView selectView(@Param("ew") Wrapper<DiscussjiajuxinxiEntity> wrapper);
	

}
