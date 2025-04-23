package com.dao;

import com.entity.XianhuaCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XianhuaCollectionView;

/**
 * 鲜花收藏 Dao 接口
 *
 * @author 
 */
public interface XianhuaCollectionDao extends BaseMapper<XianhuaCollectionEntity> {

   List<XianhuaCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
