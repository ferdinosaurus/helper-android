import java.util.AbstractMap;
import java.util.Collection;

public class NullEmptyChecker {
    // cek object == null or object == empty
    public static Boolean isNullOrEmpty(Object object) {
        if (object == null) {
            return true;
        } else if( object.equals("null")){
            return true;
        }else {
            if (object instanceof Collection) {
                if (((Collection) object).isEmpty()) {
                    return true;
                }
            } else if (object instanceof AbstractMap) {
                if (((AbstractMap) object).isEmpty()) {
                    return true;
                }
            } else if (object.toString().trim().equals("")) {
                return true;
            } else if (object.toString().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // cek object != null or object != empty
    public static Boolean isNotNullOrNotEmpty(Object object) {
        return !isNullOrEmpty(object);
    }
}