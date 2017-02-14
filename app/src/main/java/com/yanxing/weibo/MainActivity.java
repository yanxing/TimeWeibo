package com.yanxing.weibo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.yanxing.titlebarlibrary.TitleBar;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.common.SendWeiboActivity;
import com.yanxing.weibo.common.WeiboOperate;
import com.yanxing.weibo.message.MessageMainFragment;
import com.yanxing.weibo.util.CommonUtil;
import com.yanxing.weibo.discover.DiscoverMainFragment;
import com.yanxing.weibo.home.HomeMainFragment;
import com.yanxing.weibo.me.MeMainFragment;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity {

    @BindView(R.id.titleBar)
    TitleBar mTitleBar;

    @BindView(R.id.home)
    ImageView mHome;

    @BindView(R.id.message)
    ImageView mMessage;

    @BindView(R.id.send)
    ImageView mSend;

    @BindView(R.id.discover)
    ImageView mDiscover;

    @BindView(R.id.me)
    ImageView mMe;

    public static final int HOME = 0;
    public static final int MESSAGE = 1;
    public static final int DISCOVER = 2;
    public static final int ME = 3;
    private long exitTime = 0;
    public static final String REFRESH ="refresh";

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterInstanceView() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainContent, new HomeMainFragment(), HomeMainFragment.class.getName())
                .commit();
    }

    @OnClick({R.id.home, R.id.message, R.id.send, R.id.discover, R.id.me})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                if (replace(new HomeMainFragment())){
                    setTab(HOME);
                }else {
                    EventBus.getDefault().post(REFRESH);
                }
                break;
            case R.id.message:
                setTab(MESSAGE);
                replace(new MessageMainFragment());
                break;
            case R.id.send:
                Intent intent=new Intent(getApplicationContext(), SendWeiboActivity.class);
                intent.putExtra("type", WeiboOperate.SEND_WEIBO.getIntValue());
                intent.putExtra("anim",true);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_open,0);
                break;
            case R.id.discover:
                setTab(DISCOVER);
                replace(new DiscoverMainFragment());
                break;
            case R.id.me:
                setTab(ME);
                replace(new MeMainFragment());
                break;
        }
    }

    /**
     * 替换新的Fragment,如果是这个Fragment，则不替换，返回false
     */
    private boolean replace(Fragment fragment) {
        final String tag = fragment.getClass().toString();
        if (getSupportFragmentManager().findFragmentByTag(tag)!=null){
            return false;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContent, fragment, tag)
                .commit();
        return true;
    }

    /**
     * 设置底部导航图片
     *
     * @param index
     */
    private void setTab(int index) {
        mHome.setImageDrawable(getResources().getDrawable(index == HOME ? R.mipmap.home_press : R.mipmap.home));
        mMessage.setImageDrawable(getResources().getDrawable(index == MESSAGE ? R.mipmap.message_press : R.mipmap.message));
        mDiscover.setImageDrawable(getResources().getDrawable(index == DISCOVER ? R.mipmap.discover_press : R.mipmap.discover));
        mMe.setImageDrawable(getResources().getDrawable(index == ME ? R.mipmap.me_press : R.mipmap.me));
        mTitleBar.setVisibility(View.VISIBLE);
        CommonUtil.setStatusBarDarkMode(true,this);
        if (index == HOME) {
            mTitleBar.setTitle(getString(R.string.home));
        } else if (index == MESSAGE) {
            mTitleBar.setTitle(getString(R.string.message));
        } else if (index == DISCOVER) {
            mTitleBar.setVisibility(View.GONE);
        } else if (index == ME) {
            mTitleBar.setVisibility(View.GONE);
            CommonUtil.setStatusBarDarkMode(false,this);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            showToast(getString(R.string.zai_an_yi_ci_tui_chu_app));
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
