package com.javalearning.demo.WebService;

import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.Map;

@Service
public class MyService {

    private final WebServiceTemplate webServiceTemplate;

    public MyService(WebServiceTemplateBuilder webServiceTemplateBuilder) {
        this.webServiceTemplate = webServiceTemplateBuilder.build();
    }

    public Map someWsCall(Map detailsReq) {
        return (Map) this.webServiceTemplate.marshalSendAndReceive(detailsReq,
                new SoapActionCallback("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx"));
    }

}
