package question.zhj.com.questiondemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/**
 * Created by zhahaijun on 2018/1/12.
 * Email 18655961751@163.com
 */

public class AnswerStateView extends RelativeLayout {

    private ShapeLayout mShpaeLayout;//填充View
    private ProgressBar mProgressbar;//进度条
    private int progress;//进度值
    private int mNormalColor = Color.LTGRAY;//背景色
    private int mType = 1;//1 填充 2描边

    public AnswerStateView(Context context) {
        this(context, null);
    }

    public AnswerStateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnswerStateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.shape_layout);
        if (null != typedArray) {
            mType = typedArray.getInteger(R.styleable.shape_layout_type, mType);
            progress = typedArray.getInteger(R.styleable.shape_layout_progress, mType);
            mNormalColor = typedArray.getColor(R.styleable.shape_layout_color, mNormalColor);
            typedArray.recycle();
        }
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        View view = View.inflate(getContext(), R.layout.widget_answer_state_layout, this);
        mShpaeLayout = view.findViewById(R.id.shape_layout);
        mProgressbar = view.findViewById(R.id.progressbar);
        mProgressbar.setProgress(progress);
        mShpaeLayout.setType(mType);
        mShpaeLayout.setPaintColor(mNormalColor);
        mShpaeLayout.reset();
    }

    public void setProgress(int progress){

    }
}
