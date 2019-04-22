/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gesetudiant;

import gesetudiant.model.Model;
import gesetudiant.service.Service;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author JUNIOR
 */
public class Gesetudiant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
            Model etd1,etd2;
            Model etd;

            String matricule,nom,filiere;
            int niveau;

           Service service;
            service = new Service();

           // Menu

          int choix;

          do{
            System.out.println(" ----------------MENU------------------------- ");
            System.out.println(" 1. Enregistrer un nouvel étudiant");
            System.out.println(" 2. Liste de tous les étudiants");
            System.out.println(" 3. Liste de tous les étudiants d'une filière donnée");
            System.out.println(" 4. Recherche et affiche les informations d'un étudiant par son matricule");
            System.out.println(" 5. Suppression d'un étudiant à partir de son matricule"); 
            System.out.println(" 6. Modification du niveau d'un étudiant donné");
            System.out.println(" Veuillez entrer votre choix(1-6): ");
             choix=sc.nextInt();          

          switch(choix)
          { 
              // Méthode d'enregistrement d'un nouvel étudiant
              case 1:
             System.out.print(" Entrer le matricule: ");
             matricule = sc.next();
            
             System.out.print(" Entrer le nom : ");
             nom = sc.next();
             
             System.out.print(" Entrer la filiere : ");
             filiere = sc.next();
             
             System.out.print(" Entrer le niveau : ");
             niveau = sc.nextInt(); 
            
             etd = new Model(matricule,nom,filiere,niveau);
             service.ajout_nouveau_etudiant (etd);
              System.out.println(" Enregistrement  effectué ");

                  break;
                  
                // Méthode d'affichage de tous les étudiant
                    case 2: 
                      service.afficher_liste_etudiant(); 

                  break;
                      
                // Méthode d'affichage des étudiant par filiere
                    case 3: 
                    System.out.print(" Entrer la filière: "); 
                    filiere = sc.next();
                    service.afficher_liste_etudiant_par_filiere(filiere);

                  break;
                    
                // Méthode de recherche d'un étudiant par filière
                    case 4:
                    System.out.print(" Entrer le matricule de l'étudiant à rechercher : ");
                    matricule = sc.next();
                    System.out.print(" L'étudiant rechercher est: ");
                    service.rechercher_etudiant_a_partir_du_matricule(matricule);

                  break;
                
                // Méthode de suppression
                    case 5:
                    System.out.print(" Entrer le matricule de l'etudiant à supprimer : ");
                    matricule = sc.next();
                    service.supprime_matricule(matricule);
                    service.afficher_liste_etudiant();
                    System.out.println(" Suppression reussie. ");

                  break;
                
                // Méthode de modification du niveau d'un étudiant
                    case 6:
                    System.out.print("Entrer le matricule  de l'etudiant : ");
                    matricule = sc.next();
                    System.out.print("Modifier le niveau de l'etudiant : ");
                    niveau = sc.nextInt();
                    service.modifier_niveau_etudiant(matricule,niveau);
                    service.afficher_liste_etudiant();
                    System.out.println("Mise à jour effectuée"); 
                    
                    break;
                     
                    default:System.out.println("veuillez rester l'ordre");
        } 
          }while(choix!=6);
    }
    
}
