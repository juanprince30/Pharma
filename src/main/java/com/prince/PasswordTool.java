package com.prince;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordTool {
    // Hash password
    public static String hash(String plain) {
        return BCrypt.hashpw(plain, BCrypt.gensalt(12));
    }

    // Vérifier
    public static boolean verify(String plain, String hash) {
        if (hash == null || !hash.startsWith("$2")) return false;
        return BCrypt.checkpw(plain, hash);
    }
}

