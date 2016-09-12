package com.run;

import com.bean.ChildOne;
import com.bean.ChildTwo;

/**
 * Created by dai on 16-9-12.
 */
public class Run {

    public static void main(String[] args) throws Exception{

        ChildOne one = new ChildOne();
        one.setFather("father1");
        one.setChildOne("child1");
        one.setNeedIgnore("ignore");

        System.out.println(EncryptUtil.encrypt(one));

        ChildTwo two = new ChildTwo();
        two.setFather("father2");
        two.setChildTwo("child2");

        System.out.println(EncryptUtil.encrypt(two));
    }
}
