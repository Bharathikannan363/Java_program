import java.util.*;
public class Expense_Tracker{
    public static void main(String[]x){
        Scanner s=new Scanner(System.in);
        List<String>items=new ArrayList<>();
        double total=0;
        while(true){
            System.out.println("\n1.Add expense 2.View 3.Total 4.Exit");
            int c=s.nextInt();
            s.nextLine();
            if(c==1){
                System.out.print("Description: ");
                String d=s.nextLine();
                System.out.print("Amount: ");
                double a=s.nextDouble();
                items.add(d+" - "+a);total+=a;
            }else if(c==2)
                 items.forEach(System.out::println);
            else if(c==3)
                 System.out.println("Total: "+total);
            else break;
        }
    }
}
