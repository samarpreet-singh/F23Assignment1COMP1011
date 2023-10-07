/**
 * Full Name: Samarpreet Singh
 * Student #: 200510621
 * CRN: 11346 (Monday, 9am class)
 * Assignment 1 - COMP 1011
 */
package com.example.f23assignment1comp1011;

// This is our model class where all the validation is happening
public class VideoGameSales {

    // declaring the instance variables with appropriate data types
    private int id;
    private String gameName, platform, genre, publisher;
    private int yearOfRelease;
    private double naSales, euSales, jpSales, otherSales, globalSales;

    /**
     * Constructor with setters to validate data each time an instance of the class is created
     *
     * @param id
     * @param gameName
     * @param platform
     * @param yearOfRelease
     * @param genre
     * @param publisher
     * @param naSales
     * @param euSales
     * @param jpSales
     * @param otherSales
     * @param globalSales
     */
    public VideoGameSales(int id, String gameName, String platform, int yearOfRelease, String genre, String publisher,
                          double naSales, double euSales, double jpSales, double otherSales, double globalSales) {
        setId(id);
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

    public int getId() {
        return id;
    }

    /**
     * Setter for the Id validation. Here we dont need to check for nulls because int values can never be null by default in java, instead they are 0.
     *
     * @param id the id to be validated
     */
    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID cannot be negative.");
        }
    }

    public String getGameName() {
        return gameName;
    }

    /**
     * Game name setter validation. Null has to be checked here,
     * and that the length of the title is under 100 characters, according to the constraint in the table.
     *
     * @param gameName name of the game to be validated
     */
    public void setGameName(String gameName) {
        if (gameName != null && gameName.length() <= 100) {
            this.gameName = gameName;
        } else {
            throw new IllegalArgumentException("Game name must not be null and should have a length <= 100.");
        }
    }

    public String getPlatform() {
        return platform;
    }

    /**
     * Platform setter validation. Null has to be checked here,
     * and that the length is under 50 characters, according to the constraint in the table.
     *
     * @param platform platform name to be validated
     */
    public void setPlatform(String platform) {
        if (platform != null && platform.length() <= 50) {
            this.platform = platform;
        } else {
            throw new IllegalArgumentException("Platform must not be null and should have a length <= 50.");
        }
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    /**
     * Release year setter validation. No need to check nulls as was the case in id, but year cannot have any number of digits EXCEPT 4 digits.
     * This is a constraint in the table too.
     *
     * @param yearOfRelease year of release to be validated
     */
    public void setYearOfRelease(int yearOfRelease) {
        if (yearOfRelease >= 1000 && yearOfRelease <= 9999) {
            this.yearOfRelease = yearOfRelease;
        } else {
            throw new IllegalArgumentException("Year of release must be a 4-digit number.");
        }
    }

    public String getGenre() {
        return genre;
    }

    /**
     * Genre setter validation. Null has to be checked here,
     * and that the length is under 50 characters, according to the constraint in the table.
     *
     * @param genre genre of the game to be validated
     */
    public void setGenre(String genre) {
        if (genre != null && genre.length() <= 50) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("Genre must not be null and should have a length <= 50.");
        }
    }

    public String getPublisher() {
        return publisher;
    }

    /**
     * Publisher setter validation. Null has to be checked here,
     * and that the length is under 50 characters, according to the constraint in the table.
     *
     * @param publisher publisher of the game to be validated
     */
    public void setPublisher(String publisher) {
        if (publisher != null && publisher.length() <= 50) {
            this.publisher = publisher;
        } else {
            throw new IllegalArgumentException("Publisher must not be null and should have a length <= 50.");
        }
    }

    public double getNaSales() {
        return naSales;
    }

    /**
     * NA Sales setter validation. The sales validations use two methods - isValidDouble to check if the passed argument is a valid double, and
     * roundToTwoDecimalPlaces to round the given double to Two Decimal places if it doesn't have a decimal by default.
     *
     * @param naSales North American sales value to be validated
     */
    public void setNaSales(double naSales) {
        if (naSales >= 0 && isValidDouble(naSales)) {
            this.naSales = roundToTwoDecimalPlaces(naSales);
        } else {
            throw new IllegalArgumentException("North American sales must not be negative and have at most 2 decimal places.");
        }
    }

    public double getEuSales() {
        return euSales;
    }

    /**
     * EU Sales setter validation. The sales validations use two methods - isValidDouble to check if the passed argument is a valid double, and
     * roundToTwoDecimalPlaces to round the given double to Two Decimal places if it doesn't have a decimal by default.
     *
     * @param euSales European sales value to be validated
     */
    public void setEuSales(double euSales) {
        if (euSales >= 0 && isValidDouble(euSales)) {
            this.euSales = roundToTwoDecimalPlaces(euSales);
        } else {
            throw new IllegalArgumentException("North American sales must not be negative and have at most 2 decimal places.");
        }
    }

    public double getJpSales() {
        return jpSales;
    }

    /**
     * JP Sales setter validation. The sales validations use two methods - isValidDouble to check if the passed argument is a valid double, and
     * roundToTwoDecimalPlaces to round the given double to Two Decimal places if it doesn't have a decimal by default.
     *
     * @param jpSales Japanese sales value to be validated
     */
    public void setJpSales(double jpSales) {
        if (jpSales >= 0 && isValidDouble(jpSales)) {
            this.jpSales = roundToTwoDecimalPlaces(jpSales);
        } else {
            throw new IllegalArgumentException("North American sales must not be negative and have at most 2 decimal places.");
        }
    }

    public double getOtherSales() {
        return otherSales;
    }

    /**
     * Other sales setter validation. The sales validations use two methods - isValidDouble to check if the passed argument is a valid double, and
     * roundToTwoDecimalPlaces to round the given double to Two Decimal places if it doesn't have a decimal by default.
     *
     * @param otherSales Other misc. sales value to be validated
     */
    public void setOtherSales(double otherSales) {
        if (otherSales >= 0 && isValidDouble(otherSales)) {
            this.otherSales = roundToTwoDecimalPlaces(otherSales);
        } else {
            throw new IllegalArgumentException("North American sales must not be negative and have at most 2 decimal places.");
        }
    }

    public double getGlobalSales() {
        return globalSales;
    }

    /**
     * Global Sales setter validation. The sales validations use two methods - isValidDouble to check if the passed argument is a valid double, and
     * roundToTwoDecimalPlaces to round the given double to Two Decimal places if it doesn't have a decimal by default.
     *
     * @param globalSales Global sales value to be validated
     */
    public void setGlobalSales(double globalSales) {
        if (globalSales >= 0 && isValidDouble(globalSales)) {
            this.globalSales = roundToTwoDecimalPlaces(globalSales);
        } else {
            throw new IllegalArgumentException("North American sales must not be negative and have at most 2 decimal places.");
        }
    }

    /**
     * Converts the given double to a string, then find the index of the decimal. If dotIndex is -1, it means there is no decimal and the number is
     * a double by default. For inserting a decimal, roundToTwoDecimalPlaces is used.
     *
     * If the length of the double - dotIndex is 3 or less, that means there are two decimal values and that is an acceptable double value.
     * Either of these conditions can be satisfied and the double will be acceptable.
     *
     * @param value the double value to be validated
     * @return true if either condition is true, otherwise false if none are true
     */
    private boolean isValidDouble(double value) {
        String stringValue = Double.toString(value);
        int dotIndex = stringValue.indexOf('.');
        return (dotIndex == -1 || stringValue.length() - dotIndex <= 3);
    }

    /**
     * Rounds the given value to 2 decimal places. Multiplies the value by 100 before passing to Math.round, to round it to two decimal places.
     * Then divides it by 100 again to shift back the decimal point to original position.
     *
     * @param value value to be rounded
     * @return rounded off double to two decimal plcaes
     */
    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
