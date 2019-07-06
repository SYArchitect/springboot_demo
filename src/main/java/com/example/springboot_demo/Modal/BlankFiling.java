package com.example.springboot_demo.Modal;

import java.sql.Timestamp;

/**
 * @author HFZ
 * @email 1310209619@qq.com
 * @date 2019-07-06 10:48
 */
public class BlankFiling {
    private String BF_id;
    private String BF_Content;
    private String BF_Answer;
    private Timestamp AddTime;
    private int BF_State;

    public String getBF_id() {
        return BF_id;
    }

    public void setBF_id(String BF_id) {
        this.BF_id = BF_id;
    }

    public String getBF_Content() {
        return BF_Content;
    }

    public void setBF_Content(String BF_Content) {
        this.BF_Content = BF_Content;
    }

    public String getBF_Answer() {
        return BF_Answer;
    }

    public void setBF_Answer(String BF_Answer) {
        this.BF_Answer = BF_Answer;
    }

    public Timestamp getAddTime() {
        return AddTime;
    }

    public void setAddTime(Timestamp addTime) {
        AddTime = addTime;
    }

    public int getBF_State() {
        return BF_State;
    }

    public void setBF_State(int BF_State) {
        this.BF_State = BF_State;
    }

    @Override
    public String toString() {
        return "BlankFiling{" +
                "BF_id='" + BF_id + '\'' +
                ", BF_Content='" + BF_Content + '\'' +
                ", BF_Answer='" + BF_Answer + '\'' +
                ", AddTime=" + AddTime +
                ", BF_State=" + BF_State +
                '}';
    }
}
