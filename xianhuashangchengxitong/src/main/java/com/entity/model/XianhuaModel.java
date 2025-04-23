package com.entity.model;

import com.entity.XianhuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 鲜花
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XianhuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 逻辑删除
     */
    private Integer xianhuaDelete;


    /**
     * 鲜花简介
     */
    private String xianhuaContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：鲜花名称
	 */
    public String getXianhuaName() {
        return xianhuaName;
    }


    /**
	 * 设置：鲜花名称
	 */
    public void setXianhuaName(String xianhuaName) {
        this.xianhuaName = xianhuaName;
    }
    /**
	 * 获取：鲜花照片
	 */
    public String getXianhuaPhoto() {
        return xianhuaPhoto;
    }


    /**
	 * 设置：鲜花照片
	 */
    public void setXianhuaPhoto(String xianhuaPhoto) {
        this.xianhuaPhoto = xianhuaPhoto;
    }
    /**
	 * 获取：鲜花类型
	 */
    public Integer getXianhuaTypes() {
        return xianhuaTypes;
    }


    /**
	 * 设置：鲜花类型
	 */
    public void setXianhuaTypes(Integer xianhuaTypes) {
        this.xianhuaTypes = xianhuaTypes;
    }
    /**
	 * 获取：鲜花库存
	 */
    public Integer getXianhuaKucunNumber() {
        return xianhuaKucunNumber;
    }


    /**
	 * 设置：鲜花库存
	 */
    public void setXianhuaKucunNumber(Integer xianhuaKucunNumber) {
        this.xianhuaKucunNumber = xianhuaKucunNumber;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getXianhuaPrice() {
        return xianhuaPrice;
    }


    /**
	 * 设置：购买获得积分
	 */
    public void setXianhuaPrice(Integer xianhuaPrice) {
        this.xianhuaPrice = xianhuaPrice;
    }
    /**
	 * 获取：鲜花原价
	 */
    public Double getXianhuaOldMoney() {
        return xianhuaOldMoney;
    }


    /**
	 * 设置：鲜花原价
	 */
    public void setXianhuaOldMoney(Double xianhuaOldMoney) {
        this.xianhuaOldMoney = xianhuaOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getXianhuaNewMoney() {
        return xianhuaNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setXianhuaNewMoney(Double xianhuaNewMoney) {
        this.xianhuaNewMoney = xianhuaNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getXianhuaClicknum() {
        return xianhuaClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setXianhuaClicknum(Integer xianhuaClicknum) {
        this.xianhuaClicknum = xianhuaClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXianhuaDelete() {
        return xianhuaDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXianhuaDelete(Integer xianhuaDelete) {
        this.xianhuaDelete = xianhuaDelete;
    }
    /**
	 * 获取：鲜花简介
	 */
    public String getXianhuaContent() {
        return xianhuaContent;
    }


    /**
	 * 设置：鲜花简介
	 */
    public void setXianhuaContent(String xianhuaContent) {
        this.xianhuaContent = xianhuaContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
