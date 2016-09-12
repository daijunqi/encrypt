package com.bean;

/**
 * Created by dai on 16-9-12.
 */
public class ChildOne extends Father{

    private String childOne;

    /**
     * 需要忽略的属性
     */
    private String needIgnore;

    public String getChildOne() {
        return childOne;
    }

    public void setChildOne(String childOne) {
        this.childOne = childOne;
    }

    public String getNeedIgnore() {
        return needIgnore;
    }

    public void setNeedIgnore(String needIgnore) {
        this.needIgnore = needIgnore;
    }
}
