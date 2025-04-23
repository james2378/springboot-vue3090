package com.entity.view;

import com.entity.XianhuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 鲜花
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xianhua")
public class XianhuaView extends XianhuaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 鲜花类型的值
		*/
		private String xianhuaValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public XianhuaView() {

	}

	public XianhuaView(XianhuaEntity xianhuaEntity) {
		try {
			BeanUtils.copyProperties(this, xianhuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 鲜花类型的值
			*/
			public String getXianhuaValue() {
				return xianhuaValue;
			}
			/**
			* 设置： 鲜花类型的值
			*/
			public void setXianhuaValue(String xianhuaValue) {
				this.xianhuaValue = xianhuaValue;
			}
			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}














}
