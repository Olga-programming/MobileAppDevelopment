package com.olga.day05dialogs.toast;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.olga.day05dialogs.R;

public class ToastBuilder {

    public static Toast alert (Context context, String text, int duration){
        ToastCustom toastCustom = new ToastCustom(context);
        toastCustom.setText(text);
        toastCustom.getToast().setDuration(duration);
        toastCustom.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
        toastCustom.setIcon(R.drawable.ic_launcher_foreground);
        //toastCustom.getView().setBackground(0x7ffffcf);
        return toastCustom.getToast();
    }

    public static Toast imageToast (Context context, int imageRes, int duration){
        Toast toast = new Toast(context);
        LinearLayout layout = new LinearLayout(context);
        ImageView iv = new ImageView(context);

        layout.setLayoutParams(new LinearLayout.LayoutParams(850,650));
        layout.addView(iv);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.requestLayout();
        iv.setLayoutParams(layout.getLayoutParams());
        iv.setImageResource(imageRes);

        toast.setView(layout);
        toast.setDuration(duration);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 500);
        return toast;
    }

}
