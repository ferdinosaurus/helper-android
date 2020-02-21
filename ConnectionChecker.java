public class ConnectionChecker {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean checkConnection(Context context){
        final ConnectivityManager cM = (ConnectivityManager) context.getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
        Network nI = cM.getActiveNetwork();

        return nI == null;
    }

}
