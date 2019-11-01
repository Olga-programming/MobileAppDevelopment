package com.olga.day06broadcasting.phone_call_receiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class MyReceiver extends PhoneCallReceiver {

    private static final String TAG = MyReceiver.class.getSimpleName();

    @Override
    protected void onIncommingCallStarted(Context context, String number, Date start) {
        Log.i(TAG, "______Incomming ; satred " + number );
    }

    @Override
    protected void onOutgoingCallStarted(Context context, String number, Date start) {
        Log.i(TAG, "______Outgouing ; satred " + number );
    }

    @Override
    protected void onIncommingCallAnswered(Context context, String number, Date start) {
        Log.i(TAG, "______Incomming ; answered " + number );
    }

    @Override
    protected void onMissedCall(Context context, String number, Date start) {
        Log.i(TAG, "______nissed ; call " + number );
    }

    @Override
    protected void onIncommingCallEnded(Context context, String number, Date start) {
        Log.i(TAG, "______Incomming ; ended " + number );
    }

    @Override
    protected void onOutcommingCallEnded(Context context, String number, Date start) {
        Log.i(TAG, "______Outgoing ended ; satred " + number );
    }
}
