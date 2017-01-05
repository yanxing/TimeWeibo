package com.yanxing.weibo.common;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.yanxing.weibo.R;
import com.yanxing.weibo.common.model.DownloadImage;

import de.greenrobot.event.EventBus;

/**
 * 保存图片对话框，位于底部
 * Created by lishuangxiang on 2017/1/5.
 */
public class ImageMenuDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_iamge_menu, null);
        TextView saveImage = (TextView) view.findViewById(R.id.save_image);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        saveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DownloadImage(true));
                ImageMenuDialog.this.dismiss();
            }
        });
        return dialog;
    }
}
