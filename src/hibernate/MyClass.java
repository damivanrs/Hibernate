/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Comparator;

/**
 *
 * @author Ivan
 */
public class MyClass implements  Comparator <String>{
   public int compare(String o1, String o2) {
      final int BEFORE = -1;
      final int AFTER = 1;

      /* To reverse the sorting order, multiple by -1 */
      if (o2 == null) {
         return BEFORE * -1;
      }

      Comparable thisCertificate = o1;
      Comparable thatCertificate = o2;

      if(thisCertificate == null) {
         return AFTER * 1;
      } else if(thatCertificate == null) {
         return BEFORE * -1;
      } else {
         return thisCertificate.compareTo(thatCertificate) * -1;
      }
   }
} 