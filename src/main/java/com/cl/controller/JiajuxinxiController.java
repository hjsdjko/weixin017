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
import com.cl.entity.OrdersEntity;
import com.cl.service.OrdersService;

import com.cl.entity.JiajuxinxiEntity;
import com.cl.entity.view.JiajuxinxiView;

import com.cl.service.JiajuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 家具信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 11:14:21
 */
@RestController
@RequestMapping("/jiajuxinxi")
public class JiajuxinxiController {
    @Autowired
    private JiajuxinxiService jiajuxinxiService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiajuxinxiEntity jiajuxinxi,
		HttpServletRequest request){
        EntityWrapper<JiajuxinxiEntity> ew = new EntityWrapper<JiajuxinxiEntity>();

		PageUtils page = jiajuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiajuxinxiEntity jiajuxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiajuxinxiEntity> ew = new EntityWrapper<JiajuxinxiEntity>();

		PageUtils page = jiajuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiajuxinxiEntity jiajuxinxi){
       	EntityWrapper<JiajuxinxiEntity> ew = new EntityWrapper<JiajuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiajuxinxi, "jiajuxinxi")); 
        return R.ok().put("data", jiajuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiajuxinxiEntity jiajuxinxi){
        EntityWrapper< JiajuxinxiEntity> ew = new EntityWrapper< JiajuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiajuxinxi, "jiajuxinxi")); 
		JiajuxinxiView jiajuxinxiView =  jiajuxinxiService.selectView(ew);
		return R.ok("查询家具信息成功").put("data", jiajuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiajuxinxiEntity jiajuxinxi = jiajuxinxiService.selectById(id);
		jiajuxinxi.setClicknum(jiajuxinxi.getClicknum()+1);
		jiajuxinxi.setClicktime(new Date());
		jiajuxinxiService.updateById(jiajuxinxi);
		jiajuxinxi = jiajuxinxiService.selectView(new EntityWrapper<JiajuxinxiEntity>().eq("id", id));
        return R.ok().put("data", jiajuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiajuxinxiEntity jiajuxinxi = jiajuxinxiService.selectById(id);
		jiajuxinxi.setClicknum(jiajuxinxi.getClicknum()+1);
		jiajuxinxi.setClicktime(new Date());
		jiajuxinxiService.updateById(jiajuxinxi);
		jiajuxinxi = jiajuxinxiService.selectView(new EntityWrapper<JiajuxinxiEntity>().eq("id", id));
        return R.ok().put("data", jiajuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiajuxinxiEntity jiajuxinxi, HttpServletRequest request){
    	jiajuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajuxinxi);
        jiajuxinxiService.insert(jiajuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiajuxinxiEntity jiajuxinxi, HttpServletRequest request){
    	jiajuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajuxinxi);
        jiajuxinxiService.insert(jiajuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiajuxinxiEntity jiajuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiajuxinxi);
        jiajuxinxiService.updateById(jiajuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiajuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiajuxinxiEntity jiajuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<JiajuxinxiEntity> ew = new EntityWrapper<JiajuxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = jiajuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajuxinxi), params), params));
        return R.ok().put("data", page);
    }

        /**
     * 按用户购买推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,JiajuxinxiEntity jiajuxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "jiajuleixing";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "jiajuxinxi").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<JiajuxinxiEntity> jiajuxinxiList = new ArrayList<JiajuxinxiEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        jiajuxinxiList.addAll(jiajuxinxiService.selectList(new EntityWrapper<JiajuxinxiEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<JiajuxinxiEntity> ew = new EntityWrapper<JiajuxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = jiajuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajuxinxi), params), params));
        List<JiajuxinxiEntity> pageList = (List<JiajuxinxiEntity>)page.getList();
        if(jiajuxinxiList.size()<limit) {
                int toAddNum = (limit-jiajuxinxiList.size())<=pageList.size()?(limit-jiajuxinxiList.size()):pageList.size();
                for(JiajuxinxiEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(JiajuxinxiEntity o2 : jiajuxinxiList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        jiajuxinxiList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(jiajuxinxiList.size()>limit) {
            jiajuxinxiList = jiajuxinxiList.subList(0, limit);
        }
        page.setList(jiajuxinxiList);
        return R.ok().put("data", page);
    }







}
