package cn.edu.cqupt.nmid.passloveserver.v1.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Dynamics2 {
    @JSONField(ordinal = 0)
    Dynamics dynamics;
    @JSONField(ordinal = 1)
    int read;

    @Override
    public String toString() {
        return "Dynamics2{" +
                "dynamics=" + dynamics +
                ", read=" + read +
                '}';
    }

    public Dynamics getDynamics() {
        return dynamics;
    }

    public void setDynamics(Dynamics dynamics) {
        this.dynamics = dynamics;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public Dynamics2(Dynamics dynamics, int read) {
        this.dynamics = dynamics;
        this.read = read;
    }
}
