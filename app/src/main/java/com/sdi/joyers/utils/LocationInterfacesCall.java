package com.sdi.joyers.utils;

import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class LocationInterfacesCall {
    public interface LocationInterface {
        void onresume();

        void onpause();
    }

    public interface MapInterface {
        void onLocationUpdate(LocationResult location);

        void onMapReady(GoogleMap map);
    }

    public interface GetPlaceById {
        void onGetPlace(LatLng latLng);
    }


}
