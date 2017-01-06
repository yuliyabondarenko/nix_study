package com.nixsolutions.bondarenko.study.soap.hello;


import com.nixsolutions.bondarenko.study.soap.hello.model.Goods;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloSoap {

    @WebMethod
    String testService();

    @WebMethod
    String sayHelloTo(@WebParam(name = "text") String text);

    @WebMethod
    Goods getGoods();
}