package jvm.jmm.operation;

import java.util.ArrayList;
import java.util.List;

public class T04_InvokeInterface {
    public static void main (String[] args) {
        List<String> list = new ArrayList<String> ();
        list.add ("hello");

        ArrayList<String> list2 = new ArrayList<> ();
        list2.add ("hello2");
    }
}
