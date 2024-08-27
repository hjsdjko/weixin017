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


import com.cl.dao.DiscussjiajuxinxiDao;
import com.cl.entity.DiscussjiajuxinxiEntity;
import com.cl.service.DiscussjiajuxinxiService;
import com.cl.entity.view.DiscussjiajuxinxiView;

@Service("discussjiajuxinxiService")
public class DiscussjiajuxinxiServiceImpl extends ServiceImpl<DiscussjiajuxinxiDao, DiscussjiajuxinxiEntity> implements DiscussjiajuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiajuxinxiEntity> page = this.selectPage(
                new Query<DiscussjiajuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussjiajuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiajuxinxiEntity> wrapper) {
		  Page<DiscussjiajuxinxiView> page =new Query<DiscussjiajuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussjiajuxinxiView> selectListView(Wrapper<DiscussjiajuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiajuxinxiView selectView(Wrapper<DiscussjiajuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
