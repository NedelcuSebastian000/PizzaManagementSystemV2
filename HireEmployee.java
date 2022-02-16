package com.company;

import java.util.ArrayList;
import java.util.List;

public class HireEmployee {
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
