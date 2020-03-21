public class HelperRepeatCharacter {
    private static int maxRepetChar = 3;

    public static boolean call(String input){
        if (input.length()<maxRepetChar)return false;
        else{
            for (int i = 0; i < input.length()-maxRepetChar; i++) {
                if (checkRepeat(input.substring(i,i+maxRepetChar))) return true;
            }
            return false;
        }
    }

    private static boolean checkRepeat(String input){
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(0) != input.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
