// Задание

// -Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
// методы. Реализовать в java.
// -Создать множество ноутбуков.
// -Написать метод, который будет запрашивать у пользователя критерий (или критерии)
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
// хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// -Далее нужно запросить минимальные значения для указанных критериев - сохранить
// параметры фильтрации можно также в Map.
// -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
// условиям.

package FinalDZ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopMain {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(123456, "Apple", "MacBook Air 13", 8, 256, "MacOs", "grey", 94500);
        Laptop laptop2 = new Laptop(123457, "Dell", "Vostro 3520", 8, 256, "Ubuntu", "black", 45990);
        Laptop laptop3 = new Laptop(123458, "Asus", "ROG Strix SCAR 18", 32, 2000, "Windows", "black", 399999);
        Laptop laptop4 = new Laptop(1234576, "Lenovo", "Idea Pad Gasming 3", 16, 512, "Windows", "green", 79999);
        Laptop laptop5 = new Laptop(1345672, "Acer", "Aspire 5 A515-57G", 16, 512, "не установлена", "silver", 69999);
        Laptop laptop6 = new Laptop(3245676, "Lenovo", "V14 G2 ITL 82KA000KNUS", 8, 256, "Windows", "black", 49999);
        Laptop laptop7 = new Laptop(123458, "Asus", "ROG Strix SCAR 18", 32, 2000, "Windows", "black", 399999);
        HashSet<Laptop> laptops = new HashSet<>(
                Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6, laptop7));
        // for (Laptop laptop : laptops) {
        //     System.out.println(laptop);
        // }
        filterLaptops(laptops);

    }

    public static void filterLaptops(Set<Laptop> laptops) {
        Map<String, String> criterion = new HashMap<>();
        criterion.put("1", "ОЗУ");
        criterion.put("2", "Объем ЖД");
        criterion.put("3", "Цвет");
        criterion.put("4", "Цена");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите цифру, которая соответствует необходимому критерию: ");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Цвет");
            System.out.println("4 - Цена");
            String userCriterion = scanner.nextLine();

            if (criterion.containsKey(userCriterion)) {
                String selectedCriterion = criterion.get(userCriterion);
                System.out.println("Введите минимальное значение для " + selectedCriterion + ": ");
                String minValue = scanner.nextLine();

                Set<Laptop> filteredLaptops = new HashSet<>();
                switch (selectedCriterion) {
                    case "ОЗУ":
                        int minRAM = Integer.parseInt(minValue);
                        for (Laptop laptop : laptops) {
                            if (laptop.getRAM() >= minRAM) {
                                filteredLaptops.add(laptop);
                            }
                        }
                        break;
                    case "Объем ЖД":
                        int minHardDiskCapacity = Integer.parseInt(minValue);
                        for (Laptop laptop : laptops) {
                            if (laptop.getHardDiskCapacity() >= minHardDiskCapacity) {
                                filteredLaptops.add(laptop);
                            }
                        }
                        break;

                    case "Цена":
                        int minPrice = Integer.parseInt(minValue);
                        for (Laptop laptop : laptops) {
                            if (laptop.getPrice() >= minPrice) {
                                filteredLaptops.add(laptop);
                            }
                        }
                        break;

                    case "Цвет":
                        for (Laptop laptop : laptops) {
                            if (laptop.getColor().equalsIgnoreCase(minValue)) {
                                filteredLaptops.add(laptop);
                            }
                        }
                        break;

                    default:
                        System.out.println("Введите корректно");
                        return;
                }

                if (filteredLaptops.isEmpty()) {
                    System.out.println("Ноутбуки по Вашему фильтру не найдены");
                } else {
                    System.out.println("Рады сообщить, что найдены ноутбуки согласно Вашим критериям. Ниже список.");
                    System.out.println();
                    for (Laptop laptop : filteredLaptops) {
                        System.out.println(laptop);
                    }
                }
            } else {
                System.out.println("Введенный критерий не корректен. Попробуйте иначе.");
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
