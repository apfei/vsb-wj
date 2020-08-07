/**
 * 
 */
package com.example.anpf.testserver.result;

/**
 * @author anpf
 * @date: 2020/08/07
 */
public class Result {
    //响应码
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
