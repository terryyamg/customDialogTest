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

				/*�ϥΫȻs��layout*/
				dialog.setContentView(R.layout.dialog);
				dialog.setTitle("�ڥX�Ӱ�");

				etDialog = (EditText) dialog.findViewById(R.id.etDialog);	//�Ȼs��Dialog�s���r
				btConfirm = (Button) dialog.findViewById(R.id.btConfirm);	//�Ȼs��Dialog�T�{���s

				btConfirm.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						message = etDialog.getText().toString();	//�Ȼs��Dialog��J�T�����T��
				        tvDialog.setText(message);	//��ܿ�J�T��
						dialog.dismiss();	//�����Ȼs��Dialog
					}
				});

				dialog.show();
			}
		});
        
        
    }
}