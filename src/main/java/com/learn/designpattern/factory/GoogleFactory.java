package com.learn.designpattern.factory;

import org.openqa.selenium.WebDriver;

import java.util.function.Function;

public class GoogleFactory {

    private static final Function<WebDriver,GooglePage> ENG = (d)->new GoogleEnglishPage(d);
    private static final Function<WebDriver,GooglePage> TAM = (d)-> new GoogleTamilPage(d);
    private static final Function<WebDriver,GooglePage> HIN = (d)-> new GoogleHindiPage(d);
}
