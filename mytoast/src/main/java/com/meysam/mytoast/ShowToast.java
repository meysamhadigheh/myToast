package com.meysam.mytoast;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.meysam.mytoast.helper.ViewUIHelper;


public class ShowToast {


    Context context;
    Integer drawableRight, drawableLeft;
    String typefaceName;
    Integer color, background;
    Integer rightIconTint, leftIconTint;
    Integer padding;

    ConstraintLayout mainLayout;


    private ShowToast(Context context) {
        this.context = context;
    }

    public void show(String string) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = null;
        if (inflater != null) {
            layout = inflater.inflate(R.layout.toast,
                    null);

            mainLayout = layout.findViewById(R.id.toast_layout_root);

        }


        TextView text = layout.findViewById(R.id.main_text);
        ImageView imgRight = layout.findViewById(R.id.right_icon);
        ImageView imgLeft = layout.findViewById(R.id.left_icon);


// set right icon
        if (drawableRight != null) {
            imgRight.setImageResource(drawableRight);
            if (rightIconTint != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    imgRight.setColorFilter(context.getColor(rightIconTint));
                }
            }
        } else {
            imgRight.setVisibility(View.GONE);
        }

// set left icon
        if (drawableLeft != null) {
            imgLeft.setImageResource(drawableLeft);
            if (leftIconTint != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    imgLeft.setColorFilter(context.getColor(leftIconTint));
                }
            }
        } else {
            imgLeft.setVisibility(View.GONE);

        }

// set typeface
        if (typefaceName != null) {

            Typeface typeface = Typeface.createFromAsset(context.getAssets(), typefaceName);
            text.setTypeface(typeface);

        }
//set text color
        if (color != null) {
            text.setTextColor(color);
        }

//set toast background
        if (background != null) {
            mainLayout.setBackgroundResource(background);
        }

// set padding
        if (padding != null) {
            mainLayout.setPadding(ViewUIHelper.dpToPx(padding), ViewUIHelper.dpToPx(padding), ViewUIHelper.dpToPx(padding), ViewUIHelper.dpToPx(padding));
        } else {
            mainLayout.setPadding(ViewUIHelper.dpToPx(20), ViewUIHelper.dpToPx(20), ViewUIHelper.dpToPx(20), ViewUIHelper.dpToPx(20));
        }


        text.setText(string);


        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM, 0, ViewUIHelper.dpToPx(110));
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public ShowToast setTypeFace(String typefaceName) {
        this.typefaceName = typefaceName;

        return this;
    }


    public ShowToast setLeftIcon(Integer drawableLeft) {
        this.drawableLeft = drawableLeft;
        return this;
    }

    public ShowToast setLeftIconTint(Integer leftIconTint) {
        this.leftIconTint = leftIconTint;
        return this;
    }

    public ShowToast setRightIcon(Integer drawableRight) {
        this.drawableRight = drawableRight;
        return this;
    }

    public ShowToast setRightIconTint(Integer rightIconTint) {
        this.rightIconTint = rightIconTint;
        return this;
    }

    public ShowToast setTextColor(Integer color) {
        this.color = color;
        return this;
    }

    public ShowToast setBackground(Integer background) {
        this.background = background;
        return this;
    }

    public ShowToast setPadding(Integer padding) {
        this.padding = padding;
        return this;
    }

    public static ShowToast with(Context context) {
        return new ShowToast(context);
    }

}
