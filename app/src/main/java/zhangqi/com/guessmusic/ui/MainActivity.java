package zhangqi.com.guessmusic.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import zhangqi.com.guessmusic.R;


public class MainActivity extends Activity {

    //唱片相关动画
    private Animation mPanAnim;
    private LinearInterpolator mPanLin;
    //拨杆过去
    private Animation mBarInAnim;
    private LinearInterpolator mBarInLin;
    //拨杆回来
    private Animation mBarOutAnim;
    private LinearInterpolator mBarOutLin;

    private ImageView mViewPan;
    private ImageView mViewPanBar;

    //Play 按键事件
    private ImageButton mBtnPlayStart;

    //当前动画是否在运行
    private boolean mIsRunning = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPan = (ImageView) findViewById(R.id.imageView1);
        mViewPanBar = (ImageView) findViewById(R.id.imageView2);


        //初始化动画
        mPanAnim = AnimationUtils.loadAnimation(this,R.anim.rotate);
        mPanLin  = new LinearInterpolator();
        mPanAnim.setInterpolator(mPanLin);
        mPanAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //开启拨杆退出动画
                mViewPanBar.startAnimation(mBarOutAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //初始化拨杆
        mBarInAnim = AnimationUtils.loadAnimation(this,R.anim.rotate_45);
        mBarInLin  = new LinearInterpolator();
        mBarInAnim.setFillAfter(true);//动画播放完后保持结束时位置
        mBarInAnim.setInterpolator(mBarInLin);
        mBarInAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //开始唱片动画
                mViewPan.startAnimation(mPanAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //拨杆回来
        mBarOutAnim = AnimationUtils.loadAnimation(this,R.anim.rotate_d_45);
        mBarOutLin  = new LinearInterpolator();
        mBarOutAnim.setFillAfter(true);//动画播放完后保持结束时位置
        mBarOutAnim.setInterpolator(mBarOutLin);
        mBarOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //整套动画播放完毕
                mIsRunning =false;
                mBtnPlayStart.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mBtnPlayStart = (ImageButton) findViewById(R.id.btn_play_start);
        mBtnPlayStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePlayButton();
            }
        });
    }

    //处理圆盘中的播放按钮，就是开始播放音乐
    private void handlePlayButton(){
        if(mViewPanBar!=null) {
            if (!mIsRunning) {
                mIsRunning = true;
                //开始拨杆进入动画
                mViewPanBar.startAnimation(mBarInAnim);
                mBtnPlayStart.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void onPause() {
        //动画停止
        mViewPan.clearAnimation();
        super.onPause();
    }
}
