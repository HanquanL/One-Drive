package com.udacity.jwdnd.course1.cloudstorage.config;

public class SecurityConstants {
    public static final String SECRET = "onesecretkey";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/signup"; // this is the url that the user will use to sign up
}
