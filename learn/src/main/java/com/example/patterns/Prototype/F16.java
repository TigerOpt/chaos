package com.example.patterns.Prototype;

public class F16 implements IAircraftPrototype {
    // default engine
    F16Engine f16Engine = new F16Engine();

    @Override
    public void fly() {
        System.out.println("F-16 flying...");
    }

    public void setEngine(F16Engine f16Engine) {
        this.f16Engine = f16Engine;
    }

    @Override
    public IAircraftPrototype clone() {
        return new F16();
    }

}
