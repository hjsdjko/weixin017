package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 家具信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-07 11:14:21
 */
@TableName("jiajuxinxi")
public class JiajuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiajuxinxiEntity() {
		
	}
	
	public JiajuxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 家具名称
	 */
					
	private String jiajumingcheng;
	
	/**
	 * 家具图片
	 */
					
	private String jiajutupian;
	
	/**
	 * 家具类型
	 */
					
	private String jiajuleixing;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 家具颜色
	 */
					
	private String jiajuyanse;
	
	/**
	 * 家具材质
	 */
					
	private String jiajucaizhi;
	
	/**
	 * 家具尺寸
	 */
					
	private String jiajuchicun;
	
	/**
	 * 家具详情
	 */
					
	private String jiajuxiangqing;
	
	/**
	 * 单限
	 */
					
	private Integer onelimittimes;
	
	/**
	 * 库存
	 */
					
	private Integer alllimittimes;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	/**
	 * 价格
	 */
					
	private Double price;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：家具名称
	 */
	public void setJiajumingcheng(String jiajumingcheng) {
		this.jiajumingcheng = jiajumingcheng;
	}
	/**
	 * 获取：家具名称
	 */
	public String getJiajumingcheng() {
		return jiajumingcheng;
	}
	/**
	 * 设置：家具图片
	 */
	public void setJiajutupian(String jiajutupian) {
		this.jiajutupian = jiajutupian;
	}
	/**
	 * 获取：家具图片
	 */
	public String getJiajutupian() {
		return jiajutupian;
	}
	/**
	 * 设置：家具类型
	 */
	public void setJiajuleixing(String jiajuleixing) {
		this.jiajuleixing = jiajuleixing;
	}
	/**
	 * 获取：家具类型
	 */
	public String getJiajuleixing() {
		return jiajuleixing;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：家具颜色
	 */
	public void setJiajuyanse(String jiajuyanse) {
		this.jiajuyanse = jiajuyanse;
	}
	/**
	 * 获取：家具颜色
	 */
	public String getJiajuyanse() {
		return jiajuyanse;
	}
	/**
	 * 设置：家具材质
	 */
	public void setJiajucaizhi(String jiajucaizhi) {
		this.jiajucaizhi = jiajucaizhi;
	}
	/**
	 * 获取：家具材质
	 */
	public String getJiajucaizhi() {
		return jiajucaizhi;
	}
	/**
	 * 设置：家具尺寸
	 */
	public void setJiajuchicun(String jiajuchicun) {
		this.jiajuchicun = jiajuchicun;
	}
	/**
	 * 获取：家具尺寸
	 */
	public String getJiajuchicun() {
		return jiajuchicun;
	}
	/**
	 * 设置：家具详情
	 */
	public void setJiajuxiangqing(String jiajuxiangqing) {
		this.jiajuxiangqing = jiajuxiangqing;
	}
	/**
	 * 获取：家具详情
	 */
	public String getJiajuxiangqing() {
		return jiajuxiangqing;
	}
	/**
	 * 设置：单限
	 */
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	/**
	 * 获取：单限
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
	/**
	 * 设置：库存
	 */
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	/**
	 * 获取：库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
