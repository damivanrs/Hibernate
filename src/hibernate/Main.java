/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ivan
 */
public class Main {
       public static void main(String[] args) {     
      ManageEmployee ME = new ManageEmployee();
      /* Let us have a set of certificates for the first employee  */
      HashMap  set1 = new HashMap ();
      set1.put("ComputerScience", new Certificate("MCA"));
      set1.put("BusinessManagement", new Certificate("MBA"));
      set1.put("BusinessManagement", new Certificate("PMP"));
     
      /* Add employee records in the database */
      Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1);

      /* List down all the employees */
      ME.listEmployees();

      /* Update employee's salary records */
      ME.updateEmployee(empID1, 5000);

      /* List down all the employees */
      ME.listEmployees();
      ME.close();
 }

    
}
