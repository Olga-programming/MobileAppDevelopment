package com.olga.day06broadcasting.phone_call_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Date;

abstract public class PhoneCallReceiver extends BroadcastReceiver {

    private static final String TAG = PhoneCallReceiver.class.getSimpleName();

    private static int lastState = TelephonyManager.CALL_STATE_IDLE;
    private static Date callStartTime;
    private static boolean isIncoming;
    private static String savedNumber;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")){
            savedNumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");

            Log.i(TAG,"new outgoing call" + savedNumber);
        } else {
            savedNumber = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            String stateString  = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            Log.i(TAG,"new outgoing call" + stateString +  " saved number " +savedNumber);

            int state = 0;

            if(TelephonyManager.EXTRA_STATE_IDLE.equals(stateString)){
                state = TelephonyManager.CALL_STATE_IDLE;
            }else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stateString)){
                state = TelephonyManager.CALL_STATE_OFFHOOK;
            }else if (TelephonyManager.EXTRA_STATE_RINGING.equals(stateString)){
                state = TelephonyManager.CALL_STATE_RINGING;
            }
            onCallStateChanged(context, state, savedNumber);
        }
    }

    private void onCallStateChanged(Context context, int state, String number){
        if (lastState == state){
            return;
        }

        switch (state){
            case TelephonyManager.CALL_STATE_RINGING:
                isIncoming=true;
                callStartTime =new Date();
                savedNumber = number;
                onIncommingCallStarted(context, savedNumber, callStartTime);
                break;

            case TelephonyManager.CALL_STATE_OFFHOOK:
                if(lastState != TelephonyManager.CALL_STATE_RINGING){
                    isIncoming=false;
                    callStartTime =new Date();
                    savedNumber = number;
                onOutgoingCallStarted(context, savedNumber, callStartTime);
                } else {
                    isIncoming=true;
                    callStartTime =new Date();
                    savedNumber = number;

                    onIncommingCallAnswered(context, savedNumber, callStartTime);
                }
                break;

            case TelephonyManager.CALL_STATE_IDLE:
                if(lastState == TelephonyManager.CALL_STATE_RINGING){
                    onMissedCall(context, savedNumber, callStartTime);
                } else if( isIncoming){
                    onIncommingCallEnded(context, savedNumber, callStartTime);
                } else {
                    onOutcommingCallEnded(context, savedNumber, callStartTime);
                }
                break;
                default:break;
        }
    }

    protected abstract void onIncommingCallStarted(Context context, String number, Date start);
    protected abstract void onOutgoingCallStarted(Context context, String number, Date start);
    protected abstract void onIncommingCallAnswered(Context context, String number, Date start);
    protected abstract void onMissedCall(Context context, String number, Date start);
    protected abstract void onIncommingCallEnded(Context context, String number, Date start);
    protected abstract void onOutcommingCallEnded(Context context, String number, Date start);

}
