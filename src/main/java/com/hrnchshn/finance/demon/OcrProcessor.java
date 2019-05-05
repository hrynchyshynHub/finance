package com.hrnchshn.finance.demon;

import com.asprise.ocr.Ocr;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author ivan.hrynchyshyn
 */
@Component
public class OcrProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String path = String.class.cast(exchange.getIn().getHeader("CamelFileAbsolutePath"));
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("ukr", Ocr.SPEED_FASTEST);
        String ocrResult = ocr.recognize(new File[] {new File(path)},
                Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
        System.out.println("Result: " + ocrResult);
        exchange.getOut().setBody(ocrResult);
        ocr.stopEngine();
    }
}
