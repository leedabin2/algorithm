class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int t = bandage[0];

        
        int maxHealth = health;
        int bonusCnt = 0;  // 연속 회복 성공 시간
        int attackIdx = 0; // 공격 배열 인덱스
        
        for (int time = 1; time <= attacks[attacks.length - 1][0]; time++) {
            // 현재 시간이 공격시간일 때 
            if (attackIdx < attacks.length && time == attacks[attackIdx][0]) {
                // 1 회복 연속 시간 초기화
                bonusCnt = 0;
                // 2 현재 체력 변화
                health -= attacks[attackIdx][1];
                attackIdx++;
                if (health <= 0) return -1;
            }
            // 현재 시간이 공격 시간이 아닐 때
            else {
                bonusCnt++;
                health += bandage[1];
                
                // 연속 성공 시
                if(bonusCnt == bandage[0]) {
                    bonusCnt = 0;
                    health += bandage[2];
                }
                
                 if (health > maxHealth) health = maxHealth;
            }
        }
        return health;
    }
}