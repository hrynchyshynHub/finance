package com.hrnchshn.finance.constants;

public interface Api {

    /***************************************
     * REST ENDPOINTS                      *
     * ************************************/
    String USER_PATH = "/user";
    String NOTE_PATH = "/note";
    String CURRENCY_PATH = "/currency";

    /**************************************
     * Currencies                         *
     **************************************/
    String UAH = "UAH";
    String USD = "USD";
    String EUR = "EUR";

    /***************************************
     * Bank API                            *
     ***************************************/
    String UA_BANK_API = "http://bank-ua.com/export/exchange_rate_cash.json";
    String PRIVAT_BANK = "http://bank-ua.com/banks/privatbank/";

}