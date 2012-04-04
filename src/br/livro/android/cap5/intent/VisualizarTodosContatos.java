package br.livro.android.cap5.intent;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import br.livro.android.cap5.R;

/**
 * Exemplo que visualiza os contatos da agenda.
 * 
 * Depois de escolher um contato exibe o nome em uma alerta.
 * 
 * @author ricardo
 * 
 */
public class VisualizarTodosContatos extends Activity implements OnClickListener {
	// Constante para identificar a sub-activity lançada
	private static final int SELECIONAR_CONTATO = 1;
	private static final String CATEGORIA = "livro";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tela_visualizar_contatos);

		Button button = (Button) findViewById(R.id.botaoOk);
		button.setOnClickListener(this);
	}

	/**
	 * @see android.view.View$OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View view) {
		// Visualizar o Contato 1 da lista de contatos
		//"content://contacts/people/"
		Uri uri = Uri.parse("content://com.android.contacts/contacts/");
//		Uri uri = ContactsContract.Contacts.CONTENT_URI;

		// Cria a Intent
		Intent it = new Intent(Intent.ACTION_PICK,uri);

		// Envia a mensagem assíncrona ao sistema operacional
		startActivityForResult(it,SELECIONAR_CONTATO); 	
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent it) {
		//imprimirNome(intent);

		if(it == null){
			Toast.makeText(this, "Nenhum contato", Toast.LENGTH_SHORT).show();
			return;
		}

		// URI que identifica o contato
		Uri uri = it.getData();

		Toast.makeText(this, "Contato: " + uri, Toast.LENGTH_SHORT).show();

		// Solicita o Android para visualizar o contato
		startActivity(new Intent(Intent.ACTION_VIEW,uri)); 

/*		imprimirNome(it);
		
		// Busca o contato no banco de dados
		Cursor c = managedQuery(uri, null, null, null, null);
		
		c.moveToNext();
			
		// Recupera o nome do contato
		String[] s = c.getColumnNames();
		if(s != null){
			for (int i = 0; i < s.length; i++) {
				Log.i(CATEGORIA,String.valueOf(s[i]));
				String valor = c.getString(c.getColumnIndexOrThrow(s[i]));
				Log.i(CATEGORIA,valor!=null?valor:"?");
			}
		}*/
	}

	private void imprimirNome(Intent it) {
		// Visualizar o Contato selecionado

		Uri uri = it.getData();
		
		Log.i(CATEGORIA,"Visualizando contato: " + uri);

		// Busca o contato no banco de dados
		Cursor c = managedQuery(uri, null, null, null, null);
		
		c.moveToNext();
			
		// Recupera o nome do contato
		String[] s = c.getColumnNames();
		if(s != null){
			for (int i = 0; i < s.length; i++) {
				Log.i(CATEGORIA,String.valueOf(s[i]));
				String valor = c.getString(c.getColumnIndexOrThrow(s[i]));
				Log.i(CATEGORIA,valor!=null?valor:"?");
			}
		}
		
		// Coluna: display_name
		int index = c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME); 

		//int index = c.getColumnIndexOrThrow("primary_email");
//		Log.i(TAG,"index primary_email : " + index);
		
		String nome = c.getString(index);

		Toast.makeText(this, "Nome: " + nome, Toast.LENGTH_SHORT).show();
	}

}