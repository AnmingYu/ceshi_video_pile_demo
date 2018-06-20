package com.example.administrator.videopiledemo.entity;

/**
 * Created by Administrator on 2018/5/26.
 */

public class FeesNature {
    private String beginTime;
    private String finishTime;
    private String quantumTime;
    private String money;
    private String plateNumber;
    private String QRCode;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getQuantumTime() {
        return quantumTime;
    }

    public void setQuantumTime(String quantumTime) {
        this.quantumTime = quantumTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public FeesNature() {
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public FeesNature(String beginTime, String finishTime, String quantumTime, String money, String plateNumber,String QRCode) {
        this.beginTime = beginTime;
        this.finishTime = finishTime;
        this.quantumTime = quantumTime;
        this.money = money;
        this.plateNumber = plateNumber;
        this.QRCode=QRCode;
    }
}
