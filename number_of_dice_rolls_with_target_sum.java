/***
* "You have d dice, and each die has f faces numbered 1, 2, ..., f.
* Return the number of possible ways (out of fd total ways) modulo 10^9 + 7
* to roll the dice so the sum of the face up numbers equals target." -Leetcode problem 1155
***/

class Solution {
    
    public HashMap<String, Integer> rollsTargetToNumber = new HashMap<>();
    private int faces;
    private int total = 0;
    
    public int numRollsToTarget(int d, int f, int target) {
        this.faces=f;
        for(int i =1; i <=faces; i++){
            total = (total + this.dfs(d-1, target-i)) % (int) (Math.pow(10, 9)+7);
        }
        return total % (int) (Math.pow(10, 9)+7);
    }
    
    public int dfs(int rolls, int target){
        int sum = 0;
        if(target == 0 && rolls == 0){
            rollsTargetToNumber.put(rolls+ " " + target, 1);
            return 1;
        }else if(target <= 0 || rolls == 0){
            return 0;
        }
        
        if(rollsTargetToNumber.containsKey(rolls+ " " + target)){   
            return rollsTargetToNumber.get(rolls+ " " + target);
        }
        
        for(int i =1; i <= faces; i++){
            if(target >= i){
                sum = (sum + dfs(rolls-1, target-i)) % (int) (Math.pow(10, 9)+7);
            }
        }
        
        rollsTargetToNumber.put(rolls+ " " + target, sum% (int) (Math.pow(10, 9)+7));
        return sum% (int) (Math.pow(10, 9)+7);
    }
}
