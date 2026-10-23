import java.util.*;
public class Employee_Management_System {
 static class Employee{
    int id;
    String name,dept;
    double salary;
    Employee(int i,String n,String d,double s){
        id=i;
        name=n;
        dept=d;
        salary=s;
    }
    public String toString(){
        return id+" | "+name+" | "+dept+" | "+salary;
    }
}
 static Scanner s=new Scanner(System.in);
 static List<Employee> e=new ArrayList<>();
 public static void main(String[]x){
    while(true){
        System.out.println("\n1.Add 2.View 3.Search 4.Sort Salary 5.Delete 6.Exit");
        int c=s.nextInt();
        s.nextLine();
        if(c==1){
            System.out.print("ID: ");
            int i=s.nextInt();
            s.nextLine();
            System.out.print("Name: ");
            String n=s.nextLine();
            System.out.print("Dept: ");
            String d=s.nextLine();
            System.out.print("Salary: ");
            double v=s.nextDouble();
            e.add(new Employee(i,n,d,v));
        }else if(c==2)
            e.forEach(System.out::println);
        else if(c==3){
            System.out.print("Department: ");
            String d=s.nextLine();
            e.stream().filter(q->q.dept.equalsIgnoreCase(d)).forEach(System.out::println);
        }else if(c==4)
            e.sort(Comparator.comparingDouble(q->q.salary));
        else if(c==5){
            System.out.print("ID: ");
            int i=s.nextInt();
            e.removeIf(q->q.id==i);
        }else break;
    }
}
}
