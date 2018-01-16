package question.zhj.com.questiondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /**
     * 默认类型。
     */
     CountDownView mTvDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvDefault = (CountDownView) findViewById(R.id.tv_default);
        mTvDefault.start();
    }
}
