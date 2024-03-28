// Поля:
// Артикул (number)
// Производитель (laptopMaker)
// Серия (series)
// ОЗУ (RAM)
// Объем ЖД (hardDiskCapacity)
// Операционная система (operationSystem)
// Цвет (color)
// Цена (price)

package FinalDZ;

import java.util.Objects;

public class Laptop {
    int number;
    String laptopMaker;
    String series;
    int RAM;
    int hardDiskCapacity;
    String operationSystem;
    String color;
    int price;

    public Laptop(int number, String laptopMaker, String series, int RAM, int hardDiskCapacity, String operationSystem,
            String color, int price) {
        this.number = number;
        this.laptopMaker = laptopMaker;
        this.series = series;
        this.RAM = RAM;
        this.hardDiskCapacity = hardDiskCapacity;
        this.operationSystem = operationSystem;
        this.color = color;
        this.price = price;
    }

    public String getLaptopMaker() {
        return laptopMaker;
    }

    public String getSeries() {
        return series;
    }

    public int getNumber() {
        return number;
    }

    public int getRAM() {
        return RAM;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public void setLaptopMaker(String laptopMaker) {
        this.laptopMaker = laptopMaker;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setHardDiskCapacity(int hardDiskCapacity) {
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Артикул: " + number + ", Производитель: " + laptopMaker + ", Серия: " + series + ", ОЗУ: "
                + RAM + "ГБ, Объем ЖД: " + hardDiskCapacity + "ГБ, Операционная система: " + operationSystem
                + ", Цвет: " + color + ", Цена: " + price + " рублей");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (this == null || getClass() != obj.getClass())
            return false;
        Laptop laptop = (Laptop) obj;
        return (this.number == laptop.number) && (this.laptopMaker == laptop.laptopMaker) && (this.series == laptop.series)
                && (this.RAM == laptop.RAM) && (this.hardDiskCapacity == laptop.hardDiskCapacity) && (this.operationSystem == laptop.operationSystem)
                && (this.color == laptop.color) && (this.price == laptop.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, laptopMaker, series, RAM, hardDiskCapacity, operationSystem, color, price);
    }

}
