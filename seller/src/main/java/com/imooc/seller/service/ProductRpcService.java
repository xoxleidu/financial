package com.imooc.seller.service;

import com.imooc.api.ProductRpc;
import com.imooc.api.domain.ProductRpcReq;
import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品相关服务
 */
@Service
public class ProductRpcService {

    private static Logger LOG = LoggerFactory.getLogger(ProductRpcService.class);

    @Autowired
    private ProductRpc productRpc;

    /**
     * 查询全部产品
     * @return
     */
    public List<Product> findAll(){

        ProductRpcReq req = new ProductRpcReq();

        List<String> status = new ArrayList<>();
        status.add(ProductStatus.IN_SELL.name());

        req.setStatusList(status);

        System.out.println(0101);
        LOG.info("RPC查询全部产品，请求:{}",req);
        List<Product> result = productRpc.query(req);
        LOG.info("RPC查询全部产品，结果:{}",result);

        return result;

    }

    @PostConstruct
    public void testFindAll(){
        findAll();
    }

}
