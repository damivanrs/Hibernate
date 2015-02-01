package hibernate;


import java.util.List; 
import java.util.Iterator; 
import java.util.Set;

 
import org.hibernate.HibernateException; 
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
   public Integer addEmployee(String fname, String lname, 
                                            int salary, Set cert){
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
            Set certificates = employee.getCertificates();
            for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
                  Certificate certName = (Certificate) iterator2.next(); 
                  System.out.println("Certificate: " + certName.getCertificateName()); 
            }
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
         Employee employee = 
                    (Employee)session.get(Employee.class, EmployeeID); 
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
   /* Method to delete an employee from the records */
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                   (Employee)session.get(Employee.class, EmployeeID); 
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