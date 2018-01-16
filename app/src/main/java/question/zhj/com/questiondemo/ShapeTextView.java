package question.zhj.com.questiondemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 文字 shape
 * Created by zhahaijun on 2018/1/12.
 * Email 18655961751@163.com
 */

public class ShapeTextView extends LinearLayout {

    private String text = "";
    private TextView mTextView;

    public ShapeTextView(Context context) {
        this(context, null);
    }

    public ShapeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.text);
        if (null != typedArray) {
            text = typedArray.getString(R.styleable.text_text);
            typedArray.recycle();
        }
        initView();
    }

    private void initView() {
        View view = View.inflate(getContext(), R.layout.widget_shape_textview_layout, this);
        mTextView = view.findViewById(R.id.textView);
        mTextView.setText(text);
    }
}
