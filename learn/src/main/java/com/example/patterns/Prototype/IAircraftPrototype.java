package com.example.patterns.Prototype;

public interface IAircraftPrototype {
    void fly();

    IAircraftPrototype clone();

    void setEngine(F16Engine f16Engine);
}
