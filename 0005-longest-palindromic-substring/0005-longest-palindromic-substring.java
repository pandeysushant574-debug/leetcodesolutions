// class Solution {
//     int max=0,start=0,end=0;
//     public Boolean isPalindrome(int i,int j,String s ){
//         while(i<j){
//             char ch1=s.charAt(i);
//             char ch2=s.charAt(j);
//             if(ch1!=ch2){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
//     public String longestPalindrome(String s) {
//         int n=s.length();
//         int i,j;
//         for(i=0;i<n;i++){
//             for(j=i;j<n;j++){
//                 if(isPalindrome(i,j,s)==true){
//                     if((j-i+1)>max){
//                         max=j-i+1;
//                         start=i;
//                         end=j;
//                     }
//                 }
//             }
//         }
//         return s.substring(start,end+1);
//     }
// }

class Solution {

    int max = 0;
    int start = 0;

    public void expand(int i, int j, String s) {

        while (i >= 0 && j < s.length() &&
               s.charAt(i) == s.charAt(j)) {

            int len = j - i + 1;

            if (len > max) {
                max = len;
                start = i;
            }

            i--;
            j++;
        }
    }

    public String longestPalindrome(String s) {

        int n = s.length();

        for (int i = 0; i < n; i++) {

            // Odd length palindrome
            expand(i, i, s);

            // Even length palindrome
            expand(i, i + 1, s);
        }

        return s.substring(start, start + max);
    }
}
