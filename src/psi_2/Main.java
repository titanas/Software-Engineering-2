package psi_2;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
    Esybes, su rolėmis ar be jų, bendro funkcionalumo požiūriu galima naudoti vienodai (per bendrą interfeisą).
    Esybė galėtų dinamiškai įgyti/prarasti roles.
    Rolių aibė būtų lengvai plečiama.
    Esybė galėtų vienu metu turėti keletą rolių.
    Rolių(bent vienos) funkcionalumas turi būti toks, kad jo realizavimas reikalautų tiesioginės sąveikos su pagrindinės esybės objektu -žr. 2 pavyzdį.
    Turi būti galimybė sužinoti ar esybė turi papildomų rolių ir, jei taip, tai esybę naudoti specifiškai(per rolės interfeisą).
 **/

public class Main {

    public static void main(String[] args) {

       
        System.out.println("DARBUOTOJŲ GEBĖJIMAI");
        Worker worker = null;
        while(true) {
            System.out.println("\nMENIU");
            System.out.println("1 - Sukurti naują darbuotoją");
            System.out.println("2 - Pridėti roles");
            System.out.println("3 - Pašalinti roles");
            System.out.println("4 - Peržiūrėti informaciją apie darbuotoją");
            System.out.println("5 - Gauti darbuotoją su tam tikra role");
            System.out.println("0 - Baigti darbą");
            switch(readInt()) {

                case 1 : {
                    worker = new SimpleProgrammer();
                    if (worker != null) System.out.println("Naujas darbuotojas sukurtas");
                    break;
                }

                case 2: {
                    if (worker != null) {
                        showRolesMeniu();
                        int choice = readInt();
                        if (choice == 1) {
                            worker = new Administrator(worker);
                        } else if (choice == 2) {
                            worker = new Analyst(worker);
                        } else if (choice == 3) {
                            worker = new Designer(worker);
                        } else if (choice == 4) {
                            worker = new SuperRole(worker);
                        } else {
                            System.out.println("Blogas pasirinkimas");
                        }
                    } else {
                        System.out.println("Pirmiausia sukurkite darbuotoją.");
                    }
                    break;
                }

                case 3 : {
                    System.out.println("Rolės šalinimas");
                    if (worker != null) {
                        if (worker instanceof RoleDecorator) {
                            showRolesMeniu();
                            int choice = readInt();
                            if (choice == 1) {
                                worker = RoleDecorator.removeRole(worker, "Administrator");
                            } else if (choice == 2) {
                                worker = RoleDecorator.removeRole(worker, "Analyst");
                            } else if (choice == 3) {
                                worker = RoleDecorator.removeRole(worker, "Designer");
                            } else if (choice == 4) {
                                worker = RoleDecorator.removeRole(worker, "SuperRole");
                            } else {
                                System.out.println("Blogas pasirinkimas");
                            }
                        } else {
                            System.out.println("Darbuotojas rolių neturi.");
                        }                        
                    } else {
                        System.out.println("Pirmiausia sukurkite darbuotoją.");
                    }
                    break;
                }

                case 4 : {
                    System.out.println("Rolės informacija");
                    System.out.println("Veikla: " + worker.work());
                    System.out.println("Patirtis: " + worker.subjects());
                    System.out.println("Atlygis: " + worker.salary());
                    break;
                }

                case 5 : {
                    
                    System.out.println("Roles gavimas pagal pavadinimą");
                    if (worker != null) {
                        if (worker instanceof RoleDecorator) {
                            showRolesMeniu();
                            int choice = readInt();
                            if (choice == 1) {
                                worker = RoleDecorator.getRole(worker, "Administrator");
                            } else if (choice == 2) {
                                worker = RoleDecorator.getRole(worker, "Analyst");
                            } else if (choice == 3) {
                                worker = RoleDecorator.getRole(worker, "Designer");
                            } else if (choice == 4) {
                                worker = RoleDecorator.getRole(worker, "SuperRole");
                            } else {
                                System.out.println("Blogas pasirinkimas");
                            }
                        } else {
                            System.out.println("Darbuotojas rolių neturi.");
                        }                  
                    } else {
                        System.out.println("Pirmiausia sukurkite darbuotoją.");
                    }
                    break;
                }

                case 0: {
                    System.out.println("Programos pabaiga.");
                    System.exit(0);
                }
                     
            }
        }    
    }

    public static void showRolesMeniu() {
        System.out.println("Pasirinkite role:");
        System.out.println("1 - Administratoriaus rolė");
        System.out.println("2 - Analitiko rolė");
        System.out.println("3 - Projektuotojo rolė");
        System.out.println("4 - SUPER rolė");
    }
    
    public static int readInt() {
        int num = 0;
        System.out.println("Įveskite savo pasirinkimą");
        Scanner in = new Scanner(System.in);
        try {
            num = (int) in.nextInt();
            
        } catch (InputMismatchException e) {
            System.out.println("Įvedėte ne skaičių.");
            System.exit(0);
        } catch(NoSuchElementException e) {
            System.out.println("Įvedėte ne skaičių.");
            System.exit(0);
        }
        System.out.println();
        return num;
    }
}
