package com.asum.xanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.asum.xanimation.callback.OnXAnimCallBack;
import com.asum.xanimation.utils.XAnimGroup;
import com.asum.xanimation.utils.XSingleAnim;

public class XAnimationMainActivity extends AppCompatActivity {
    private ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xanimation_main);

        imageView = (ImageView) findViewById(R.id.activity_maing_imageview);
        imageView.setImageResource(R.mipmap.ic_launcher);

        findViewById(R.id.activity_maing_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                singleAnim();
                grounpAnim();
            }
        });
    }

    private void singleAnim() {
        new XSingleAnim().alpha(0.5, 1, 0.5, 0.2, 1).delay(6000).duration(6000).callBack(new OnXAnimCallBack() {
            public void start() {
                super.start();
                Log.i("XJW", "开始");
            }

            public void end() {
                super.end();
                Log.i("XJW", "结束");
            }
        }).start(imageView);
    }

    private void grounpAnim() {
        new XAnimGroup()// 动画集合
                .add(new XSingleAnim().alpha(1, 0, 1).duration(6000))// 动画1
                .add(new XSingleAnim().translateX(300).duration(6000))// 动画2
                .add(new XSingleAnim().rotate(0, -90, 360, -360).duration(6000))// 动画3
                .start(imageView);
    }
}
