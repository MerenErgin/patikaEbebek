import java.util.Scanner;

public class Employee {

    static String name;
    static int salary;
    static int workHours;
    static int hireYear;

    static double tax = 0;
    static int bonus;
    static double zam;
    static int simdikiYil = 2021;
    static double newSalary;
    static double maasArtisi;

    public Employee(String name, int salary, int workHours, int hireYear) {

        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Lütfen çalışanın adını ve soyadını yazınız");
        name = scan.nextLine();

        System.out.println("Lütfen çalışanın maaşını yazınız");
        salary = scan.nextInt();

        System.out.println("Lütfen haftalık çalışma saatini yazınız");
        workHours = scan.nextInt();

        System.out.println("Lütfen işe başlangıç yılını yazınız");
        hireYear = scan.nextInt();


        tax(salary);

        bonus(workHours);

        raiseSalary(hireYear);


        Employee employee = new Employee(name , salary , workHours , hireYear );

        System.out.println(employee);

    }


    public static void tax(int salary){

        if (salary > 1000){
            tax = (salary / 100)*3;
        }

    }

    public static void bonus(int workHours){

        int fazlalikSaat = workHours - 40;

        if ( fazlalikSaat > 0 ){
            bonus = fazlalikSaat * 30;
        }else {
            bonus = 0;
        }

    }

    public static void raiseSalary(int hireYear){

        int calisilanYil = simdikiYil - hireYear;

        double SalaryForZam = salary + bonus - tax;

        if (calisilanYil < 10){

            zam = (SalaryForZam / 100)*5;

        }else if ( calisilanYil< 20){

            zam = (SalaryForZam / 100)*10;

        }else {

            zam = (SalaryForZam / 100)*15;

        }

        newSalary = salary + zam;

        maasArtisi = newSalary - salary ;

    }


    public String toString() {

        String sonuc ="Çalışanın Adı-Soyadı: " + name+
                "\nÇalışanın eski maaşı: " + salary + "TL" +
                "\nÇalışanın haftalık çalışma saati: " + workHours + " saat" +
                "\nÇalışanın işe başlama tarihi: " + hireYear +
                "\nÇalışanın vergisi: " + tax + "TL" +
                "\nÇalışanın bonusu: " + bonus + "TL" +
                "\nÇalışanın maaş artışı: " + maasArtisi + "TL" +
                "\nÇalışanın vergi ve bonuslarla birlikte maaşı: "+ (newSalary + bonus + tax) +
                "\nÇalışanın toplam maaşı: " + (newSalary + bonus) + "TL";

        return sonuc;
    }
}
