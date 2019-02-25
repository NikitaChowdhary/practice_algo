package GFGeek;

public class MutliplyTwoString {

    public String multiply(String a,String b){
        int al = a.length() - 1;
        int bl = b.length() - 1;

        int min = Math.min(al, bl);
        int carrForward = 0;
        String res = "";

        while(true) {
            if (al < 0 || bl < 0) break;
            int current = (Character.getNumericValue(a.charAt(al)) * Character.getNumericValue(b.charAt(bl))) + carrForward;
            al--;
            bl--;
            carrForward = current / 10;
            res += current % 10;
        }

        while (al >= 0) {
            int current = Character.getNumericValue(a.charAt(al)) + carrForward;
            al--;
            carrForward = current / 10;
            res += current % 10;

        }
        while (bl >= 0) {
            int current = Character.getNumericValue(b.charAt(bl)) + carrForward;
            bl--;
            carrForward = current / 10;
            res += current % 10;

        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new MutliplyTwoString().multiply("3", "90"));
    }
}
