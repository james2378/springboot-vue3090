package com.entity;

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
 * 鲜花
 *
 * @author 
 * @email
 */
@TableName("xianhua")
public class XianhuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XianhuaEntity() {

	}

	public XianhuaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 鲜花名称
     */
    @TableField(value = "xianhua_name")

    private String xianhuaName;


    /**
     * 鲜花照片
     */
    @TableField(value = "xianhua_photo")

    private String xianhuaPhoto;


    /**
     * 鲜花类型
     */
    @TableField(value = "xianhua_types")

    private Integer xianhuaTypes;


    /**
     * 鲜花库存
     */
    @TableField(value = "xianhua_kucun_number")

    private Integer xianhuaKucunNumber;


    /**
     * 购买获得积分
     */
    @TableField(value = "xianhua_price")

    private Integer xianhuaPrice;


    /**
     * 鲜花原价
     */
    @TableField(value = "xianhua_old_money")

    private Double xianhuaOldMoney;


    /**
     * 现价
     */
    @TableField(value = "xianhua_new_money")

    private Double xianhuaNewMoney;


    /**
     * 点击次数
     */
    @TableField(value = "xianhua_clicknum")

    private Integer xianhuaClicknum;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "xianhua_delete")

    private Integer xianhuaDelete;


    /**
     * 鲜花简介
     */
    @TableField(value = "xianhua_content")

    private String xianhuaContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：鲜花名称
	 */
    public String getXianhuaName() {
        return xianhuaName;
    }


    /**
	 * 获取：鲜花名称
	 */

    public void setXianhuaName(String xianhuaName) {
        this.xianhuaName = xianhuaName;
    }
    /**
	 * 设置：鲜花照片
	 */
    public String getXianhuaPhoto() {
        return xianhuaPhoto;
    }


    /**
	 * 获取：鲜花照片
	 */

    public void setXianhuaPhoto(String xianhuaPhoto) {
        this.xianhuaPhoto = xianhuaPhoto;
    }
    /**
	 * 设置：鲜花类型
	 */
    public Integer getXianhuaTypes() {
        return xianhuaTypes;
    }


    /**
	 * 获取：鲜花类型
	 */

    public void setXianhuaTypes(Integer xianhuaTypes) {
        this.xianhuaTypes = xianhuaTypes;
    }
    /**
	 * 设置：鲜花库存
	 */
    public Integer getXianhuaKucunNumber() {
        return xianhuaKucunNumber;
    }


    /**
	 * 获取：鲜花库存
	 */

    public void setXianhuaKucunNumber(Integer xianhuaKucunNumber) {
        this.xianhuaKucunNumber = xianhuaKucunNumber;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getXianhuaPrice() {
        return xianhuaPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setXianhuaPrice(Integer xianhuaPrice) {
        this.xianhuaPrice = xianhuaPrice;
    }
    /**
	 * 设置：鲜花原价
	 */
    public Double getXianhuaOldMoney() {
        return xianhuaOldMoney;
    }


    /**
	 * 获取：鲜花原价
	 */

    public void setXianhuaOldMoney(Double xianhuaOldMoney) {
        this.xianhuaOldMoney = xianhuaOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getXianhuaNewMoney() {
        return xianhuaNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setXianhuaNewMoney(Double xianhuaNewMoney) {
        this.xianhuaNewMoney = xianhuaNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getXianhuaClicknum() {
        return xianhuaClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setXianhuaClicknum(Integer xianhuaClicknum) {
        this.xianhuaClicknum = xianhuaClicknum;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXianhuaDelete() {
        return xianhuaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXianhuaDelete(Integer xianhuaDelete) {
        this.xianhuaDelete = xianhuaDelete;
    }
    /**
	 * 设置：鲜花简介
	 */
    public String getXianhuaContent() {
        return xianhuaContent;
    }


    /**
	 * 获取：鲜花简介
	 */

    public void setXianhuaContent(String xianhuaContent) {
        this.xianhuaContent = xianhuaContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xianhua{" +
            "id=" + id +
            ", xianhuaName=" + xianhuaName +
            ", xianhuaPhoto=" + xianhuaPhoto +
            ", xianhuaTypes=" + xianhuaTypes +
            ", xianhuaKucunNumber=" + xianhuaKucunNumber +
            ", xianhuaPrice=" + xianhuaPrice +
            ", xianhuaOldMoney=" + xianhuaOldMoney +
            ", xianhuaNewMoney=" + xianhuaNewMoney +
            ", xianhuaClicknum=" + xianhuaClicknum +
            ", shangxiaTypes=" + shangxiaTypes +
            ", xianhuaDelete=" + xianhuaDelete +
            ", xianhuaContent=" + xianhuaContent +
            ", createTime=" + createTime +
        "}";
    }
}
