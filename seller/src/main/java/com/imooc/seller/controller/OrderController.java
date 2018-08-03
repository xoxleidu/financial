package com.imooc.seller.controller;

import com.imooc.entity.Order;
import com.imooc.seller.params.OrderParam;
import com.imooc.seller.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Api(tags = "order",description = "订单相关")
public class OrderController {

    static Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "创建订单",notes = "根据对应业务规则添加相应的产品:authId:身份识别sign:密钥")
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Order apply(@RequestHeader String authId,
                       @RequestHeader String sign,
                       @RequestBody OrderParam param){

        LOG.info("申购请求:{}", param);

        Order order = new Order();
        BeanUtils.copyProperties(param,order);
        order = orderService.apply(order);

        LOG.info("申购结果:{}", order);
        return order;
    }
}
