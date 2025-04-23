package com.entity.view;

import com.entity.XianhuaOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 鲜花订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xianhua_order")
public class XianhuaOrderView extends XianhuaOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单类型的值
		*/
		private String xianhuaOrderValue;
		/**
		* 支付类型的值
		*/
		private String xianhuaOrderPaymentValue;



		//级联表 address
			/**
			* 收货地址 的 创建用户
			*/
			private Integer addressYonghuId;
			/**
			* 收货人
			*/
			private String addressName;
			/**
			* 电话
			*/
			private String addressPhone;
			/**
			* 地址
			*/
			private String addressDizhi;
			/**
			* 是否默认地址
			*/
			private Integer isdefaultTypes;
				/**
				* 是否默认地址的值
				*/
				private String isdefaultValue;

		//级联表 xianhua
			/**
			* 鲜花名称
			*/
			private String xianhuaName;
			/**
			* 鲜花照片
			*/
			private String xianhuaPhoto;
			/**
			* 鲜花类型
			*/
			private Integer xianhuaTypes;
				/**
				* 鲜花类型的值
				*/
				private String xianhuaValue;
			/**
			* 鲜花库存
			*/
			private Integer xianhuaKucunNumber;
			/**
			* 购买获得积分
			*/
			private Integer xianhuaPrice;
			/**
			* 鲜花原价
			*/
			private Double xianhuaOldMoney;
			/**
			* 现价
			*/
			private Double xianhuaNewMoney;
			/**
			* 点击次数
			*/
			private Integer xianhuaClicknum;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer xianhuaDelete;
			/**
			* 鲜花简介
			*/
			private String xianhuaContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 总积分
			*/
			private Double yonghuSumJifen;
			/**
			* 现积分
			*/
			private Double yonghuNewJifen;
			/**
			* 会员等级
			*/
			private Integer huiyuandengjiTypes;
				/**
				* 会员等级的值
				*/
				private String huiyuandengjiValue;

	public XianhuaOrderView() {

	}

	public XianhuaOrderView(XianhuaOrderEntity xianhuaOrderEntity) {
		try {
			BeanUtils.copyProperties(this, xianhuaOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单类型的值
			*/
			public String getXianhuaOrderValue() {
				return xianhuaOrderValue;
			}
			/**
			* 设置： 订单类型的值
			*/
			public void setXianhuaOrderValue(String xianhuaOrderValue) {
				this.xianhuaOrderValue = xianhuaOrderValue;
			}
			/**
			* 获取： 支付类型的值
			*/
			public String getXianhuaOrderPaymentValue() {
				return xianhuaOrderPaymentValue;
			}
			/**
			* 设置： 支付类型的值
			*/
			public void setXianhuaOrderPaymentValue(String xianhuaOrderPaymentValue) {
				this.xianhuaOrderPaymentValue = xianhuaOrderPaymentValue;
			}




				//级联表的get和set address
					/**
					* 获取：收货地址 的 创建用户
					*/
					public Integer getAddressYonghuId() {
						return addressYonghuId;
					}
					/**
					* 设置：收货地址 的 创建用户
					*/
					public void setAddressYonghuId(Integer addressYonghuId) {
						this.addressYonghuId = addressYonghuId;
					}

					/**
					* 获取： 收货人
					*/
					public String getAddressName() {
						return addressName;
					}
					/**
					* 设置： 收货人
					*/
					public void setAddressName(String addressName) {
						this.addressName = addressName;
					}
					/**
					* 获取： 电话
					*/
					public String getAddressPhone() {
						return addressPhone;
					}
					/**
					* 设置： 电话
					*/
					public void setAddressPhone(String addressPhone) {
						this.addressPhone = addressPhone;
					}
					/**
					* 获取： 地址
					*/
					public String getAddressDizhi() {
						return addressDizhi;
					}
					/**
					* 设置： 地址
					*/
					public void setAddressDizhi(String addressDizhi) {
						this.addressDizhi = addressDizhi;
					}
					/**
					* 获取： 是否默认地址
					*/
					public Integer getIsdefaultTypes() {
						return isdefaultTypes;
					}
					/**
					* 设置： 是否默认地址
					*/
					public void setIsdefaultTypes(Integer isdefaultTypes) {
						this.isdefaultTypes = isdefaultTypes;
					}


						/**
						* 获取： 是否默认地址的值
						*/
						public String getIsdefaultValue() {
							return isdefaultValue;
						}
						/**
						* 设置： 是否默认地址的值
						*/
						public void setIsdefaultValue(String isdefaultValue) {
							this.isdefaultValue = isdefaultValue;
						}





















				//级联表的get和set xianhua
					/**
					* 获取： 鲜花名称
					*/
					public String getXianhuaName() {
						return xianhuaName;
					}
					/**
					* 设置： 鲜花名称
					*/
					public void setXianhuaName(String xianhuaName) {
						this.xianhuaName = xianhuaName;
					}
					/**
					* 获取： 鲜花照片
					*/
					public String getXianhuaPhoto() {
						return xianhuaPhoto;
					}
					/**
					* 设置： 鲜花照片
					*/
					public void setXianhuaPhoto(String xianhuaPhoto) {
						this.xianhuaPhoto = xianhuaPhoto;
					}
					/**
					* 获取： 鲜花类型
					*/
					public Integer getXianhuaTypes() {
						return xianhuaTypes;
					}
					/**
					* 设置： 鲜花类型
					*/
					public void setXianhuaTypes(Integer xianhuaTypes) {
						this.xianhuaTypes = xianhuaTypes;
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
					* 获取： 鲜花库存
					*/
					public Integer getXianhuaKucunNumber() {
						return xianhuaKucunNumber;
					}
					/**
					* 设置： 鲜花库存
					*/
					public void setXianhuaKucunNumber(Integer xianhuaKucunNumber) {
						this.xianhuaKucunNumber = xianhuaKucunNumber;
					}
					/**
					* 获取： 购买获得积分
					*/
					public Integer getXianhuaPrice() {
						return xianhuaPrice;
					}
					/**
					* 设置： 购买获得积分
					*/
					public void setXianhuaPrice(Integer xianhuaPrice) {
						this.xianhuaPrice = xianhuaPrice;
					}
					/**
					* 获取： 鲜花原价
					*/
					public Double getXianhuaOldMoney() {
						return xianhuaOldMoney;
					}
					/**
					* 设置： 鲜花原价
					*/
					public void setXianhuaOldMoney(Double xianhuaOldMoney) {
						this.xianhuaOldMoney = xianhuaOldMoney;
					}
					/**
					* 获取： 现价
					*/
					public Double getXianhuaNewMoney() {
						return xianhuaNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setXianhuaNewMoney(Double xianhuaNewMoney) {
						this.xianhuaNewMoney = xianhuaNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getXianhuaClicknum() {
						return xianhuaClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setXianhuaClicknum(Integer xianhuaClicknum) {
						this.xianhuaClicknum = xianhuaClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
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
					/**
					* 获取： 逻辑删除
					*/
					public Integer getXianhuaDelete() {
						return xianhuaDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setXianhuaDelete(Integer xianhuaDelete) {
						this.xianhuaDelete = xianhuaDelete;
					}
					/**
					* 获取： 鲜花简介
					*/
					public String getXianhuaContent() {
						return xianhuaContent;
					}
					/**
					* 设置： 鲜花简介
					*/
					public void setXianhuaContent(String xianhuaContent) {
						this.xianhuaContent = xianhuaContent;
					}





















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 总积分
					*/
					public Double getYonghuSumJifen() {
						return yonghuSumJifen;
					}
					/**
					* 设置： 总积分
					*/
					public void setYonghuSumJifen(Double yonghuSumJifen) {
						this.yonghuSumJifen = yonghuSumJifen;
					}
					/**
					* 获取： 现积分
					*/
					public Double getYonghuNewJifen() {
						return yonghuNewJifen;
					}
					/**
					* 设置： 现积分
					*/
					public void setYonghuNewJifen(Double yonghuNewJifen) {
						this.yonghuNewJifen = yonghuNewJifen;
					}
					/**
					* 获取： 会员等级
					*/
					public Integer getHuiyuandengjiTypes() {
						return huiyuandengjiTypes;
					}
					/**
					* 设置： 会员等级
					*/
					public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
						this.huiyuandengjiTypes = huiyuandengjiTypes;
					}


						/**
						* 获取： 会员等级的值
						*/
						public String getHuiyuandengjiValue() {
							return huiyuandengjiValue;
						}
						/**
						* 设置： 会员等级的值
						*/
						public void setHuiyuandengjiValue(String huiyuandengjiValue) {
							this.huiyuandengjiValue = huiyuandengjiValue;
						}




}
