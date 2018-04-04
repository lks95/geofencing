package com.adesso.lklein.geofencing;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lklein on 20.03.2018.
 */

public class GeoFenceTransitionService extends IntentService {

    private static final String TAG = GeoFenceTransitionService.class.getSimpleName();

    public static final int GEOFENCE_NOTIFICATION_ID = 0;

    public GeoFenceTransitionService() {

        super(TAG);
    }

    protected void onHandleIntent(Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);

        if ( geofencingEvent.hasError() ) {
            String errorMsg = getErrorString(geofencingEvent.getErrorCode() );
            Log.e( TAG, errorMsg );
            return;
        }

        int geoFenceTransition = geofencingEvent.getGeofenceTransition();

        if ( geoFenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER ||
                geoFenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT ) {

            List<Geofence> triggeringGeofences = geofencingEvent.getTriggeringGeofences();
            String geofenceTransitionDetails = getGeofenceTransitionDetail(geoFenceTransition, triggeringGeofences );
            sendNotification( geofenceTransitionDetails );
        }
    }






    private String getGeofenceTransitionDetail(int geoFenceTransition, List<Geofence> triggeringGeofence){

        ArrayList<String> geolist = new ArrayList<>();

        for(Geofence geofence : triggeringGeofence) {
            geolist.add(geofence.getRequestId());
        }

        String status = null;

        Long timeLong = System.currentTimeMillis()/1000;


        if(geoFenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER){
           // status = betreten des geofence;
            status = timeLong.toString();
        } else if (geoFenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT){
           // status = verlassen des geofence;
            status = timeLong.toString();
        }
            return status + TextUtils.join(",", geolist);
    }


    private void sendNotification (String msg){
        Log.i(TAG, "sendNotification: " +msg);

        Intent notificationIntent = MainActivity.makeNotificationIntent(getApplicationContext(), msg);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(notificationIntent);
        PendingIntent notificationPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //benachrichtungen senden und aktivieren
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(
                GEOFENCE_NOTIFICATION_ID,
                createNotification(msg, notificationPendingIntent)
        );
    }
        //benachrichtungen erschaffen
        private Notification createNotification(String msg, PendingIntent notificationIntent){
            NotificationCompat.Builder notificationbuilder = new NotificationCompat.Builder(this);
            notificationbuilder
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setColor(Color.BLUE)
                    .setContentTitle("Geofence Notification")
                    .setContentIntent(notificationIntent)
                    .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                    .setAutoCancel(true);
            return notificationbuilder.build();



    }

    private static String getErrorString(int errorCode) {
        switch (errorCode) {
            case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE:
                return "GeoFence not available";
            case GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES:
                return "Too many GeoFences";
            case GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS:
                return "Too many pending intents";
            default:
                return "Unknown error A.";
        }
    }





}
