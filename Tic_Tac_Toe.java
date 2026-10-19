import java.util.*;
public class Tic_Tac_Toe{
    static char[]b={'1','2','3','4','5','6','7','8','9'};
    static boolean win(char p)
     {int[][]w={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
      for(int[]q:w)if(b[q[0]]==p&&b[q[1]]==p&&b[q[2]]==p)
       return true;return false;
      }
public static void main(String[]x){
    Scanner s=new Scanner(System.in);
    for(int t=0;t<9;t++){
        System.out.println(Arrays.toString(b));
        char p=t%2==0?'X':'O';
        System.out.print(p+" position: ");
        int i=s.nextInt()-1;
        if(i<0||i>8||b[i]=='X'||b[i]=='O'){
            t--;continue;
        }
        b[i]=p;
        if(win(p)){
            System.out.println(p+" wins!");
            return;
        }
    }System.out.println("Draw!");
}
}
