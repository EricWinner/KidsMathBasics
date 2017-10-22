package kisdmathbasics.edwardadmin.com.kidsmathbasics.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import kisdmathbasics.edwardadmin.com.kidsmathbasics.R;

/**
 * Created by EdwardAdmin on 2017/10/20.
 */

public class MathItemView extends View {

    private static final String TAG = "MathItemView";

    private static final int ITEM_GAP_WIDTH = 20;
    private int ITEM_GAP_HEIGHT = 0;

    private Context mContext;
    private Paint mTextPaint;
    private Rect mBonds;

    private String mNumberFirstText = "";
    private String mNumberSecondText = "";
    private String mNumberThirdText = "";
    private String mSymbolFirstText = "";
    private String mSymbolSecondText = "";
    private String mSymbolThirdText = "=";

    private int mNumberTextColor;
    private int mNumberTextSize;
    private int mNewCircleColor = 0xff01a3a1;


    public MathItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MathItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MathItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        TypedArray array = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomMathView, defStyleAttr, 0);
        int length = array.getIndexCount();
        for (int index = 0; index < length; index++) {
            int attr = array.getIndex(index);
            switch (attr) {
                case R.styleable.CustomMathView_mNumberFirstText:
                    mNumberFirstText = array.getString(attr);
                    break;
                case R.styleable.CustomMathView_mNumberSecondText:
                    mNumberSecondText = array.getString(attr);
                    break;
                case R.styleable.CustomMathView_mNumberThirdText:
                    mNumberThirdText = array.getString(attr);
                    break;
                case R.styleable.CustomMathView_mSymbolFirstText:
                    mSymbolFirstText = array.getString(attr);
                    break;
                case R.styleable.CustomMathView_mSymbolSecondText:
                    mSymbolSecondText = array.getString(attr);
                    break;
                case R.styleable.CustomMathView_mNumberTextColor:
                    mNumberTextColor = array.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomMathView_mNumberTextSize:
                    mNumberTextSize = array.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 18, getResources().getDisplayMetrics()));
                    break;
            }
        }
        mBonds = new Rect();
        mTextPaint = new Paint();
        mTextPaint.getTextBounds(mNumberFirstText, 0, mNumberFirstText.length(), mBonds);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mTextPaint.setColor(Color.parseColor(getCurrentCircleColor()));
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mTextPaint);
        mTextPaint.setColor(mNumberTextColor);
        mTextPaint.setTextSize(mNumberTextSize);

        mTextPaint.setFakeBoldText(true);
        drawAllText(canvas);
    }

    private void drawAllText(Canvas canvas) {
        ITEM_GAP_HEIGHT = getMeasuredHeight() / 2;
        //draw first text  ->
        float firstNumberTextLocation = ITEM_GAP_WIDTH;
        canvas.drawText(mNumberFirstText, firstNumberTextLocation, ITEM_GAP_HEIGHT, mTextPaint);

        //draw first symbol ->
        float firstSymbolTextLocation = mTextPaint.measureText(mNumberFirstText) + firstNumberTextLocation * 2;
        canvas.drawText(mSymbolFirstText, firstSymbolTextLocation, ITEM_GAP_HEIGHT, mTextPaint);

        //draw second text
        float secondNumberTextLocation = mTextPaint.measureText(mSymbolFirstText) + firstSymbolTextLocation + firstNumberTextLocation;
        canvas.drawText(mNumberSecondText, secondNumberTextLocation, ITEM_GAP_HEIGHT, mTextPaint);

        //draw second symbol
        float secondSymbolTextLocation = mTextPaint.measureText(mNumberSecondText) + secondNumberTextLocation + firstNumberTextLocation;
        canvas.drawText(mSymbolSecondText, secondSymbolTextLocation, ITEM_GAP_HEIGHT, mTextPaint);

        //draw third text
        float thirdNumberTextLocation = mTextPaint.measureText(mSymbolSecondText) + secondSymbolTextLocation + firstNumberTextLocation;
        canvas.drawText(mNumberThirdText, thirdNumberTextLocation, ITEM_GAP_HEIGHT, mTextPaint);

        //draw third symbol
        float thirdSymbolTextLocation = mTextPaint.measureText(mNumberThirdText) + thirdNumberTextLocation + firstNumberTextLocation;
        canvas.drawText(mSymbolThirdText, thirdSymbolTextLocation, ITEM_GAP_HEIGHT, mTextPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private String getCurrentCircleColor() {
        String str = "000000" + Integer.toHexString(mNewCircleColor);
        str = "#" + str.substring(str.length() - 6);
        return str;
    }

    public void setCurrentColor (int currentColor) {
        mNewCircleColor = currentColor;
    }

    public void setNumberFirstText (String numberFirstText) {
        mNumberFirstText = numberFirstText;
    }

    public void setNumberSecondText (String numberSecondText) {
        mNumberSecondText = numberSecondText;
    }
    public void setNumberThirdText (String numberThirdText) {
        mNumberThirdText = numberThirdText;
    }

    public void setSymbolFirstText (String symbolFirstText) {
        mSymbolFirstText = symbolFirstText;
    }

    public void setSymbolSecondText (String symbolSecondText) {
        mSymbolSecondText = symbolSecondText;
    }

}
