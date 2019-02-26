package com.hrnchshn.finance.constants;

public interface Api {

    /***************************************
     * REST ENDPOINTS                      *
     * ************************************/
    String USER_PATH = "/user";
    String NOTE_PATH = "/note";
    String CURRENCY_PATH = "/currency";
    String TRANSACTIO_PATH = "/transaction";

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

    /***************************************
     * Security                            *
     ***************************************/
    String AUTH_ENDPOINT = USER_PATH + "/auth";
    String USER_SIGN_UP = USER_PATH + "/sign-up";
    String BEARER = "Bearer ";
    String AUTH_HEADER = "Authorization";
}
