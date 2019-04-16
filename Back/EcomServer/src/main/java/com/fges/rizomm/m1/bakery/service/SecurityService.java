package com.fges.rizomm.m1.bakery.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
