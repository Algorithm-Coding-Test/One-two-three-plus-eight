import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    
    public static class Case{
        long oddNum;
        long evenNum;
        public Case(long oddNum, long evenNum){
            this.oddNum = oddNum;
            this.evenNum = evenNum;
        }
    }

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        scan.nextLine();

        ArrayList<Integer> inputList = new ArrayList<>();
        for(int i = 0; i < T; i ++){
            inputList.add(scan.nextInt());
            scan.nextLine();
        }
        Case[] tabulation = new Case[Collections.max(inputList)];
        
        tabulation[0] = new Case(1, 0);
        tabulation[1] = new Case(1, 1);
        tabulation[2] = new Case(2, 2);

        long tmpOdd;
        long tmpEven;

        for(int i = 3;i<tabulation.length;i++){
            
            tmpOdd = tabulation[i-3].evenNum;
            tmpOdd += tabulation[i-2].evenNum;
            tmpOdd += tabulation[i-1].evenNum;
            tmpOdd = (tmpOdd > 1000000009) ? tmpOdd % 1000000009 : tmpOdd;
            
            tmpEven = tabulation[i-3].oddNum;
            tmpEven += tabulation[i-2].oddNum;
            tmpEven += tabulation[i-1].oddNum;
            tmpEven = (tmpEven > 1000000009) ? tmpEven % 1000000009 : tmpEven;

            tabulation[i] = new Case(tmpOdd, tmpEven);
        }
        
        for(int i=0;i<T;i++){
            System.out.print(tabulation[inputList.get(i)-1].oddNum +" "+ tabulation[inputList.get(i)-1].evenNum +"\n");
        }
    }
	
}
