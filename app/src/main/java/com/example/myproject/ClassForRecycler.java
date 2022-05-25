package com.example.myproject;

public class ClassForRecycler {
    String size;
    String desc_1;
    String desc_2;
    String desc_3;

    public ClassForRecycler(String size, String desc_1, String desc_2, String desc_3) {
        this.size = size;
        this.desc_1 = desc_1;
        this.desc_2 = desc_2;
        this.desc_3 = desc_3;
    }

    public String getSize() {
        return size;
    }

    public String getDesc_1() {
        return desc_1;
    }

    public String getDesc_2() {
        return desc_2;
    }

    public String getDesc_3() {
        return desc_3;
    }
}
