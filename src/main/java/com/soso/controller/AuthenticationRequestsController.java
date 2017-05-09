package com.soso.controller;

import com.soso.services.AuthenticationTokenService;
import com.soso.services.JsonConverter;
import com.soso.services.JsonMapBuilder;
import com.soso.utility.AuthenticationToken;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Garik Kalashyan on 3/9/2017.
 */

@CrossOrigin("*")
@Controller
@RequestMapping("authenticateService")
public class AuthenticationRequestsController {

    @RequestMapping(value = "/isValidToken/{serviceId}/{itemId}/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void isValidToken(@PathVariable("serviceId") Integer serviceId,@PathVariable("itemId")Integer itemId ,@PathVariable("token")String token,  HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonConverter.toJson(new JsonMapBuilder()
                 .add("isValidToken", AuthenticationTokenService.existsToken(new AuthenticationToken(serviceId,itemId,token)))
                 .build()));
    }

    @RequestMapping(value = "/getToken/{serviceId}/{itemId}/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@PathVariable("serviceId") Integer serviceId,@PathVariable("itemId") Integer itemId,@PathVariable("key") String key, HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonConverter.toJson(new JsonMapBuilder()
                .add("createdToken", AuthenticationTokenService.getGeneratedAuthenticationToken(serviceId,itemId, key))
                .build()));
    }

    @RequestMapping(value = "/deleteToken/{serviceId}/{itemId}/{token}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void remove(@PathVariable("serviceId") Integer serviceId,@PathVariable("itemId") Integer itemId,@PathVariable("token") String token,HttpServletResponse response){
        AuthenticationToken authenticationToken = new AuthenticationToken(serviceId,itemId,token);
        AuthenticationTokenService.removeToken(authenticationToken);


    }




}
