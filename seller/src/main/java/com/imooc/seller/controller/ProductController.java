package com.imooc.seller.controller;

import com.imooc.entity.Product;
import com.imooc.seller.service.ProductRpcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@Api(tags = "product",description = "产品相关")
public class ProductController {

    @Autowired
    private ProductRpcService productRpcService;

    @ApiOperation(value = "查询产品",notes = "根据对应ID查询相应的产品")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findOne(@PathVariable String id){
        return productRpcService.findOne(id);
    }

}
