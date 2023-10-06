/**
 * Full Name: Samarpreet Singh
 * Student #: 200510621
 * CRN: 11346 (Monday, 9am class)
 * Assignment 1 - COMP 1011
 */
package com.example.f23assignment1comp1011;

public class VideoGameSales {
    private String gameName, platform, genre, publisher;
    private int yearOfRelease;
    private double naSales, euSales, jpSales, otherSales, globalSales;

    public VideoGameSales(String gameName, String platform, int yearOfRelease, String genre, String publisher,
                          double naSales, double euSales, double jpSales, double otherSales, double globalSales) {
        setGameName(gameName);
        setPlatform(platform);
        setYearOfRelease(yearOfRelease);
        setGenre(genre);
        setPublisher(publisher);
        setNaSales(naSales);
        setEuSales(euSales);
        setJpSales(jpSales);
        setOtherSales(otherSales);
        setGlobalSales(globalSales);
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getNaSales() {
        return naSales;
    }

    public void setNaSales(double naSales) {
        this.naSales = naSales;
    }

    public double getEuSales() {
        return euSales;
    }

    public void setEuSales(double euSales) {
        this.euSales = euSales;
    }

    public double getJpSales() {
        return jpSales;
    }

    public void setJpSales(double jpSales) {
        this.jpSales = jpSales;
    }

    public double getOtherSales() {
        return otherSales;
    }

    public void setOtherSales(double otherSales) {
        this.otherSales = otherSales;
    }

    public double getGlobalSales() {
        return globalSales;
    }

    public void setGlobalSales(double globalSales) {
        this.globalSales = globalSales;
    }
}
