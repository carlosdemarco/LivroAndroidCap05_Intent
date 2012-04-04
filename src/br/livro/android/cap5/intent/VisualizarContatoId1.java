package br.livro.android.cap5.intent;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/**
 * Exemplo que visualiza o contato de id = 1
 * 
 * @author ricardo
 * 
 */
public class VisualizarContatoId1 extends BaseButtonActivity {

	/**
	 * @see br.livro.android.cap5.intent.BaseButtonActivity#getTexto()
	 */
	protected String getTexto() {
		return "Visualizar o contato de id = 1";
	}

	/**
	 * @see android.view.View$OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View view) {
		//Visualizar o Contato id=1
		//Uri uri = Uri.parse("content://contacts/people/1");
		Uri uri = Uri.parse("content://com.android.contacts/contacts/1");

		Intent intent = new Intent(Intent.ACTION_VIEW,uri);

		//envia a mensagem ao sistema operacional
		startActivity(intent);

	}
}