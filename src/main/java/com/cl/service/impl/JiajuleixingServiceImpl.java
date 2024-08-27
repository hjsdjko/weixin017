package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JiajuleixingDao;
import com.cl.entity.JiajuleixingEntity;
import com.cl.service.JiajuleixingService;
import com.cl.entity.view.JiajuleixingView;

@Service("jiajuleixingService")
public class JiajuleixingServiceImpl extends ServiceImpl<JiajuleixingDao, JiajuleixingEntity> implements JiajuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiajuleixingEntity> page = this.selectPage(
                new Query<JiajuleixingEntity>(params).getPage(),
                new EntityWrapper<JiajuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiajuleixingEntity> wrapper) {
		  Page<JiajuleixingView> page =new Query<JiajuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiajuleixingView> selectListView(Wrapper<JiajuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiajuleixingView selectView(Wrapper<JiajuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
