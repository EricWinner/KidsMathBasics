package kisdmathbasics.edwardadmin.com.kidsmathbasics.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by EdwardAdmin on 2017/10/22.
 */

public class RelativeDrawable extends Drawable {

    private Paint mMainPaint;
    private Paint mShadowPanit;
    private Path mMainPath;
    private RectF mRectF;

    private int startLocation = 20;
    private int endLocation = 20;
    private int color = 0x2601a3a1;

    public RelativeDrawable() {
        mMainPaint = new Paint();
        mMainPaint.setColor(Color.WHITE);
        mMainPaint.setAntiAlias(true);

        mShadowPanit = new Paint();
        mShadowPanit.setColor(Color.WHITE);
        mShadowPanit.setAntiAlias(true);

        mMainPath = new Path();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(mMainPath, mShadowPanit);
        canvas.drawRect(startLocation, getBounds().height(), getBounds().width() - startLocation, getBounds().height() + 21, mMainPaint);
    }

    @Override
    public void onBoundsChange(Rect bounds) {
        mMainPath.reset();
        mRectF = new RectF(startLocation, endLocation, bounds.width() - startLocation, bounds.height());
        mMainPath.addRoundRect(mRectF, new float[]{6, 6, 6, 6, 0, 0, 0, 0}, Path.Direction.CW);
    }

    public void setColor(int color) {
        this.color = color;
        // 设定阴影(柔边, X 轴位移, Y 轴位移, 阴影颜色)
        mShadowPanit.setShadowLayer(21, 0, 10, color & 0x26ffffff);//0x2600A4A0
        invalidateSelf();
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
