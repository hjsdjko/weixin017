package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussjiajuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiajuxinxiView;


/**
 * 家具信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-07 11:14:21
 */
public interface DiscussjiajuxinxiService extends IService<DiscussjiajuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiajuxinxiView> selectListView(Wrapper<DiscussjiajuxinxiEntity> wrapper);
   	
   	DiscussjiajuxinxiView selectView(@Param("ew") Wrapper<DiscussjiajuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiajuxinxiEntity> wrapper);
   	

}

