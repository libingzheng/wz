package com.example.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class CView extends View {
    private Context mcontext;
    private int width;
    private int height;
    private int radial=50;
    private Paint paint;

    public CView(Context context) {
        super(context);
        init();
    }

    public CView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mcontext=context;
        init();
    }

    public CView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mcontext=context;
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        WindowManager wm=(WindowManager) mcontext.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = wm.getDefaultDisplay();
        width = defaultDisplay.getWidth();
        height = defaultDisplay.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width/2,height/2,radial,paint);
    }
}
