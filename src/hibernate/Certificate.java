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
}
