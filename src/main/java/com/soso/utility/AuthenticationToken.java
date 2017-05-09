package com.soso.utility;



import com.soso.services.BaseSecurity;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Garik.Kalashyan on 1/28/2017.
 */
public class AuthenticationToken {

    private String key;
    private Integer serviceId;
    private Integer itemId;

    public AuthenticationToken(@NotNull Integer serviceId, Integer itemId, String key) {
        this.serviceId = serviceId;
        this.key = key;
        this.itemId = itemId;
    }

    public AuthenticationToken(){}

    public AuthenticationToken(String key, Integer serviceId, Integer itemId) {
        this.key = key;
        this.serviceId = serviceId;
        this.itemId = itemId;
    }

    public String getKey(){
        return this.key;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public Integer getItemId(){return  itemId;}

    public void setKey(String key) {

        this.key = key;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthenticationToken)) return false;

        AuthenticationToken that = (AuthenticationToken) o;

        if (!getKey().equals(that.getKey())) return false;
        if (!getServiceId().equals(that.getServiceId())) return false;
        return getItemId().equals(that.getItemId());
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + getServiceId().hashCode();
        return result;
    }
}
