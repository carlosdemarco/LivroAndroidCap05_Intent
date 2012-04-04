package br.livro.android.cap5.intent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Exemplo de Activity que verifica se a Intent que a chamou informou algum parâmetro
 * 
 * @author ricardo
 *
 */
public class Tela2 extends Activity {

	private static final String TAG = "ID";

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		Bundle extras = getIntent().getExtras();
		if(extras != null){
			//Alguém passou algum parâmetro para esta Intent usando o intent.putExtra(chave,valor)

			String mensagem = extras.getString("mensagem");

			TextView text = new TextView(this);
			text.setText("A mensagem passada foi: " + mensagem);
			setContentView(text);

		} else {
			TextView text = new TextView(this);
			text.setText("Esta é a Activity 2");
			setContentView(text);
		}
	}
	
	protected void onCreate() {
		super.onStart();
		Log.i(TAG, "Tela2.onCreate() chamado.");
	}
	
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "Tela2.onStart() chamado.");
	}

	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "Tela2.onRestart() chamado.");
	}

	protected void onResume() {
		super.onResume();
		Log.i(TAG, "Tela2.onResume() chamado.");
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(TAG, "Tela2.onSaveInstanceState() chamado.");
	}

	protected void onPause() {
		super.onPause();
		Log.i(TAG, "Tela2.onPause() chamado.");
	}

	protected void onStop() {
		super.onStop();
		Log.i(TAG, "Tela2.onStop() chamado.");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "Tela2.onDestroy() chamado.");
	}
}
