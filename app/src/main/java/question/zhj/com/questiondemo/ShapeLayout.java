package question.zhj.com.questiondemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

/**
 * shape View  也可以展示进度
 * Created by zhahaijun on 2018/1/12.
 * Email 18655961751@163.com
 */

public class ShapeLayout extends LinearLayout {

    private Paint mNormalPaint;//画笔
    private int mNormalColor = Color.LTGRAY;//背景色
    private int mType = 1;//1 填充 2描边

    public ShapeLayout(Context context) {
        this(context, null);
    }

    public ShapeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.shape_layout);
        if (null != typedArray) {
            mType = typedArray.getInteger(R.styleable.shape_layout_type, mType);
            mNormalColor = typedArray.getColor(R.styleable.shape_layout_color, mNormalColor);
            typedArray.recycle();
        }
        initView();
    }

    /**
     * 初始化画笔
     */
    private void initView() {
        setGravity(Gravity.CENTER);
        mNormalPaint = new Paint();
        mNormalPaint.setAntiAlias(true);
        setType(mType);
        mNormalPaint.setStrokeWidth(3);
        mNormalPaint.setColor(mNormalColor);
        setWillNotDraw(false);//设置此方法调用onDraw方法
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF rectF = new RectF(2, 2, getMeasuredWidth() - 2, getMeasuredHeight() - 2);
        //绘制圆角矩形
        canvas.drawRoundRect(rectF, 100, 100, mNormalPaint);
    }

    /**
     * 设置画笔的颜色
     *
     * @param mNormalColor
     */
    public void setPaintColor(int mNormalColor) {
        this.mNormalColor = mNormalColor;
        if (null != mNormalPaint) {
            mNormalPaint.setColor(this.mNormalColor);
        }
    }

    /**
     * 设置画笔填充
     */
    private void setStyleFill() {
        if (null != mNormalPaint) {
            mNormalPaint.setStyle(Paint.Style.FILL);
        }
    }

    /**
     * 设置画笔描边
     */
    private void setStyleStroke() {
        if (null != mNormalPaint) {
            mNormalPaint.setStyle(Paint.Style.STROKE);
        }
    }

    /**
     * 设置画笔样式
     *
     * @param type
     */
    public void setType(int type) {
        this.mType = type;
        if (mType == 1) {
            setStyleFill();
        } else {
            setStyleStroke();
        }
    }

    /**
     * 重新绘制
     */
    public void reset(){
        invalidate();
    }
}
