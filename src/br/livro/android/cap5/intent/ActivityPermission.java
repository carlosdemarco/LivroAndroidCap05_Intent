package br.livro.android.cap5.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.livro.android.cap5.R;

/**
 * Iniciar uma Activity com permissão
 * 
 * @author ricardo
 *
 */
public class ActivityPermission extends Activity {

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		setContentView(R.layout.form_intent_permission);

		Button btOk1 = (Button) findViewById(R.id.btOk1);
		Button btOk2 = (Button) findViewById(R.id.btOk2);
		
		btOk1.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				startActivity(new Intent(ActivityPermission.this,ActivityPermission_Go.class));
			}});
		btOk2.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				Intent intent = new Intent(ActivityPermission.this,ActivityPermission_Go.class);
//				intent.
				startActivity(intent);
			}});
	}
}
