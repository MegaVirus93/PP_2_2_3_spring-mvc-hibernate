package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars(int n) {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("Acura", "TSX", "Japan");
        Car car2 = new Car("Alfa Romeo", "Stelvio", "Italian");
        Car car3 = new Car("Alpine", "GTA", "French");
        Car car4 = new Car("Aston Martin", "Rapide", "Greet Britain");
        Car car5 = new Car("GAC Aion", "S", "China");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        if (n < 5) return carList.stream().limit(n).toList();
        return carList;
    }
}
