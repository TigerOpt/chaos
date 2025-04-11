package com.example.patterns.singleton;

public class AirforceOne {
    /**
     * �ڶ��̵߳�ʱ�����ַ�ʽ���ܻᴴ���������
     * eg�������߳�A��ȡ�ö������ж�ΪnullΪ�棬����֮ǰ�������Ľ������л���
     * ��ʱ���߳�BҲ��ȡ�ö��󣬷���ʵ��Ϊ�գ������˴�������֮���߳�A�л����󣬻������������.
     * ����ô�����ܽ��������˵�������أ�
     * 1����getInstance()�������synchronized��������ʾ  ���� ���ַ�ʽ�и����⣬ͬ�������ܴ�
     * synchronized public static AirforceOne getInstance()
     * 2����ʵ�����о�̬��ʼ����������ʾ ���� ���ַ�ʽ����ʱδʹ��ʱҲ���ʼ��������ö��󴴽������ϴ󣬿��ܻή������
     * private static AirforceOne onlyInstance = new AirforceOne();
     * 3��˫�ؼ����������AirforceOneWithDoubleCheckedLocking.java
     */
    private static AirforceOne onlyInstance;

    private AirforceOne() {
    }

    public void fly() {
        System.out.println("Airforce one is flying...");
    }

    // Create a static method for object creation
    public static AirforceOne getInstance() {

        // Only instantiate the object when needed.
        if (onlyInstance == null) {
            onlyInstance = new AirforceOne();
        }

        return onlyInstance;
    }
}
