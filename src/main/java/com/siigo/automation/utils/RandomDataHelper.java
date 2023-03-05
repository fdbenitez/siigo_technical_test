package com.siigo.automation.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomDataHelper {

    static Faker faker = new Faker(new Locale("es"));

    static SecureRandom randomNumber = new SecureRandom();

    public static int increaseRandom() {
        return (randomNumber.nextInt(3) + 1);
    }

    public static int pageRandom() {
        return (randomNumber.nextInt(1)+1);
    }

    public static int singleUserRandom() {
        return (randomNumber.nextInt(11)+1);
    }

    public static int singleUserIdRandom() {
        return (randomNumber.nextInt(50)+50);
    }

    public static String getNameRandom() {
        return faker.name().firstName();
    }
    public static String getJobRandom() {
        return faker.company().profession();
    }


}

