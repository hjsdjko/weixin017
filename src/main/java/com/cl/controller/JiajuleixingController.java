package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JiajuleixingEntity;
import com.cl.entity.view.JiajuleixingView;

import com.cl.service.JiajuleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 家具类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 11:14:20
 */
@RestController
@RequestMapping("/jiajuleixing")
public class JiajuleixingController {
    @Autowired
    private JiajuleixingService jiajuleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiajuleixingEntity jiajuleixing,
		HttpServletRequest request){
        EntityWrapper<JiajuleixingEntity> ew = new EntityWrapper<JiajuleixingEntity>();

		PageUtils page = jiajuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajuleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiajuleixingEntity jiajuleixing, 
		HttpServletRequest request){
        EntityWrapper<JiajuleixingEntity> ew = new EntityWrapper<JiajuleixingEntity>();

		PageUtils page = jiajuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajuleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiajuleixingEntity jiajuleixing){
       	EntityWrapper<JiajuleixingEntity> ew = new EntityWrapper<JiajuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiajuleixing, "jiajuleixing")); 
        return R.ok().put("data", jiajuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiajuleixingEntity jiajuleixing){
        EntityWrapper< JiajuleixingEntity> ew = new EntityWrapper< JiajuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiajuleixing, "jiajuleixing")); 
		JiajuleixingView jiajuleixingView =  jiajuleixingService.selectView(ew);
		return R.ok("查询家具类型成功").put("data", jiajuleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiajuleixingEntity jiajuleixing = jiajuleixingService.selectById(id);
		jiajuleixing = jiajuleixingService.selectView(new EntityWrapper<JiajuleixingEntity>().eq("id", id));
        return R.ok().put("data", jiajuleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiajuleixingEntity jiajuleixing = jiajuleixingService.selectById(id);
		jiajuleixing = jiajuleixingService.selectView(new EntityWrapper<JiajuleixingEntity>().eq("id", id));
        return R.ok().put("data", jiajuleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiajuleixingEntity jiajuleixing, HttpServletRequest request){
    	jiajuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajuleixing);
        jiajuleixingService.insert(jiajuleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiajuleixingEntity jiajuleixing, HttpServletRequest request){
    	jiajuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajuleixing);
        jiajuleixingService.insert(jiajuleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiajuleixingEntity jiajuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiajuleixing);
        jiajuleixingService.updateById(jiajuleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiajuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
