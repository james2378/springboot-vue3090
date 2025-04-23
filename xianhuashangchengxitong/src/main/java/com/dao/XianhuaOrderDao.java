package com.dao;

import com.entity.XianhuaOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XianhuaOrderView;

/**
 * 鲜花订单 Dao 接口
 *
 * @author 
 */
public interface XianhuaOrderDao extends BaseMapper<XianhuaOrderEntity> {

   List<XianhuaOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
