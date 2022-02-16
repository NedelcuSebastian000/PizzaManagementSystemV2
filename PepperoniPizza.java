package com.company;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        super("Pepperoni Pizza", "white dough", "tomato sauce, pepperoni,mozzarella cheese" +
                " black pepper,olive", 6.5);
    }

    @Override
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
                            double extraSauce = 1.2;
                            setAdditionalStuff(getAdditionalStuff() + extraSauce);
                            System.out.println("Extra sauce added on your pizza \n");
                            break;
                        } else {
                            System.out.println("You already added extra sauce, please consider to add something else");
                            break;
                        }
                    case "2":
                        if (!set.contains(choices)) {
                            double extraCheese = 2.3;
                            setAdditionalStuff(getAdditionalStuff() + extraCheese);
                            System.out.println("Extra cheese added on your pizza \n");
                            break;
                        } else {
                            System.out.println("You already added extra cheese, please consider to add something else");
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
                    case "4":
                        if (!set.contains(choices)) {
                            double extraPepperoni = 0.7;
                            setAdditionalStuff(getAdditionalStuff() + extraPepperoni);
                            System.out.println("Extra pepperonia added to your pizza \n");
                            break;

                        } else {
                            System.out.println("Your pizza has already extra pepperoni, consider something else");
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
    public void fetchSelectionFromUser(String x) {
        super.fetchSelectionFromUser(x);
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
