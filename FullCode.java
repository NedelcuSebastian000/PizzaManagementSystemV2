package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static HireEmployee hireEmployee = new HireEmployee();
    private static LinkedList<Songs> list = new LinkedList<>();

    public static void main(String[] args) {
        Songs song2 = new Songs("Not Afraid", 4.20);
        Songs song3 = new Songs("Numb", 3.06);
        Songs song4 = new Songs("In The End", 3.39);
        Songs song5 = new Songs("Written in the stars", 3.36);
        Songs song6 = new Songs("Smells Like Teen Spirit", 3.26);
        Songs song7 = new Songs("Everybody", 4.50);
        list.add(song2);
        list.add(song3);
        list.add(song4);
        list.add(song5);
        list.add(song6);
        list.add(song7);
        print();
        boolean flag = false;
        while (!flag) {
            String choices = scanner.nextLine();
            fetchSelectionFromUser(choices);
            switch (choices) {
                case "1":
                    orderAPizza();
                    break;
                case "2":
                    addEmployee();
                    break;
                case "3":
                    fireEmployee();
                    break;
                case "4":
                    findEmployeeFromTheList();
                    break;
                case "5":
                    replaceAnEmployee();
                    break;
                case "6":
                    play(list);
                case "/help":
                    print();
                    continue;
                case "/employees":
                    hireEmployee.printEmployees();
                    continue;
                case "/exit":
                    flag = true;
                    break;

            }
        }

    }


    private static final PepperoniPizza pepperoniPizza = new PepperoniPizza();
    private static final SausagePizza sausagePizza = new SausagePizza();
    private static final KebabPizza kebabPizza = new KebabPizza();
    private static final VeganPizza veganPizza = new VeganPizza();
    private static final Quattroformaggi quattroformaggi = new Quattroformaggi();

    private static void orderAPizza() {
        boolean flag = true;
        while (flag) {

            typesOfPizzas();
            String nonVeganPizzas = scanner.nextLine();
            fetchSelectionFromUser(nonVeganPizzas);
            switch (nonVeganPizzas) {
                case "0":
                    additionsPrintPepperoni();
                    pepperoniPizza.additionalIngredients();
                    pepperoniPizza.print();
                    flag = false;
                    break;

                case "1":
                    additionsPrintSausage();
                    sausagePizza.additionalIngredients();
                    sausagePizza.print();
                    flag = false;
                    break;

                case "2":
                    additionsPrintPepperoni();
                    kebabPizza.additionalIngredients();
                    kebabPizza.print();
                    flag = false;
                    break;
                case "3":
                    additionsPrintVegan();
                    veganPizza.additionalIngredients();
                    veganPizza.print();
                    flag = false;
                    break;
                case "4":
                    additionsPrintQuatro();
                    quattroformaggi.additionalIngredients();
                    quattroformaggi.print();
                    flag = false;
                    break;
            }

        }

    }

    private static void addEmployee() {
        System.out.println("Enter the details of the new employee. ");
        System.out.println("Job:");
        String job = scanner.nextLine();
        while (!pozitionValidation(job)) {
            job = scanner.nextLine();
        }
        System.out.println("Name:");
        String name = scanner.nextLine();
        while (!nameValidation(name)) {
            name = scanner.nextLine();
        }
        System.out.println("Phone number:");
        String phoneNr = scanner.nextLine();
        while (!phoneNrValidation(phoneNr)) {
            phoneNr = scanner.nextLine();
        }
        System.out.println("Email: ");
        String email = scanner.nextLine();
        while (!emailValidation(email)) {
            email = scanner.nextLine();
        }
        System.out.println("CNP:");
        String CNP = scanner.nextLine();
        while (!cnpValidation(CNP)) {
            CNP = scanner.nextLine();
        }
        Employee employee = Employee.createEmployee(job, name, phoneNr, email, CNP);
        if (hireEmployee.addNewEmployee(employee)) {
            System.out.println("New Employee added:" + "Job= " + job + "," + " name= " + name + "," + "phone number= " + phoneNr + "," + " email= " + email + "," + " CNP= " + CNP);
        } else
            System.out.println("name= " + name + "already on file");
    }


    private static void fireEmployee() {
        System.out.println("Enter an existing CNP from the list of employees to find your employee:");
        String CNP = scanner.nextLine();
        while (!cnpValidation(CNP)) {
            CNP = scanner.nextLine();
        }
        Employee existingEmployee = hireEmployee.ifEmployeeExists(CNP);
        if (existingEmployee == null) {
            System.out.println("Contact not found");
            return;
        } else if (hireEmployee.removeEmployee(existingEmployee)) {
            System.out.println("You removed the employee with success");
        } else {
            System.out.println("Error");
        }
    }

    private static void findEmployeeFromTheList() {
        System.out.println("Enter an existing CNP from the list of employees to find your employee:");
        String CNP = scanner.nextLine();
        while (!cnpValidation(CNP)) {
            CNP = scanner.nextLine();
        }
        Employee existingEmployee = hireEmployee.ifEmployeeExists(CNP);
        if (existingEmployee == null) {
            System.out.println("Employee not found/ Wrong CNP");
            return;
        }
        System.out.println("Job: " + existingEmployee.getRole()
                + " Name: " + existingEmployee.getName()
                + " Phone number: " + existingEmployee.getPhoneNr()
                + " Email:" + existingEmployee.getEmail()
                + " CNP: " + existingEmployee.getCNP());
    }

    private static void replaceAnEmployee() {
        System.out.println("Enter an existing CNP from the list of employees to find your employee that you wanna replace:");
        String CNP = scanner.nextLine();
        while (!cnpValidation(CNP)) {
            CNP = scanner.nextLine();
        }
        Employee existingEmployee = hireEmployee.ifEmployeeExists(CNP);
        if (existingEmployee == null) {
            System.out.println("Employee not found/ Wrong CNP");
            return;
        } else {
            System.out.println("Employee found");
        }
        System.out.println("Enter the details of the new employee. ");
        System.out.println("Employee Job:");
        String newJob = scanner.nextLine();
        while (!pozitionValidation(newJob)) {
            newJob = scanner.nextLine();
        }
        System.out.println("Name:");
        String newName = scanner.nextLine();
        while (!nameValidation(newName)) {
            newName = scanner.nextLine();
        }
        System.out.println("Phone number:");
        String newPhoneNr = scanner.nextLine();
        while (!phoneNrValidation(newPhoneNr)) {
            newPhoneNr = scanner.nextLine();
        }
        System.out.println("Email ");
        String newEmail = scanner.nextLine();
        while (!emailValidation(newEmail)) {
            newEmail = scanner.nextLine();
        }
        System.out.println("CNP:");
        String newCNP = scanner.nextLine();
        while (!cnpValidation(newCNP)) {
            newCNP = scanner.nextLine();
        }
        Employee newEmployee = Employee.createEmployee(newJob, newName, newPhoneNr, newEmail, newCNP);
        if (hireEmployee.replaceEmployee(existingEmployee, newEmployee)) {
            System.out.println("Success replacing employee");
        } else {
            System.out.println("Error");
        }

    }

    public static void fetchSelectionFromUser(String input) {
        Matcher match = Pattern.compile("[0-6]").matcher(input);
        boolean knownCommands = (input.equals("/exit") || input.equals("/employees") || input.equals("/help") || input.equals(""));
        if (match.matches() || knownCommands) {
            return;
        } else {
            System.out.println("The input is wrong!! try again.");
        }
    }


    public static boolean pozitionValidation(String input) {

        Matcher match = Pattern.compile("[A-Za-z].+").matcher(input);
        if (match.matches()) {
            return true;
        } else {
            System.out.println("The input is wrong! Try again\n Example of input: Senior Java Developer or Junior java developer");
            return false;
        }
    }

    public static boolean phoneNrValidation(String input) {

        Matcher match = Pattern.compile("(\\d{3})[ -]?(\\d{3})[ -]?(\\d{4})").matcher(input);
        if (match.matches()) {
            return true;
        } else {
            System.out.println("The input is wrong! Try again\n Example of input: 0786269080 THE NUMBER MUST HAVE 10 DIGITS");
            return false;
        }
    }

    public static boolean emailValidation(String input) {

        Matcher match = Pattern.compile("^(.+)@(.+)$").matcher(input);
        if (match.matches()) {
            return true;
        } else {
            System.out.println("The input is wrong! Try again \n Example of valid input : nedelcu@gmail.com");
            return false;
        }
    }

    public static boolean nameValidation(String input) {
        Matcher match = Pattern.compile("^[A-Za-z]*\\s[A-Za-z]*").matcher(input);
        if (match.matches()) {
            return true;
        } else {
            System.out.println("The input is wrong! Try again \n Example of valid input:Nedelcu Florin or Lupu Ioan  ");
            return false;
        }
    }

    public static boolean cnpValidation(String input) {

        Matcher match = Pattern.compile("^[0-9]{13}").matcher(input);
        if (match.matches()) {
            return true;
        } else {
            System.out.println("The input is wrong! Try again \n Example of valid input: 5053020304123, The CNP MUST HAVE 13 DIGITS ");
            return false;
        }
    }


    private static void print() {
        System.out.println("---------------- WELCOME TO SEBI'S PIZZA ----------------\n" +
                "1-Order a pizza\n"
                + "2-Hire a man\n"
                + "3-Fire an employee\n"
                + "4-Find an employee from the list by CNP\n"
                + "5-Replace an employee with someone else\n"
                + "6-Playlist manipulation\n"
                + "/help-Print the functions\n"
                + "/employees-Print the employees list\n"
                + "/exit-Exit\n");
    }


    private static void typesOfPizzas() {
        System.out.println("0-" + pepperoniPizza.getName() + " Price " + pepperoniPizza.getPrice() + "$" + " ingredients:" + pepperoniPizza.getIngredients() +
                "\n1-" + sausagePizza.getName() + " Price " + sausagePizza.getPrice() + "$ " + "ingredients:" + sausagePizza.getIngredients() +
                "\n2-" + kebabPizza.getName() + " Price " + kebabPizza.getPrice() + "$ " + "ingredients:" + kebabPizza.getIngredients() +
                "\n3-" + veganPizza.getName() + " Price " + veganPizza.getPrice() + "$" + " ingredients:" + veganPizza.getIngredients() +
                "\n4-" + quattroformaggi.getName() + " Price " + quattroformaggi.getPrice() + "$ " + "ingredients:" + quattroformaggi.getIngredients());
    }

    private static void additionsPrintPepperoni() {
        System.out.println("0-Stop the additions and finally place my order\n1-Extra sauce\n2-Extra cheese\n3-Pizza with a large Dough\n4-Extra pepperoni");
    }

    private static void additionsPrintSausage() {
        System.out.println("0-Stop the additions and finally place my order\n1-Extra sauce\n2-Extra cheese\n3-Pizza with a large Dough\n4-Extra sausage");
    }

    private static void additionsPrintVegan() {
        System.out.println("0-Stop the additions and finally place my order\n1-Extra corn\n2-Extra Cashew sauce\n3-Pizza with a large Dough");
    }

    private static void additionsPrintQuatro() {
        System.out.println("0-Stop the additions and finally place my order\n1-Extra sauce\n2-Extra cheese\n3-Pizza with a large Dough");
    }


    private static void play(LinkedList<Songs> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        boolean ahead = true;
        ListIterator<Songs> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!flag) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    flag = true;
                    break;
                case 1:
                    if (!ahead) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        ahead = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        ahead = false;
                    }
                    break;

                case 2:
                    if (ahead) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        ahead = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        ahead = true;
                    }
                    break;
                case 3:
                    if (ahead) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            ahead = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            ahead = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;


            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 -Exit\n"
                + "1 -Play the next song\n"
                + "2 -Play the previous song\n"
                + "3 -Replay the current song\n"
                + "4 -Print songs in the playlist\n"
                + "5 -Print available actions.\n");

    }


    private static void printList(LinkedList<Songs> playList) {
        Iterator<Songs> iterator = playList.iterator();
        System.out.println("================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }


}
class Songs {
    private String title;
    private Double duration;

    public Songs(String title, Double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}


interface pizzaMethods {
    void print();
    double finalPrice();
    void fetchSelectionFromUser(String x);
}
abstract class Pizza implements  pizzaMethods {
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
class KebabPizza extends  Pizza {
    public KebabPizza() {
        super("Kebab Pizza", "White dough", "tomato sauce, pound meat, yogurt sauce" +
                ", bell pepper, onion, oregano, cumin,black pepper", 14.0);
    }

    @Override
    public void fetchSelectionFromUser(String x) {
        super.fetchSelectionFromUser(x);
    }

    @Override
    public void additionalIngredients() {
        super.additionalIngredients();
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

class PepperoniPizza extends Pizza {
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
class Quattroformaggi extends Pizza {
    public Quattroformaggi() {
        super("Quattro formaggi", "white dough", "Fontina Cheese, Gorgonzola" +
                "Mozzarella di Bufala, Grana Padano cheese, tomato sauce,", 13.0);
    }

    @Override
    public void additionalIngredients() {
        super.additionalIngredients();
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
class SausagePizza extends Pizza {
    public SausagePizza() {
        super("Sausage Pizza ", "white dough", "tomato sauce, pork sausage, Italian blend cheese" +
                " bell pepper", 9.0);
    }

    @Override
    public void fetchSelectionFromUser(String x) {
        super.fetchSelectionFromUser(x);
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
    public void print() {
        super.print();
    }

    @Override
    public double finalPrice() {
        return super.finalPrice();
    }
}

class VeganPizza extends  Pizza{
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
class Employee {
    private final String role;
    private final String name;
    private final String phoneNr;
    private final String email;
    private final String CNP;

    public Employee(String role, String name, String phoneNr, String email, String CNP) {
        this.role=role;
        this.name = name;
        this.phoneNr = phoneNr;
        this.email = email;
        this.CNP = CNP;
    }

    public static Employee createEmployee(String role, String name, String phoneNr, String email, String CNP){
        return new Employee(role,name,phoneNr,email,CNP);
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public String getCNP() {
        return CNP;
    }
}
class HireEmployee {
    private List<Employee> list;

    public HireEmployee() {
        this.list = new ArrayList<>();
    }

    public boolean addNewEmployee(Employee employee) {
        if (findEmployee(employee.getCNP()) >= 0) {
            System.out.println("You already hired this employee ");
            return false;
        }
        this.list.add(employee);
        System.out.println(employee.getName()+", added to your employees");
        return true;
    }

    public boolean removeEmployee(Employee employee) {
        if (findEmployee(employee.getCNP()) < 0) {
            System.out.println("Employee not found");
            return false;
        }
        this.list.remove(employee);
        System.out.println(employee.getName()+" , was removed");
        return true;

    }

    public boolean replaceEmployee(Employee employee1, Employee employee2) {
        if (findEmployee(employee1.getCNP()) < 0) {
            System.out.println("Employee not found");
            return false;
        }
        this.list.set(findEmployee(employee1), employee2);
        System.out.println(employee1.getName() + " replaced with " + employee2.getName());
        return true;
    }
    public String ifEmployeeExists(Employee employee){
        if(findEmployee(employee)>=0){
            return employee.getCNP();

        }
        return null;
    }
    public Employee ifEmployeeExists(String cnp){
        int position=findEmployee(cnp);
        if(position>=0){
            return this.list.get(position);
        }
        return null;

    }

    public int findEmployee(Employee employee) {
        return this.list.indexOf(employee);

    }

    private int findEmployee(String CNP) {
        for (int i = 0; i < list.size(); i++) {
            Employee employee = this.list.get(i);
            if (employee.getCNP().equals(CNP)) {
                return i;
            }
        }
        return -1;
    }
    public void printEmployees(){
        if(list.size()==0){
            System.out.println("The list of employees is empty");
        }
        for(int i=0;i<list.size();i++){
            System.out.println((i+1)+"."+this.list.get(i).getRole()+" Name:"+this.list.get(i).getName()+
                    " Phone number "+this.list.get(i).getPhoneNr()+" email:"+this.list.get(i).getEmail()+
                    " CNP:"+this.list.get(i).getCNP());
        }
    }
}









