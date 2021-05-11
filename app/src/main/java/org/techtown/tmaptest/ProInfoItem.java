package org.techtown.tmaptest;

public class ProInfoItem {
    String proName, proCall, proMail;

    public ProInfoItem(String proName, String proCall, String proMail) {
        this.proName = proName;
        this.proCall = proCall;
        this.proMail = proMail;
    }

    // 교수님 정보 세팅.
    public String getProName() {
        return proName;
    }
    public void setProName(String proName) {
        this.proName = proName;
    }
    public String getProCall() { return proCall;}
    public void setProCall(String proCall) { this.proCall = proCall; }
    public String getProMail() { return proMail; }
    public void setProMail(String proMail) { this.proMail = proMail; }

}
