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


import com.cl.dao.JiajuxinxiDao;
import com.cl.entity.JiajuxinxiEntity;
import com.cl.service.JiajuxinxiService;
import com.cl.entity.view.JiajuxinxiView;

@Service("jiajuxinxiService")
public class JiajuxinxiServiceImpl extends ServiceImpl<JiajuxinxiDao, JiajuxinxiEntity> implements JiajuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiajuxinxiEntity> page = this.selectPage(
                new Query<JiajuxinxiEntity>(params).getPage(),
                new EntityWrapper<JiajuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiajuxinxiEntity> wrapper) {
		  Page<JiajuxinxiView> page =new Query<JiajuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiajuxinxiView> selectListView(Wrapper<JiajuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiajuxinxiView selectView(Wrapper<JiajuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
