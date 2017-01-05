package com.yanxing.weibo.common;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.yanxing.weibo.R;
import com.yanxing.weibo.common.model.DownloadImage;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 保存图片对话框，位于底部
 * Created by lishuangxiang on 2017/1/5.
 */
public class ImageMenuDialog extends DialogFragment{

    @BindView(R.id.save_image)
    TextView mSaveImage;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog alertDialog=builder.create();
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        alertDialog.setContentView(R.layout.dialog_iamge_menu);
        alertDialog.setCanceledOnTouchOutside(true); // 外部点击取消
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        ButterKnife.bind(this,alertDialog);
        mSaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DownloadImage(true));
                ImageMenuDialog.this.dismiss();
            }
        });
        return builder.create();
    }
}
