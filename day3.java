public class day3 {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];        
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        day3 sol = new day3();

        System.out.println(sol.findDuplicate(new int[]{1,1}));      
        System.out.println(sol.findDuplicate(new int[]{1,4,4,2,3}));
        System.out.println(sol.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(sol.findDuplicate(new int[]{3,1,3,4,2}));
    } 
}

