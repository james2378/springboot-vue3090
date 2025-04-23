package com.entity.model;

import com.entity.XianhuaOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 鲜花订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XianhuaOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String xianhuaOrderUuidNumber;


    /**
     * 收获地址
     */
    private Integer addressId;


    /**
     * 鲜花
     */
    private Integer xianhuaId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double xianhuaOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer xianhuaOrderTypes;


    /**
     * 支付类型
     */
    private Integer xianhuaOrderPaymentTypes;


    /**
     * 快递单号
     */
    private String xianhuaOrderKuaididanhao;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getXianhuaOrderUuidNumber() {
        return xianhuaOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setXianhuaOrderUuidNumber(String xianhuaOrderUuidNumber) {
        this.xianhuaOrderUuidNumber = xianhuaOrderUuidNumber;
    }
    /**
	 * 获取：收获地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收获地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：鲜花
	 */
    public Integer getXianhuaId() {
        return xianhuaId;
    }


    /**
	 * 设置：鲜花
	 */
    public void setXianhuaId(Integer xianhuaId) {
        this.xianhuaId = xianhuaId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getXianhuaOrderTruePrice() {
        return xianhuaOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setXianhuaOrderTruePrice(Double xianhuaOrderTruePrice) {
        this.xianhuaOrderTruePrice = xianhuaOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getXianhuaOrderTypes() {
        return xianhuaOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setXianhuaOrderTypes(Integer xianhuaOrderTypes) {
        this.xianhuaOrderTypes = xianhuaOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getXianhuaOrderPaymentTypes() {
        return xianhuaOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setXianhuaOrderPaymentTypes(Integer xianhuaOrderPaymentTypes) {
        this.xianhuaOrderPaymentTypes = xianhuaOrderPaymentTypes;
    }
    /**
	 * 获取：快递单号
	 */
    public String getXianhuaOrderKuaididanhao() {
        return xianhuaOrderKuaididanhao;
    }


    /**
	 * 设置：快递单号
	 */
    public void setXianhuaOrderKuaididanhao(String xianhuaOrderKuaididanhao) {
        this.xianhuaOrderKuaididanhao = xianhuaOrderKuaididanhao;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
