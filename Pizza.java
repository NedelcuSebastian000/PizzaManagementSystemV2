package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Pizza implements  pizzaMethods {
    public static Scanner scanner=new Scanner(System.in);
    private final String name;
    private final String pizzaDough;
    private final String ingredients;
    private final Double price;
    private double additionalStuff;

    public Pizza(String name, String pizzaDough, String ingredients, Double price) {
        this.name = name;
        this.pizzaDough = pizzaDough;
        this.ingredients = ingredients;
        this.price = price;
    }
    public  void fetchSelectionFromUser(String input) {
        Matcher match = Pattern.compile("[0-4]").matcher(input);
        if (match.matches()) {
            return;
        } else {
            System.out.println("The input is wrong!! try again.");
        }
    }


    public void additionalIngredients() {
        Set<String> set = new HashSet<>();
        boolean flag = false;
        while (!flag) {

            try {
                System.out.println("Enter your choice for extra toppings ");
                String choices=scanner.nextLine();
                fetchSelectionFromUser(choices);
                if(choices.equals("4")){
                    System.out.println("Still not a good input");
                }
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


                    }

                        set.add(choices);

            }catch (InputMismatchException e) {
                System.out.println("Please enter an integer next time!");
                break;
            }
        }
    }


    public void print() {
        System.out.println("//////////////////    THE PAYMENT OF THE ORDER:    //////////////////");
        System.out.println("The normal price for the " + getName()+" is ...................... " + getPrice() + "$");
        System.out.println("The additions price.............................................. " + getAdditionalStuff() + "$");
        System.out.println("The final price for your ORDER is................................ " + finalPrice() + "$");
    }

    public double finalPrice() {
        return this.getAdditionalStuff() + this.getPrice();
    }

    public void setAdditionalStuff(double additionalStuff) {
        this.additionalStuff = additionalStuff;
    }

    public double getAdditionalStuff() {
        return additionalStuff;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public Double getPrice() {
        return price;
    }
}