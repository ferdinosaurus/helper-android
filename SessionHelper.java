public class SessionHelper {
    protected SharedPreferences pref;
    protected SharedPreferences.Editor editor;

    protected void beginInitialization(Context context, String name) {
        pref = context.getSharedPreferences(name, 0); // 0 - for private mode
        editor = pref.edit();
    }

    protected void setSession(String key, String val) {
        editor.putString(key, val);
        editor.commit();
    }

    protected void setSession(String key, int val) {
        editor.putInt(key, val);
        editor.commit();
    }
    protected void setSession(String key, long val) {
        editor.putLong(key, val);
        editor.commit();
    }

    protected void setSession(String key, boolean val) {
        editor.putBoolean(key, val);
        editor.commit();
    }

    protected void removeSessionLogin(){
        editor.clear();
        editor.commit();
    }
}
