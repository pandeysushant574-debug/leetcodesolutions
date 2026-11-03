// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int len = s.length();
//         int maxLen = 0;

//         for (int i = 0; i < len; i++) {
//             for (int j = i; j < len; j++) {
//                 if (checkUniqueChars(s, i, j)) {
//                     maxLen = Math.max(maxLen, j - i + 1);
//                 }
//             }
//         }

//         return maxLen;
//     }

//     public boolean checkUniqueChars(String s, int startIdx, int endIdx) {
//         Set<Character> chars = new HashSet<>();

//         for (int i = startIdx; i <= endIdx; i++) {
//             char c = s.charAt(i);

//             if (chars.contains(c)) {
//                 return false;
//             }

//             chars.add(c);
//         }

//         return true;
//     }
// }
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Set<Character> set = new HashSet<>();

//         int left = 0;
//         int maxLen = 0;

//         for (int right = 0; right < s.length(); right++) {

//             char c = s.charAt(right);

//             while (set.contains(c)) {
//                 set.remove(s.charAt(left));
//                 left++;
//             }

//             set.add(c);

//             maxLen = Math.max(maxLen, right - left + 1);
//         }

//         return maxLen;
//     }
// }
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int[] lastSeen = new int[65536];

//         int left = 0;
//         int maxLen = 0;

//         for (int right = 0; right < s.length(); right++) {
//             char c = s.charAt(right);

//             left = Math.max(left, lastSeen[c]);

//             maxLen = Math.max(maxLen, right - left + 1);

//             lastSeen[c] = right + 1;
//         }

//         return maxLen;
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}