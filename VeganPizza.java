package com.company;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class VeganPizza extends  Pizza{
    public VeganPizza() {
        super("Vegan Pizza", "Focaccia dough", "tomatoes, broccoli, red onion, cashew cream , sun dried tomatoes , corn", 7.0);
    }

    public void additionalIngredients() {
        Set<String> set = new HashSet<>();
        boolean flag = false;
        while (!flag) {

            try {
                System.out.println("Enter your choice for extra toppings ");
                String choices = scanner.nextLine();
                fetchSelectionFromUser(choices);
                switch (choices) {

                    case "0":
                        System.out.println("Done");
                        flag = true;
                        break;

                    case "1":
                        if (!set.contains(choices)) {
                            double extraCorn = 1.2;
                            setAdditionalStuff(getAdditionalStuff() + extraCorn);
                            System.out.println("Extra corn on your pizza \n");
                            break;
                        } else {
                            System.out.println("You already added  extra corn, please consider to add something else");
                            break;
                        }
                    case "2":
                        if (!set.contains(choices)) {
                            double cashewSauce = 2.3;
                            setAdditionalStuff(getAdditionalStuff() + cashewSauce);
                            System.out.println("Extra cashew sauce added on your pizza \n");
                            break;
                        } else {
                            System.out.println("You already added extra cashew, please consider to add something else");
                            break;
                        }
                    case "3":
                        if (!set.contains(choices)) {
                            double largeDough = 0.7;
                            setAdditionalStuff(getAdditionalStuff() + largeDough);
                            System.out.println("Your pizza has a large Dough \n");
                            break;

                        } else {
                            System.out.println("Your pizza has already a large dough, consider something else");
                            break;

                        }
                }

                set.add(choices);

            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer next time!");
                break;
            }
        }
    }

    @Override
    public void fetchSelectionFromUser(String input) {
        super.fetchSelectionFromUser(input);
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    public double finalPrice() {
        return super.finalPrice();
    }
}
