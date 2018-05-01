package Amazon;

public class Anagrams {
    static int[] getMinimumDifference(String[] a, String[] b) {
        int output[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() == b[i].length()) {
                int frequency[] = new int[128];
                for (int j = 0; j < a[i].length(); j++) {
                    frequency[a[i].charAt(j)]++;
                    frequency[b[i].charAt(j)]--;
                }
                int count = 0;
                for (int f : frequency) {
                    if (f > 0)
                        count = count + f;
                }
                output[i] = count;
            } else {
                output[i] = -1;
            }
            System.out.println(output[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        String s1[] = {"tea", "tea", "act"};
        String s2[] = {"ate", "toe", "acts"};
        getMinimumDifference(s1, s2);

    }

}
