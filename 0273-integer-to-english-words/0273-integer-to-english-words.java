// class Solution {
//     Map<Integer, String> map = new HashMap<>();

//     public Solution() {
//         map.put(1, "One");
//         map.put(2, "Two");
//         map.put(3, "Three");
//         map.put(4, "Four");
//         map.put(5, "Five");
//         map.put(6, "Six");
//         map.put(7, "Seven");
//         map.put(8, "Eight");
//         map.put(9, "Nine");
//         map.put(10, "Ten");
//         map.put(11, "Eleven");
//         map.put(12, "Twelve");
//         map.put(13, "Thirteen");
//         map.put(14, "Fourteen");
//         map.put(15, "Fifteen");
//         map.put(16, "Sixteen");
//         map.put(17, "Seventeen");
//         map.put(18, "Eighteen");
//         map.put(19, "Nineteen");

//         map.put(20, "Twenty");
//         map.put(30, "Thirty");
//         map.put(40, "Forty");
//         map.put(50, "Fifty");
//         map.put(60, "Sixty");
//         map.put(70, "Seventy");
//         map.put(80, "Eighty");
//         map.put(90, "Ninety");
//     }
//     public String convert(int num) {

//         if (num == 0) {
//             return "";
//         }

//         if (num < 20) {
//             return map.get(num);
//         }

//         if (num < 100) {
//             return map.get((num / 10) * 10) +
//                    (num % 10 == 0 ? "" : " " + convert(num % 10));
//         }

//         return map.get(num / 100) + " Hundred" +
//                (num % 100 == 0 ? "" : " " + convert(num % 100));
//     }
//     public String numberToWords(int num) {
//         if (num == 0) {
//             return "Zero";
//         }

//         if (num >= 1000000000) {
//             return convert(num / 1000000000) + " Billion" +
//                    (num % 1000000000 == 0 ? "" : " " + numberToWords(num % 1000000000));
//         }

//         if (num >= 1000000) {
//             return convert(num / 1000000) + " Million" +
//                    (num % 1000000 == 0 ? "" : " " + numberToWords(num % 1000000));
//         }

//         if (num >= 1000) {
//             return convert(num / 1000) + " Thousand" +
//                    (num % 1000 == 0 ? "" : " " + numberToWords(num % 1000));
//         }

//         return convert(num);
//     }
// }
// solution 2

class Solution {

    private final String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) return "Zero";

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (num > 0) {

            int chunk = num % 1000;

            if (chunk != 0) {

                StringBuilder part = new StringBuilder();

                convert(chunk, part);

                if (!thousands[i].isEmpty()) {
                    part.append(thousands[i]).append(" ");
                }

                result.insert(0, part);
            }

            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    private void convert(int num, StringBuilder result) {

        if (num >= 100) {
            result.append(below20[num / 100])
                  .append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            result.append(tens[num / 10])
                  .append(" ");
            num %= 10;
        }

        if (num > 0) {
            result.append(below20[num])
                  .append(" ");
        }
    }
}
