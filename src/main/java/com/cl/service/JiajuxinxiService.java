package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiajuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiajuxinxiView;


/**
 * 家具信息
 *
 * @author 
 * @email 
 * @date 2024-04-07 11:14:21
 */
public interface JiajuxinxiService extends IService<JiajuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiajuxinxiView> selectListView(Wrapper<JiajuxinxiEntity> wrapper);
   	
   	JiajuxinxiView selectView(@Param("ew") Wrapper<JiajuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiajuxinxiEntity> wrapper);
   	

}

