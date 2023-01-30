import java.util.*;

class CoinsCombinations{
    public int coinsCount(int[] coins,int amount){
        int count = 0,temp = 0,sum = amount;
        for(int i=0; i<coins.length-1;i++){
            for(int j=i+1;j<coins.length;j++)
            if(coins[i] < coins[j]){
                temp = coins[i];
                coins[i] = coins[j];
                coins[j] = temp;
            }
        }
        int[] value = new int[amount+1]; //Creating an Array of length(index) Equal to Amount
		Arrays.fill(value,Integer.MAX_VALUE); //Assigning all values to Max Value 
		value[0] = 0;
		for(int i = 0;i<coins.length;++i){	
			for(int j= coins[i];j<value.length;++j){
				if(value[j - coins[i]] != Integer.MAX_VALUE){
					
					value[j] = Math.min(value[j],value[j-coins[i]]+1);
				}
			}						
		}
        if(value[value.length-1]!=Integer.MAX_VALUE)
            return value[amount];

        return -1;    
    }
}

public class MidJanQ4{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        CoinsCombinations coin = new CoinsCombinations();
        System.out.println("Total Amount of Money :- ");
        int amount = input.nextInt();
        System.out.println("Number of Denominations :- ");
        int row = input.nextInt();
        System.out.println("Enter the Numbers :- ");
        int[] coins = new int[row];
        for(int i=0; i< row; i++)
            coins[i] = input.nextInt();

        System.out.print(coin.coinsCount(coins, amount));    
    }
}