package com.example.administrator.videopiledemo.entity;

/**
 * Created by Administrator on 2018/6/4.
 */

public class FormsParameter {
    private String ordinal;//序号
    private String  time;//时间
    private String event;//事件源
    private String genre;//物体类型
    private String state;//状态
    private String plateNumbers;//车牌号
    private String perch;//状态
    private String map;//图片

    public FormsParameter(String ordinal, String time, String event, String genre, String state, String plateNumbers, String perch, String map) {
        this.ordinal = ordinal;
        this.time = time;
        this.event = event;
        this.genre = genre;
        this.state = state;
        this.plateNumbers = plateNumbers;
        this.perch = perch;
        this.map = map;
    }

    public FormsParameter() {
    }

    public String getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPlateNumbers() {
        return plateNumbers;
    }

    public void setPlateNumbers(String plateNumbers) {
        this.plateNumbers = plateNumbers;
    }

    public String getPerch() {
        return perch;
    }

    public void setPerch(String perch) {
        this.perch = perch;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
