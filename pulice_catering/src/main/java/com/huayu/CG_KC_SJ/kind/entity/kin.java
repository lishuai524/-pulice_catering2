package com.huayu.CG_KC_SJ.kind.entity;

public class kin {
    private int kid;
    private String name;

    @Override
    public String toString() {
        return "kin{" +
                "kid=" + kid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
