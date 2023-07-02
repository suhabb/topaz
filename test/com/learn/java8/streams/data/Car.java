package com.learn.java8.streams.data;

import java.util.Objects;

public class Car {
    private final String concern;
    private final String model;
    private final int productionYear;
    public Car(String concern, String model, int productionYear) {
        this.concern = concern;
        this.model = model;
        this.productionYear = productionYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return productionYear == car.productionYear && Objects.equals(concern, car.concern) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concern, model, productionYear);
    }
}