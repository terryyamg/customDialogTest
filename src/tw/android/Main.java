package tw.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {
	
	final Context context = this;
	private Button btDialog,btConfirm;
	private TextView tvDialog;
	private EditText etDialog;
	private String message;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btDialog = (Button) findViewById(R.id.btDialog);
        
        tvDialog = (TextView) findViewById(R.id.tvDialog);
        
        btDialog.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {

				final Dialog dialog = new Dialog(context);

				/*使用客製化layout*/
				dialog.setContentView(R.layout.dialog);
				dialog.setTitle("我出來啦");

				etDialog = (EditText) dialog.findViewById(R.id.etDialog);	//客製化Dialog編輯文字
				btConfirm = (Button) dialog.findViewById(R.id.btConfirm);	//客製化Dialog確認按鈕

				btConfirm.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						message = etDialog.getText().toString();	//客製化Dialog輸入訊息的訊息
				        tvDialog.setText(message);	//顯示輸入訊息
						dialog.dismiss();	//關閉客製化Dialog
					}
				});

				dialog.show();
			}
		});
        
        
    }
}