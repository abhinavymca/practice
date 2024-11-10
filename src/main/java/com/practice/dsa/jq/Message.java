package com.practice.dsa.jq;

public class Message {
    private int msgId;
    private String msg;

    public Message(int msgId, String msg) {
        this.msgId = msgId;
        this.msg = msg;
    }

    public Message() {
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
