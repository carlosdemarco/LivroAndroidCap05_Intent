package br.livro.android.cap5.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.livro.android.cap5.R;

/**
 * Abrir o mapa no endereço indicado
 * 
 * @author rlecheta
 * 
 */
public class AbrirMapaEnderecoActivity extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.form_endereco);

		final Button button = (Button) findViewById(R.id.botaoOk);
		button.setOnClickListener(this);

	}

	/**
	 * @see android.view.View$OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View view) {

		EditText campoEndereco = (EditText) findViewById(R.id.campoEndereco);

		String endereco = campoEndereco.getText().toString();

		// Substitui o espaço por + para formar um endereço válido
		endereco = endereco.replace(' ', '+');

		String GEO_URI = "geo:0,0?q=";

		//Cria a URI para abrir o mapa
		Uri uriGeo = Uri.parse(GEO_URI + endereco);

		Intent it = new Intent(android.content.Intent.ACTION_VIEW, uriGeo);

		//envia a mensagem ao sistema operacional
		startActivity(it);
	}
}
