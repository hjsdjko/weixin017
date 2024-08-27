package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiajuleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiajuleixingView;


/**
 * 家具类型
 *
 * @author 
 * @email 
 * @date 2024-04-07 11:14:20
 */
public interface JiajuleixingService extends IService<JiajuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiajuleixingView> selectListView(Wrapper<JiajuleixingEntity> wrapper);
   	
   	JiajuleixingView selectView(@Param("ew") Wrapper<JiajuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiajuleixingEntity> wrapper);
   	

}

