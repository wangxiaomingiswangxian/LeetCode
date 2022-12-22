
/**
 * @author 王贤
 */
public class ParkingSystem {

    public  static char slowestKey(int[] releaseTimes, String keysPressed) {
        int press = 0;
        int max = 0;
        char result = 'a';
        for (int i = 0; i < releaseTimes.length; i++) {
            int l = releaseTimes[i] - press;
            if (l > max) {
                max=l;
                result = keysPressed.charAt(i);
            } else if (l == max) {
                result = (char) Math.max(result, keysPressed.charAt(i));
            }
            press = releaseTimes[i];
        }
        return result;
    }
}
