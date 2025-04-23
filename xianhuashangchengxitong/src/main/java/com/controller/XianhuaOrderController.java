
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 鲜花订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xianhuaOrder")
public class XianhuaOrderController {
    private static final Logger logger = LoggerFactory.getLogger(XianhuaOrderController.class);

    @Autowired
    private XianhuaOrderService xianhuaOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private AddressService addressService;
    @Autowired
    private XianhuaService xianhuaService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private CartService cartService;
@Autowired
private XianhuaCommentbackService xianhuaCommentbackService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xianhuaOrderService.queryPage(params);

        //字典表数据转换
        List<XianhuaOrderView> list =(List<XianhuaOrderView>)page.getList();
        for(XianhuaOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XianhuaOrderEntity xianhuaOrder = xianhuaOrderService.selectById(id);
        if(xianhuaOrder !=null){
            //entity转view
            XianhuaOrderView view = new XianhuaOrderView();
            BeanUtils.copyProperties( xianhuaOrder , view );//把实体数据重构到view中

                //级联表
                AddressEntity address = addressService.selectById(xianhuaOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                    view.setAddressYonghuId(address.getYonghuId());
                }
                //级联表
                XianhuaEntity xianhua = xianhuaService.selectById(xianhuaOrder.getXianhuaId());
                if(xianhua != null){
                    BeanUtils.copyProperties( xianhua , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXianhuaId(xianhua.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xianhuaOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XianhuaOrderEntity xianhuaOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xianhuaOrder:{}",this.getClass().getName(),xianhuaOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xianhuaOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        xianhuaOrder.setInsertTime(new Date());
        xianhuaOrder.setCreateTime(new Date());
        xianhuaOrderService.insert(xianhuaOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XianhuaOrderEntity xianhuaOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xianhuaOrder:{}",this.getClass().getName(),xianhuaOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xianhuaOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XianhuaOrderEntity> queryWrapper = new EntityWrapper<XianhuaOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XianhuaOrderEntity xianhuaOrderEntity = xianhuaOrderService.selectOne(queryWrapper);
        if(xianhuaOrderEntity==null){
            xianhuaOrderService.updateById(xianhuaOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xianhuaOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<XianhuaOrderEntity> xianhuaOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XianhuaOrderEntity xianhuaOrderEntity = new XianhuaOrderEntity();
//                            xianhuaOrderEntity.setXianhuaOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            xianhuaOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收获地址 要改的
//                            xianhuaOrderEntity.setXianhuaId(Integer.valueOf(data.get(0)));   //鲜花 要改的
//                            xianhuaOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xianhuaOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            xianhuaOrderEntity.setXianhuaOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            xianhuaOrderEntity.setXianhuaOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            xianhuaOrderEntity.setXianhuaOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            xianhuaOrderEntity.setXianhuaOrderKuaididanhao(data.get(0));                    //快递单号 要改的
//                            xianhuaOrderEntity.setInsertTime(date);//时间
//                            xianhuaOrderEntity.setCreateTime(date);//时间
                            xianhuaOrderList.add(xianhuaOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("xianhuaOrderUuidNumber")){
                                    List<String> xianhuaOrderUuidNumber = seachFields.get("xianhuaOrderUuidNumber");
                                    xianhuaOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xianhuaOrderUuidNumber = new ArrayList<>();
                                    xianhuaOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xianhuaOrderUuidNumber",xianhuaOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<XianhuaOrderEntity> xianhuaOrderEntities_xianhuaOrderUuidNumber = xianhuaOrderService.selectList(new EntityWrapper<XianhuaOrderEntity>().in("xianhua_order_uuid_number", seachFields.get("xianhuaOrderUuidNumber")));
                        if(xianhuaOrderEntities_xianhuaOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XianhuaOrderEntity s:xianhuaOrderEntities_xianhuaOrderUuidNumber){
                                repeatFields.add(s.getXianhuaOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xianhuaOrderService.insertBatch(xianhuaOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = xianhuaOrderService.queryPage(params);

        //字典表数据转换
        List<XianhuaOrderView> list =(List<XianhuaOrderView>)page.getList();
        for(XianhuaOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XianhuaOrderEntity xianhuaOrder = xianhuaOrderService.selectById(id);
            if(xianhuaOrder !=null){


                //entity转view
                XianhuaOrderView view = new XianhuaOrderView();
                BeanUtils.copyProperties( xianhuaOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(xianhuaOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    XianhuaEntity xianhua = xianhuaService.selectById(xianhuaOrder.getXianhuaId());
                if(xianhua != null){
                    BeanUtils.copyProperties( xianhua , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXianhuaId(xianhua.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xianhuaOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XianhuaOrderEntity xianhuaOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xianhuaOrder:{}",this.getClass().getName(),xianhuaOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            XianhuaEntity xianhuaEntity = xianhuaService.selectById(xianhuaOrder.getXianhuaId());
            if(xianhuaEntity == null){
                return R.error(511,"查不到该物品");
            }
            // Double xianhuaNewMoney = xianhuaEntity.getXianhuaNewMoney();

            if(false){
            }
            else if((xianhuaEntity.getXianhuaKucunNumber() -xianhuaOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }
            else if(xianhuaEntity.getXianhuaNewMoney() == null){
                return R.error(511,"物品价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - xianhuaEntity.getXianhuaNewMoney()*xianhuaOrder.getBuyNumber();//余额
            buyJifen = new BigDecimal(xianhuaEntity.getXianhuaPrice()).multiply(new BigDecimal(xianhuaOrder.getBuyNumber())).doubleValue();//所获积分
            if(balance<0)
                return R.error(511,"余额不够支付");
            xianhuaOrder.setXianhuaOrderTypes(3); //设置订单状态为已支付
            xianhuaOrder.setXianhuaOrderTruePrice(xianhuaEntity.getXianhuaNewMoney()*xianhuaOrder.getBuyNumber()); //设置实付价格
            xianhuaOrder.setYonghuId(userId); //设置订单支付人id
            xianhuaOrder.setXianhuaOrderPaymentTypes(1);
            xianhuaOrder.setInsertTime(new Date());
            xianhuaOrder.setCreateTime(new Date());
                xianhuaEntity.setXianhuaKucunNumber( xianhuaEntity.getXianhuaKucunNumber() -xianhuaOrder.getBuyNumber());
                xianhuaService.updateById(xianhuaEntity);
                xianhuaOrderService.insert(xianhuaOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() + buyJifen); //设置总积分
            yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置现积分
                if(yonghuEntity.getYonghuSumJifen()  < 10000)
                    yonghuEntity.setHuiyuandengjiTypes(1);
                else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                    yonghuEntity.setHuiyuandengjiTypes(2);
                else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                    yonghuEntity.setHuiyuandengjiTypes(3);
            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String xianhuaOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

        Integer xianhuaOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("xianhuaOrderPaymentTypes")));//支付类型
//        Integer xianhuaOrderKuaididanhao = Integer.valueOf(String.valueOf(params.get("xianhuaOrderKuaididanhao")));//快递单号

        String data = String.valueOf(params.get("xianhuas"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> xianhuas = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<XianhuaOrderEntity> xianhuaOrderList = new ArrayList<>();
        //商品表
        List<XianhuaEntity> xianhuaList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);
        // 获取折扣
        Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                .eq("dic_code", "huiyuandengji_types")
                .eq("dic_name", "会员等级类型")
                .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                ;
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
        if(dictionaryEntity != null ){
            zhekou = BigDecimal.valueOf(Double.valueOf(dictionaryEntity.getBeizhu()));
        }

        //循环取出需要的数据
        for (Map<String, Object> map : xianhuas) {
           //取值
            Integer xianhuaId = Integer.valueOf(String.valueOf(map.get("xianhuaId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            XianhuaEntity xianhuaEntity = xianhuaService.selectById(xianhuaId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //判断商品的库存是否足够
            if(xianhuaEntity.getXianhuaKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(xianhuaEntity.getXianhuaName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                xianhuaEntity.setXianhuaKucunNumber(xianhuaEntity.getXianhuaKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            XianhuaOrderEntity xianhuaOrderEntity = new XianhuaOrderEntity<>();

            //赋值订单信息
            xianhuaOrderEntity.setXianhuaOrderUuidNumber(xianhuaOrderUuidNumber);//订单号
            xianhuaOrderEntity.setAddressId(addressId);//收获地址
            xianhuaOrderEntity.setXianhuaId(xianhuaId);//鲜花
            xianhuaOrderEntity.setYonghuId(userId);//用户
            xianhuaOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            xianhuaOrderEntity.setXianhuaOrderTypes(3);//订单类型
            xianhuaOrderEntity.setXianhuaOrderPaymentTypes(xianhuaOrderPaymentTypes);//支付类型
//            xianhuaOrderEntity.setXianhuaOrderKuaididanhao(xianhuaOrderKuaididanhao);//快递单号 ？？？？？？
            xianhuaOrderEntity.setInsertTime(new Date());//订单创建时间
            xianhuaOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(xianhuaOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(xianhuaEntity.getXianhuaNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                        buyJifen = new BigDecimal(xianhuaEntity.getXianhuaPrice()).multiply(new BigDecimal(buyNumber)).doubleValue();
                    yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额
                    yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() + buyJifen); //设置总积分
                    yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置现积分
                        if(yonghuEntity.getYonghuSumJifen()  < 10000)
                            yonghuEntity.setHuiyuandengjiTypes(1);
                        else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                            yonghuEntity.setHuiyuandengjiTypes(2);
                        else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                            yonghuEntity.setHuiyuandengjiTypes(3);


                    xianhuaOrderEntity.setXianhuaOrderTruePrice(money);

                }
            }
            xianhuaOrderList.add(xianhuaOrderEntity);
            xianhuaList.add(xianhuaEntity);

        }
        xianhuaOrderService.insertBatch(xianhuaOrderList);
        xianhuaService.updateBatchById(xianhuaList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);
        return R.ok();
    }











    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

        if("用户".equals(role)){
            XianhuaOrderEntity xianhuaOrder = xianhuaOrderService.selectById(id);
            Integer buyNumber = xianhuaOrder.getBuyNumber();
            Integer xianhuaOrderPaymentTypes = xianhuaOrder.getXianhuaOrderPaymentTypes();
            Integer xianhuaId = xianhuaOrder.getXianhuaId();
            if(xianhuaId == null)
                return R.error(511,"查不到该物品");
            XianhuaEntity xianhuaEntity = xianhuaService.selectById(xianhuaId);
            if(xianhuaEntity == null)
                return R.error(511,"查不到该物品");
            Double xianhuaNewMoney = xianhuaEntity.getXianhuaNewMoney();
            if(xianhuaNewMoney == null)
                return R.error(511,"物品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;
            // 获取折扣
            Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                    .eq("dic_code", "huiyuandengji_types")
                    .eq("dic_name", "会员等级类型")
                    .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                    ;
            DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
            if(dictionaryEntity != null ){
                zhekou = Double.valueOf(dictionaryEntity.getBeizhu());
            }


            //判断是什么支付方式 1代表余额 2代表积分
            if(xianhuaOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = xianhuaEntity.getXianhuaNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                buyJifen = new BigDecimal(xianhuaEntity.getXianhuaPrice()).multiply(new BigDecimal(buyNumber)).doubleValue();
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额
                yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() - buyJifen); //设置总积分
                if(yonghuEntity.getYonghuNewJifen() - buyJifen <0 )
                    return R.error("积分已经消费,无法退款！！！");
                yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() - buyJifen); //设置现积分

                if(yonghuEntity.getYonghuSumJifen()  < 10000)
                    yonghuEntity.setHuiyuandengjiTypes(1);
                else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                    yonghuEntity.setHuiyuandengjiTypes(2);
                else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                    yonghuEntity.setHuiyuandengjiTypes(3);

            }

            xianhuaEntity.setXianhuaKucunNumber(xianhuaEntity.getXianhuaKucunNumber() + buyNumber);



            xianhuaOrder.setXianhuaOrderTypes(2);//设置订单状态为退款
            xianhuaOrderService.updateById(xianhuaOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            xianhuaService.updateById(xianhuaEntity);//更新订单中物品的信息
            return R.ok();
        }else{
            return R.error(511,"您没有权限退款");
        }
    }


    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id , String xianhuaOrderKuaididanhao){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        XianhuaOrderEntity  xianhuaOrderEntity = new  XianhuaOrderEntity();;
        xianhuaOrderEntity.setId(id);
        xianhuaOrderEntity.setXianhuaOrderTypes(4);
        xianhuaOrderEntity.setXianhuaOrderKuaididanhao(xianhuaOrderKuaididanhao);
        boolean b =  xianhuaOrderService.updateById( xianhuaOrderEntity);
        if(!b){
            return R.error("发货出错");
        }
        return R.ok();
    }









    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        XianhuaOrderEntity  xianhuaOrderEntity = new  XianhuaOrderEntity();
        xianhuaOrderEntity.setId(id);
        xianhuaOrderEntity.setXianhuaOrderTypes(5);
        boolean b =  xianhuaOrderService.updateById( xianhuaOrderEntity);
        if(!b){
            return R.error("收货出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer xianhuaCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            XianhuaOrderEntity xianhuaOrder = xianhuaOrderService.selectById(id);
        if(xianhuaOrder == null)
            return R.error(511,"查不到该订单");
        if(xianhuaOrder.getXianhuaOrderTypes() != 5)
            return R.error(511,"您不能评价");
        Integer xianhuaId = xianhuaOrder.getXianhuaId();
        if(xianhuaId == null)
            return R.error(511,"查不到该物品");

        XianhuaCommentbackEntity xianhuaCommentbackEntity = new XianhuaCommentbackEntity();
            xianhuaCommentbackEntity.setId(id);
            xianhuaCommentbackEntity.setXianhuaId(xianhuaId);
            xianhuaCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            xianhuaCommentbackEntity.setXianhuaCommentbackText(commentbackText);
            xianhuaCommentbackEntity.setReplyText(null);
            xianhuaCommentbackEntity.setInsertTime(new Date());
            xianhuaCommentbackEntity.setUpdateTime(null);
            xianhuaCommentbackEntity.setCreateTime(new Date());
            xianhuaCommentbackService.insert(xianhuaCommentbackEntity);

            xianhuaOrder.setXianhuaOrderTypes(1);//设置订单状态为已评价
            xianhuaOrderService.updateById(xianhuaOrder);//根据id更新
            return R.ok();
        }else{
            return R.error(511,"您没有权限评价");
        }
    }







}
