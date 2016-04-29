package com.daviddone.voa.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.daviddone.data.R;

public class LoginDialog extends Dialog {

    private Context context;
    private ClickListenerInterface clickListenerInterface;
	public static TextView tv_login_cancel;
	public static TextView tv_login_confirm;
	public static EditText et_password;
	public static EditText et_username;

    public interface ClickListenerInterface {

        public void doCancel();
        public void doConfirm();
    }

    public LoginDialog(Context context) {
        super(context, R.style.custom_dialog);
        setCanceledOnTouchOutside(false);
        setOnKeyListener(keylistener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        init();
    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_login, null);
        setContentView(view);

        et_username = (EditText) view.findViewById(R.id.et_username);
        et_password = (EditText) view.findViewById(R.id.et_password);
        tv_login_cancel = (TextView) view.findViewById(R.id.tv_login_cancel);
        tv_login_confirm = (TextView) view.findViewById(R.id.tv_login_confirm);
        tv_login_confirm.setOnClickListener(new clickListener());
        tv_login_cancel.setOnClickListener(new clickListener());
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.8); // 高度设置为屏幕的0.6
        dialogWindow.setAttributes(lp);
    }

    public void setClicklistener(ClickListenerInterface clickListenerInterface) {
        this.clickListenerInterface = clickListenerInterface;
    }

    private class clickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            int id = v.getId();
            switch (id) {
            case R.id.tv_login_cancel:
                clickListenerInterface.doCancel();
                break;
            case R.id.tv_login_confirm:
                clickListenerInterface.doConfirm();
                break;    
            }
        }

    };
    //返回按钮 不dismiss对话框
    OnKeyListener keylistener = new DialogInterface.OnKeyListener(){
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0)
            {
             return true;
            }
            else
            {
             return false;
            }
        }
    } ;
}