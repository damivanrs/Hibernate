/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class Main {
       public static void main(String[] args) {     
      ManageEmployee ME = new ManageEmployee();
      /* Let us have a set of certificates for the first employee  */
      ArrayList set1 = new ArrayList();
      set1.add(new Certificate("MCA"));
      set1.add(new Certificate("MBA"));
      set1.add(new Certificate("PMP"));
     
      /* Add employee records in the database */
      Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1);

      /* Another set of certificates for the second employee  */
      ArrayList set2 = new ArrayList();
      set2.add(new Certificate("BCA"));
      set2.add(new Certificate("BA"));

      /* Add another employee record in the database */
      Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, set2);

      /* List down all the employees */
      ME.listEmployees();

      /* Update employee's salary records */
      ME.updateEmployee(empID1, 5000);
 
      /* Delete an employee from the database */
            ME.deleteEmployee(empID2);
      /* List down all the employees */
      ME.listEmployees();
      ME.close();
 }

    
}
