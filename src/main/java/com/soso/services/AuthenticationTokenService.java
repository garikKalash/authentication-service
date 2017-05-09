package com.soso.services;

import com.soso.utility.AuthenticationToken;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Garik Kalashyan on 3/4/2017.
 */
public class AuthenticationTokenService {
    private static Set<AuthenticationToken> registeredTokens = new HashSet<>();
    public AuthenticationTokenService(){}

    public static AuthenticationToken getGeneratedAuthenticationToken(@NotNull Integer serviceId, Integer itemId,String phonenumber){
        AuthenticationToken authenticationToken =new AuthenticationToken(serviceId ,itemId,BaseSecurity.getMd5Version(BaseSecurity.getMd5Version(BaseSecurity.getMd5Version(LocalDateTime.now().toString())+BaseSecurity.getMd5Version(phonenumber + itemId.toString()) + serviceId.toString())));
        putToken(authenticationToken);
        return  authenticationToken;

    }

    public static void putToken(AuthenticationToken authenticationToken){
        registeredTokens.add(authenticationToken);
    }

    public static boolean removeToken(AuthenticationToken authenticationToken){
        return registeredTokens.remove(authenticationToken);
    }

    public static boolean existsToken(AuthenticationToken authenticationToken){
        return registeredTokens.contains(authenticationToken);
    }


}
