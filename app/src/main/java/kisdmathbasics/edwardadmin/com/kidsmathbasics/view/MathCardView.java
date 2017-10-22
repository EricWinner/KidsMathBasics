package kisdmathbasics.edwardadmin.com.kidsmathbasics.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import kisdmathbasics.edwardadmin.com.kidsmathbasics.R;
import kisdmathbasics.edwardadmin.com.kidsmathbasics.drawable.LinearDrawable;
import kisdmathbasics.edwardadmin.com.kidsmathbasics.drawable.RelativeDrawable;
import kisdmathbasics.edwardadmin.com.kidsmathbasics.util.ScreenSizeUtil;

/**
 * Created by EdwardAdmin on 2017/10/22.
 */

public class MathCardView extends LinearLayout {

    private static final String TAG = "MathCardView";
    private RelativeLayout mTopLayout;
    private LinearLayout mParentLayout;
    private ImageView mCenterLayout;
    private View mView;
    private EditText mComment;

    private RelativeDrawable mRelativeDrawable;
    private LinearDrawable mLinearDrawable;
    private GradientDrawable mGradientDrawable;

    public MathCardView(Context context) {
        super(context);
        init(context);
    }

    public MathCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public MathCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(final Context context) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.activity_main_view, null);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ScreenSizeUtil.Dp2Px(getContext(), 285), LayoutParams.WRAP_CONTENT));
        layout.setLayerType(View.LAYER_TYPE_SOFTWARE, null);//没有这句不显示

        mTopLayout = (RelativeLayout) layout.findViewById(R.id.top);
        mCenterLayout = (ImageView) layout.findViewById(R.id.center);
        mComment = (EditText) layout.findViewById(R.id.comment);

        //include layout
        mParentLayout = (LinearLayout) layout.findViewById(R.id.activity_main);

        //top background
        mRelativeDrawable = new RelativeDrawable();
        mTopLayout.setBackground(mRelativeDrawable);

        mLinearDrawable = new LinearDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.quote));
        mCenterLayout.setBackground(mLinearDrawable);

        //mathcardview background
        mGradientDrawable = (GradientDrawable) mParentLayout.getBackground();
        addView(layout);
    }

    public void changeTheme(final int color) {
        mRelativeDrawable.setColor(color);
        mRelativeDrawable.setColor(color);
        mGradientDrawable.setColor(color);
    }
}
