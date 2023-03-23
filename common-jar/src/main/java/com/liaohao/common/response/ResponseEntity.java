package com.liaohao.common.response;

import java.io.Serializable;

/**
 * 统一的Http返回对象
 */
public class ResponseEntity<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public ResponseEntity() {
    }

    public ResponseEntity(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseEntity success() {
        return new ResponseEntity(0000, null, null);
    }

    public ResponseEntity<T> success(T data) {
        return new ResponseEntity(0000, null, data);
    }

    public ResponseEntity error() {
        return new ResponseEntity(9999, null, null);
    }

    public ResponseEntity error(String msg) {
        return new ResponseEntity(9999, msg, null);
    }
    public ResponseEntity error(T data) {
        return new ResponseEntity(9999, null, data);
    }

    public ResponseEntity error(int code, String msg, T data) {
        return new ResponseEntity(9999, msg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
