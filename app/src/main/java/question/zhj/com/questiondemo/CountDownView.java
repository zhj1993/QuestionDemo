package question.zhj.com.questiondemo;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator;

/**
 * 答题时间状态显示
 * Created by zhahaijun on 2018/1/15.
 * Email 18655961751@163.com
 */

public class CountDownView extends RelativeLayout {

    private CircleTextProgressbar mCircleTextProgressbar;
    private ShapeTextView mShapeTextView;//时间

    public CountDownView(Context context) {
        this(context, null);
    }

    public CountDownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        View.inflate(getContext(), R.layout.widget_count_down_layout, this);
        setClipChildren(false);
        initProgressBar();
    }

    /**
     * 初始化倒计时
     */
    private void initProgressBar() {
        mCircleTextProgressbar = findViewById(R.id.circle_text_progress);
        mShapeTextView = findViewById(R.id.shape_tv);
        mCircleTextProgressbar.setTimeMillis(10000);
        mCircleTextProgressbar.setOutLineColor(Color.LTGRAY);
        mCircleTextProgressbar.setCountdownProgressListener(100, new CircleTextProgressbar.OnCountdownProgressListener() {

            @Override
            public void onProgress(int what, int progress) {
                if (progress % 10 == 0) {
                    int i = Integer.parseInt(mCircleTextProgressbar.getText().toString());
                    i--;
                    if (i <= 3 && i > 0) {//开始动画
                        start321Anim();
                    }
                    mCircleTextProgressbar.setText(i + "");
                    if (i == 0) {
                        mCircleTextProgressbar.setText(10 + "");
                        endAnim();
                    }
                }
            }
        });
    }

    /**
     * 开始倒计时
     */
    public void start() {
        mCircleTextProgressbar.reStart();
    }


    /**
     * 倒计时3秒动画
     */
    private void start321Anim() {
        AdditiveAnimator.animate(mCircleTextProgressbar)
                .scale(1.3f).setInterpolator(new LinearInterpolator()).setDuration(200)
                .then()
                .scale(1).setInterpolator(new LinearInterpolator()).setDuration(200).start();
    }

    /**
     * 结束动画
     */
    private void endAnim() {
        AdditiveAnimator.animate(mShapeTextView).scale(0.7f).setDuration(400)
                .setInterpolator(new LinearInterpolator()).then()
                .scale(1f).setInterpolator(new BounceInterpolator())
                .setDuration(600).addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                mCircleTextProgressbar.setVisibility(INVISIBLE);
                mShapeTextView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        }).start();
    }

}
