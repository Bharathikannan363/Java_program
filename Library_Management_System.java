import java.util.*;
public class Library_Management_System{
 static class Book {
    int id;
    String title,author;
    boolean issued;
    Book(int i,String t,String a){
        id=i;
        title=t;
        author=a;
    }
    public String toString(){
        return id+" | "+title+" | "+author+" | "+(issued?"Issued":"Available");
    }
}
 static Scanner s=new Scanner(System.in);
 static List<Book>b=new ArrayList<>();
 public static void main(String[]x){
    while(true){
        System.out.println("\n1.Add 2.View 3.Issue 4.Return 5.Exit");
        int c=s.nextInt();
        s.nextLine();
        if(c==1){
            System.out.print("ID: ");
            int i=s.nextInt();
            s.nextLine();
            System.out.print("Title: ");
            String t=s.nextLine();
            System.out.print("Author: ");
            String a=s.nextLine();
            b.add(new Book(i,t,a));
        }else if(c==2)
            b.forEach(System.out::println);
        else if(c==3){
            System.out.print("ID: ");
            int i=s.nextInt();
            b.stream().filter(q->q.id==i).findFirst().ifPresent(q->q.issued=true);
        }else if(c==4){
            System.out.print("ID: ");
            int i=s.nextInt();
            b.stream().filter(q->q.id==i).findFirst().ifPresent(q->q.issued=false);
        }else break;
    }
}
}
