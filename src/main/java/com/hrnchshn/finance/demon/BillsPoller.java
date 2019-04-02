package com.hrnchshn.finance.demon;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author ivan.hrynchyshyn
 */
@Component
public class BillsPoller extends RouteBuilder {

    @BeanInject
    private OcrProcessor ocrProcessor;
    @BeanInject
    private XmlProcessor xmlProcessor;


    @Override
    public void configure() throws Exception {
        from("file://bills?noop=true")
                .autoStartup(false)
                .log("File found")
                .process(ocrProcessor)
                .process(xmlProcessor);
    }
}
