class Solution {
    int max=0,start=0,end=0;
    public Boolean isPalindrome(int i,int j,String s ){
        while(i<j){
            char ch1=s.charAt(i);
            char ch2=s.charAt(j);
            if(ch1!=ch2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int i,j;
        for(i=0;i<n;i++){
            for(j=i;j<n;j++){
                if(isPalindrome(i,j,s)==true){
                    if((j-i+1)>max){
                        max=j-i+1;
                        start=i;
                        end=j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}