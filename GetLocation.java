LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
if (location == null)
    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
if (location == null)
    location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
