package com.learn.designpattern.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/***
 * This is factory method class that takes care of mapping the driver to the respective implementation class.
 * Instead of writing if else block to direct user to right implementation class. we are using lambda expression
 */
public class GoogleFactory {

    private static final Function<WebDriver,GooglePage> ENG = (d)->new GoogleEnglishPage(d);
    private static final Function<WebDriver,GooglePage> TAM = (d)-> new GoogleTamilPage(d);
    private static final Function<WebDriver,GooglePage> HIN = (d)-> new GoogleHindiPage(d);
    private static final Function<WebDriver,GooglePage> MAL = (d)-> new GoogleMalayalamPage(d);

    private static final Map<String,Function<WebDriver,GooglePage>> MAP = new HashMap<>();

    static{
        MAP.put("ENG",ENG);
        MAP.put("TAM",TAM);
        MAP.put("HIN",HIN);
        MAP.put("MAL",MAL);
    }

    public static GooglePage get(String language, WebDriver driver){
        return MAP.get(language).apply(driver);
    }



}
