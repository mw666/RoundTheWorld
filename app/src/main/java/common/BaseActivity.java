package common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/19.
 * <p>
 * 此activity类就作为应用程序内所有界面的父类
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置view视图
        setContentView(getContentLayoutId());
        //添加进容器
        AppManager.getInstance().addActivty(this);
        //findviewById(.....)
        ButterKnife.bind(this);
        initData();
        initListener();

    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract int getContentLayoutId();
}
