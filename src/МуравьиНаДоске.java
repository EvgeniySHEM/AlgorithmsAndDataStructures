public class МуравьиНаДоске {
    public static void main(String[] args) {

    }

    public int calculate(int n, int left, int right) {
        int round = 0;
        boolean reverse = false;

        //until the ants went out of bounds or met
        while (left >= 0 && left <= n && right >= 0 && right <= n) {
            if (left - 1 != right) {
                left -= 1;
            } else {
                left++;
                right--;
                reverse = true;
                round++;
                break;
            }
            if (right + 1 != left) {
                right += 1;
            } else {
                right--;
                reverse = true;
                round++;
                break;
            }
            round++;
        }

        //did the ants meet or not
        if (!reverse) {
            return round;
        }

        //until the ants went out of bounds
        while (left >= 0 && left <= n && right >= 0 && right <= n) {
            left++;
            right--;
            round++;
        }

        return round;
    }
}
