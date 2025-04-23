package com.dao;

import com.entity.XianhuaCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XianhuaCommentbackView;

/**
 * 鲜花评价 Dao 接口
 *
 * @author 
 */
public interface XianhuaCommentbackDao extends BaseMapper<XianhuaCommentbackEntity> {

   List<XianhuaCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
