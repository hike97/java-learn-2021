package jvm.jmm.operation;

public class T03_InvokeSpecial {
    public static void main (String[] args) {
        T03_InvokeSpecial t = new T03_InvokeSpecial ();
        t.m ();
        t.n ();
    }

    public final void m () {
    }

    private void n () {
    }
}
