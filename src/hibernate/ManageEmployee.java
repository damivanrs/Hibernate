package hibernate;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List; 
import java.util.Iterator; 
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

 
import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ManageEmployee {
   private static SessionFactory factory; 
   public ManageEmployee(){
       Configuration conf=new Configuration();
       conf.configure();
       ServiceRegistry serv = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
       factory=conf.buildSessionFactory(serv);
   }
   
   /* Method to add an employee record in the database */
   public Integer addEmployee(String fname, String lname, int salary, TreeMap cert){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try{
         tx = session.beginTransaction();
         Employee employee = new Employee(fname, lname, salary);
         employee.setCertificates(cert);
         employeeID = (Integer) session.save(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return employeeID;
   }
   
/* Method to list all the employees detail */
   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator1 = 
                           employees.iterator(); iterator1.hasNext();){
            Employee employee = (Employee) iterator1.next(); 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
            System.out.println("  Salary: " + employee.getSalary());
            Map ec = employee.getCertificates();
            System.out.println("Certificate: " + 
              (((Certificate)ec.get("ComputerScience")).getCertificateName()));
            System.out.println("Certificate: " + 
              (((Certificate)ec.get("BusinessManagement")).getCertificateName()));
            System.out.println("Certificate: " + 
              (((Certificate)ec.get("ProjectManagement")).getCertificateName()));         
         } 
         tx.commit(); 
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   
      /* Method to update salary for an employee */
   public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary( salary );
         session.update(employee);
         tx.commit();
      }catch (HibernateException e) { 
           if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   
       /* Method to update salary for all employee at 10% more */
   public void updateSalaryEmployee(){
      Session session = factory.openSession();
      Transaction tx = null;
      int salaryBegin=0;
      try{
         tx = session.beginTransaction();
         String hql= "UPDATE Employee set salary = salary*1.1";
         Query query=session.createQuery(hql);
         int result=query.executeUpdate();
         System.out.println("Rows affected: "+result);
         tx.commit();
      }catch (HibernateException e) { 
           if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to delete an employee from the records */
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

    void close() {
       factory.close();
    }
}