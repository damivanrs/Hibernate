/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

/**
 *
 * @author Ivan
 */

public class Certificate {
    private static final long serialVersionUID = 1L;
    private int id;
    private String certificateName;
    
   public Certificate(String name) {
      this.certificateName = name;
   }

    public Certificate() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public int hashCode() {
        int tmp = 0; 
        tmp = ( id + certificateName ).hashCode(); 
        return tmp;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (!this.getClass().equals(obj.getClass())) return false;

      Certificate obj2 = (Certificate)obj;
      if((this.id == obj2.getId()) && (this.certificateName.equals(obj2.getCertificateName())))
      {
         return true;
      }
      return false;
   }

    @Override
    public String toString() {
        return "hibernate.Certificate[ id=" + id + " ]";
    }
    
}
