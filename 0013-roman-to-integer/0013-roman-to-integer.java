class Solution {
    public int romanToInt(String s) {
    //     Map<String ,Integer> map =new HashMap<>();

    //     map.put("I", 1);
    //     map.put("V", 5);
    //     map.put("X", 10);
    //     map.put("L", 50);
    //     map.put("C", 100);
    //     map.put("D", 500);
    //     map.put("M", 1000);

    //     map.put("IV", 4);
    //     map.put("IX", 9);
    //     map.put("XL", 40);
    //     map.put("XC", 90);
    //     map.put("CD", 400);
    //     map.put("CM", 900); 
    //     int i=0;
    //     int sum=0;
    //     while(i <s.length()){
    //         if(i<s.length()-1){
    //             String digit=s.substring(i,i+2);
    //             if(map.containsKey(digit)){
    //                 sum+=map.get(digit);
    //                 i=i+2;
    //                 continue;
    //             }
    //         }
    //         sum+=map.get(Character.toString(s.charAt(i)));
    //         i+=1; 
    //     }
    //     return sum;
    // }
    // solution 2
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = map.get(s.charAt(i));

            if (i + 1 < s.length() &&
                current < map.get(s.charAt(i + 1))) {

                sum -= current;

            } else {
                sum += current;
            }
        }

        return sum;
    }

}