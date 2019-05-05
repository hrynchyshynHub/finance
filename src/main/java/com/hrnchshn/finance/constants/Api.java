package com.hrnchshn.finance.constants;

public interface Api {

    /***************************************
     * REST ENDPOINTS                      *
     * ************************************/
    String USER_PATH = "/user";
    String NOTE_PATH = "/note";
    String CURRENCY_PATH = "/currency";
    String TRANSACTIO_PATH = "/transaction";
    String BUDGET_PATH = "/budget";
    String NEWS_PATH = "/news";

    /***************************************
     * REST ENDPOINTS FOR SUBUZ            *
     * ************************************/
    String JOURNEY = "/journey";

    /**************************************
     * Currencies                         *
     **************************************/
    String UAH = "UAH";
    String USD = "USD";
    String EUR = "EUR";

    /***************************************
     * External API                        *
     ***************************************/
    String UA_BANK_API = "http://bank-ua.com/export/exchange_rate_cash.json";
    String PRIVAT_BANK = "http://bank-ua.com/banks/privatbank/";
    String UZ_GOV = "https://booking.uz.gov.ua/train_search/";

    /***************************************
     * Security                            *
     ***************************************/
    String AUTH_ENDPOINT = USER_PATH + "/auth";
    String USER_SIGN_UP = USER_PATH + "/sign-up";
    String BEARER = "Bearer ";
    String AUTH_HEADER = "Authorization";
}
