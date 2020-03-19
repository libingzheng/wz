package com.example.myapplication.entity;

public class LoginBean {
    /**
     * result : {"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","nickName":"Vs_8873O","phone":"13403931363","sessionId":"158270693010127774","sex":1,"userId":27774}
     * message : 登录成功
     * status : 0000
     */

    private String message;
    private String status;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
