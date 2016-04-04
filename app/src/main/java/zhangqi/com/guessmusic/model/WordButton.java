package zhangqi.com.guessmusic.model;

import android.widget.Button;

/*
* 文字按钮
* @author Zhang Qi
* */
public class WordButton {
    private int mIndex;
    private boolean mIsVisiable;
    private String mWordString;

    private Button mViewButton;

    public WordButton(){
        mIsVisiable = true;
        mWordString = "";
    }

}
