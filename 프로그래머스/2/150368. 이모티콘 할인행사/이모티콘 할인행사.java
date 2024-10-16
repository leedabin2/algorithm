class Solution {
    static int maxSubScribe = 0;
    static int maxPrice = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] discounts = {10,20,30,40};
        int[] discountCombinations = new int[emoticons.length];
        int[] result = new int[2];
        
        dfs(users,emoticons,discounts,discountCombinations,0);
        result[0] = maxSubScribe;
        result[1] = maxPrice;
        
        return result;
    }
    private void dfs(int[][] users,int[] emoticons,int[] discounts,int[] discountCombinations,int depth) {
        if (depth == emoticons.length) {
            calculate(users, emoticons, discountCombinations); 
            return;
        }
        
        for (int discount : discounts) {
            discountCombinations[depth] = discount;
            dfs(users,emoticons,discounts,discountCombinations,depth+1);
        }
    }
    private void calculate(int[][] users, int[] emoticons,int[] discountCombinations) { 
        int subscribeCount = 0;
        int emotionsCost = 0;
        
        for (int[] user : users) {
            int max_discount = user[0];
            int max_cost = user[1];
            
            int totalCost = 0;
            
            for (int i=0; i < emoticons.length ; i++) {
                if (discountCombinations[i] >= max_discount) {
                    totalCost += emoticons[i] * (100 - discountCombinations[i]) / 100;
                }
            }
            
            if (totalCost >= max_cost) {
                subscribeCount++;
            }
            else {
                emotionsCost += totalCost; 
            }
        }
        
        if (subscribeCount > maxSubScribe || (subscribeCount == maxSubScribe && emotionsCost > maxPrice)) {
            maxSubScribe = subscribeCount;
            maxPrice = emotionsCost;
        }
        
    }
}