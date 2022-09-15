package dxg.word.test2api;

public interface Config {


    /**
     * base url for api calls
     * */
    String BASE_URL = "http://universities.hipolabs.com/";


    /**
     * To enable or disable log
     * */
    boolean IS_DEVELOPMENT = true;


    /**
     * Enable log for tracing request links
     * */
    boolean LOG = dxg.word.test2api.Config.IS_DEVELOPMENT;


    /**
     * http client connection read , write  and time out in seconds
     * */
    int HTTP_CONNECTION_TIMEOUT_IN_SEC = 60;
    int HTTP_CONNECTION_READ_TIMEOUT_IN_SEC = 60;
    int HTTP_CONNECTION_WRITE_TIMEOUT_IN_SEC = 60;



}


