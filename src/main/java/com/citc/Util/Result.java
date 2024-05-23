package com.citc.Util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Result {
    Integer code;
    String message;
    HashMap<String,Object> data;

    public  Result code(Integer code) {
        this.code = code;
        return this;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public Result data(HashMap<String,Object> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
