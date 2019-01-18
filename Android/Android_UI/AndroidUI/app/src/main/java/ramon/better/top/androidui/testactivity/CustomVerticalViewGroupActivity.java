package ramon.better.top.androidui.testactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ramon.better.top.androidui.R;

/**
 * Created by meng.li on 2019/1/17.
 * 自定义 ViewGroup，实现把组件按顺序竖直排列，类似 LinearLayout 的效果
 */
public class CustomVerticalViewGroupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_vertical_view_group);
    }
}
