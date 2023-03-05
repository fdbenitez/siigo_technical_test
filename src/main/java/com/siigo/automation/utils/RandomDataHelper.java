package com.siigo.automation.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomDataHelper {
    static SecureRandom randomNumber = new SecureRandom();

    public static int increaseRandom() {
        return (randomNumber.nextInt(3) + 1);
    }


}

