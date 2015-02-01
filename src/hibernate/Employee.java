/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Set;
import java.util.SortedSet;

/**
 *
 * @author Ivan
 */
public class Employee {
    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private SortedSet certificates;


    public Employee() {}

    public Employee(String firstName, String lastName, int salary) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
       public SortedSet getCertificates() {
      return certificates;
   }
   public void setCertificates( SortedSet certificates ) {
      this.certificates = certificates;
   }
}
