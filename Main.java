import java.io.*;
import java.util.*;

public class Main {
    
    public static class Case{
        int oddNum;
        int evenNum;
        public Case(int oddNum, int evenNum){
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

        int tmpOdd;
        int tmpEven;

        for(int i = 3;i<tabulation.length;i++){
            
            tmpOdd = tabulation[i-3].evenNum + 1;
            tmpOdd += tabulation[i-2].evenNum + 1;
            tmpOdd += tabulation[i-1].evenNum + 1;

            tmpEven = tabulation[i-3].oddNum + 1;
            tmpEven += tabulation[i-2].oddNum + 1;
            tmpEven += tabulation[i-1].oddNum + 1;
            
            tabulation[i] = new Case(tmpOdd, tmpEven);
        }
        
        for(int i=0;i<T;i++){
            System.out.print(tabulation[inputList.get(i)-1].oddNum +" "+ tabulation[inputList.get(i)-1].evenNum +"\n");
        }
    }
	
}
