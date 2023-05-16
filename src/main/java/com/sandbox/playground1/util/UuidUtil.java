package com.sandbox.playground1.util;

import java.util.UUID;

public class UuidUtil {

    public static String generateRandomOracleUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
