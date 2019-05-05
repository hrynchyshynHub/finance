package com.hrnchshn.finance;

import com.hrnchshn.finance.subuz.managers.UzGovResponseParser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ivan.hrynchyshyn
 */
public class UzGovResponseParserTest {



    @Test
    public void test(){
        String response1 = "{\"data\":{\"warning\":\"По заданому Вами напрямку місць немає\",\"list\":[]}}";
        String response2 = "{\"data\":{\"list\":[{\"num\":\"045Л\",\"category\":0,\"isTransformer\":0,\"travelTime\":\"18:44\",\"from\":{\"code\":\"2218000\",\"station\":\"Львів\",\"stationTrain\":\"Ужгород\",\"date\":\"субота, 04.05.2019\",\"time\":\"03:23\",\"sortTime\":1556929380,\"srcDate\":\"2019-05-04\"},\"to\":{\"code\":\"2204001\",\"station\":\"Харків-Пас\",\"stationTrain\":\"Лисичанськ\",\"date\":\"субота, 04.05.2019\",\"time\":\"22:07\",\"sortTime\":1556996820},\"types\":[],\"child\":{\"minDate\":\"2005-05-05\",\"maxDate\":\"2019-05-04\"},\"allowStudent\":1,\"allowBooking\":1,\"isCis\":0,\"isEurope\":0,\"allowPrivilege\":1,\"noReserve\":1},{\"num\":\"142Ш\",\"category\":0,\"isTransformer\":0,\"travelTime\":\"24:01\",\"from\":{\"code\":\"2218000\",\"station\":\"Львів\",\"stationTrain\":\"Львів\",\"date\":\"субота, 04.05.2019\",\"time\":\"14:24\",\"sortTime\":1556969040,\"srcDate\":\"2019-05-04\"},\"to\":{\"code\":\"2204001\",\"station\":\"Харків-Пас\",\"stationTrain\":\"Бахмут\",\"date\":\"неділя, 05.05.2019\",\"time\":\"14:25\",\"sortTime\":1557055500},\"types\":[],\"child\":{\"minDate\":\"2005-05-05\",\"maxDate\":\"2019-05-04\"},\"allowStudent\":1,\"allowBooking\":1,\"isCis\":0,\"isEurope\":0,\"allowPrivilege\":1,\"noReserve\":1},{\"num\":\"112К\",\"category\":0,\"isTransformer\":0,\"travelTime\":\"19:38\",\"from\":{\"code\":\"2218000\",\"station\":\"Львів\",\"stationTrain\":\"Львів\",\"date\":\"субота, 04.05.2019\",\"time\":\"17:50\",\"sortTime\":1556981400,\"srcDate\":\"2019-05-04\"},\"to\":{\"code\":\"2204001\",\"station\":\"Харків-Пас\",\"stationTrain\":\"Харків-Пас\",\"date\":\"неділя, 05.05.2019\",\"time\":\"13:28\",\"sortTime\":1557052080},\"types\":[],\"child\":{\"minDate\":\"2005-05-05\",\"maxDate\":\"2019-05-04\"},\"allowStudent\":1,\"allowBooking\":1,\"isCis\":0,\"isEurope\":0,\"allowPrivilege\":1,\"noReserve\":1},{\"num\":\"017Ш\",\"category\":0,\"isTransformer\":0,\"travelTime\":\"13:35\",\"from\":{\"code\":\"2218000\",\"station\":\"Львів\",\"stationTrain\":\"Ужгород\",\"date\":\"субота, 04.05.2019\",\"time\":\"19:04\",\"sortTime\":1556985840,\"srcDate\":\"2019-05-04\"},\"to\":{\"code\":\"2204001\",\"station\":\"Харків-Пас\",\"stationTrain\":\"Харків-Пас\",\"date\":\"неділя, 05.05.2019\",\"time\":\"08:39\",\"sortTime\":1557034740},\"types\":[],\"child\":{\"minDate\":\"2005-05-05\",\"maxDate\":\"2019-05-04\"},\"allowStudent\":1,\"allowBooking\":1,\"isCis\":0,\"isEurope\":0,\"allowPrivilege\":1,\"noReserve\":1},{\"num\":\"017Л\",\"category\":0,\"isTransformer\":0,\"travelTime\":\"13:35\",\"from\":{\"code\":\"2218000\",\"station\":\"Львів\",\"stationTrain\":\"Ужгород\",\"date\":\"субота, 04.05.2019\",\"time\":\"19:04\",\"sortTime\":1556985840,\"srcDate\":\"2019-05-04\"},\"to\":{\"code\":\"2204001\",\"station\":\"Харків-Пас\",\"stationTrain\":\"Харків-Пас\",\"date\":\"неділя, 05.05.2019\",\"time\":\"08:39\",\"sortTime\":1557034740},\"types\":[{\"id\":\"Л\",\"title\":\"Люкс\",\"letter\":\"Л\",\"places\":1}],\"child\":{\"minDate\":\"2005-05-05\",\"maxDate\":\"2019-05-04\"},\"allowStudent\":1,\"allowBooking\":1,\"isCis\":0,\"isEurope\":0,\"allowPrivilege\":1,\"noReserve\":1},{\"num\":\"001Л\",\"category\":0,\"isTransformer\":0,\"travelTime\":\"13:16\",\"from\":{\"code\":\"2218000\",\"station\":\"Львів\",\"stationTrain\":\"Івано-Франківськ\",\"date\":\"субота, 04.05.2019\",\"time\":\"22:00\",\"sortTime\":1556996400,\"srcDate\":\"2019-05-04\"},\"to\":{\"code\":\"2204001\",\"station\":\"Харків-Пас\",\"stationTrain\":\"Костянтинівка\",\"date\":\"неділя, 05.05.2019\",\"time\":\"11:16\",\"sortTime\":1557044160},\"types\":[{\"id\":\"Л\",\"title\":\"Люкс\",\"letter\":\"Л\",\"places\":8},{\"id\":\"К\",\"title\":\"Купе\",\"letter\":\"К\",\"places\":3}],\"child\":{\"minDate\":\"2005-05-05\",\"maxDate\":\"2019-05-04\"},\"allowStudent\":1,\"allowBooking\":1,\"isCis\":0,\"isEurope\":0,\"allowPrivilege\":1,\"noReserve\":1}]}}\n";

//        parser.parse(response1);
    }
}
