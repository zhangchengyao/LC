public class LC825_FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];
        for(int age: ages) {
            ageCount[age]++;
        }

        int cnt = 0;
        for(int i = 1; i < ageCount.length; i++) {
            for(int j = 1; j <= i; j++) {
                if(j > 0.5 * i + 7) {
                    cnt += ageCount[i] * ageCount[j];
                    if(i == j) cnt -= ageCount[i];
                }
            }
        }

        return cnt;
    }
}
