package br.livro.android.cap5;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import br.livro.android.cap5.intent.AbrirMapaEnderecoActivity;
import br.livro.android.cap5.intent.EscolherContato_Activity1;
import br.livro.android.cap5.intent.ExemploAbrirBrowser;
import br.livro.android.cap5.intent.ExemploTelaSimNao;
import br.livro.android.cap5.intent.LigarParaTelefoneActivity;
import br.livro.android.cap5.intent.Tela2;
import br.livro.android.cap5.intent.VisualizarTodosContatos;

/**
 * Exemplos de Intents para abrir o browser, fazer liga��es, etc
 * 
 * @author rlecheta
 * 
 */
public class Menu extends ListActivity {
	private static final String CATEGORIA = "livro";

	//Para identificar a chamada no m�todo onActivityResult
	private static final int ACTIVITY_SIM_NAO = 1;
	private static final int ACTIVITY_CALCULADORA = 3;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setTheme(android.R.style.Theme_Light);

		String[] mStrings = new String[] {
				"Abrir Activity c/ parâmetros", 
				"Activity retorna informação",
				"Abrir Browser",
				"Retornar resultado de uma Activity",
				"Abrir Mapa no endereço",
				"Ligar para telefone",
				"Visualizar Contato 1",
				"Visualizar Todos Contatos",
				"Gravar Som",
				"Chamar Calculadora e obter Resultado",
				"Sair"};

		this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		switch (position) {
			case 0:
				Intent intent = new Intent(this,Tela2.class);
				intent.putExtra("mensagem", "Mensagem de teste para a Intent !");
				startActivity(intent);
				break;
			case 1:
				//A ActivitySimNao retorna se clicou no botão Sim ou Não
				//Utiliza o método startActivityForResult()
				//método
				startActivityForResult(new Intent(this,ExemploTelaSimNao.class),ACTIVITY_SIM_NAO);
				break;
			case 2:
				startActivity(new Intent(this,ExemploAbrirBrowser.class));
				break;
			case 3:
				startActivity(new Intent(this,EscolherContato_Activity1.class));
				break;
			case 4:
				startActivity(new Intent(this,AbrirMapaEnderecoActivity.class));
				break;
			case 5:
				startActivity(new Intent(this,LigarParaTelefoneActivity.class));
				break;
			case 6:
				//Visualizar o Contato 1 da lista de contatos
				Uri uri = Uri.parse("content://com.android.contacts/contacts/1");

				//envia a mensagem ao sistema operacional
				startActivity(new Intent(Intent.ACTION_VIEW,uri));
				break;
			case 7:
				//ACTION_PICK
				startActivity(new Intent(this,VisualizarTodosContatos.class));
				break;
			case 8:
				// Gravar Som
				// "android.provider.MediaStore.RECORD_SOUND"
				startActivityForResult(new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION), 2);

				break;
			case 9:
				Intent intentCalc = new Intent();
				intentCalc.setAction("android.intent.action.MAIN");
				intentCalc.addCategory("android.intent.category.LAUNCHER");
				intentCalc.setComponent(new ComponentName("com.android.calculator2","com.android.calculator2.Calculator"));
				startActivityForResult(intentCalc,ACTIVITY_CALCULADORA);
				break;
			default:
				finish();
		}
	}

	@Override
	protected void onActivityResult(int codigo, int resultado,Intent it) {
		Log.i(CATEGORIA,"Menu.onActivityResult: " + codigo + ", resultado: " + resultado + " > " + it);
		if (codigo == ACTIVITY_SIM_NAO) {
			Bundle params = it != null ? it.getExtras(): null;
			if (params != null) {
				String msg = params.getString("msg");
				if (resultado == 1) {
					// Sim
					Toast.makeText(this, "Escolheu Sim: " + msg,Toast.LENGTH_SHORT).show();
				} else if (resultado == 2) {
					// Nao
					Toast.makeText(this, "Escolheu Não: " + msg,Toast.LENGTH_SHORT).show();
				} else {
					// cancelado talvez..
					Toast.makeText(this, "Não definido: " + msg,Toast.LENGTH_SHORT).show();
				}
			}
		} else if(codigo == 2){
			Log.i(CATEGORIA,""+it.getExtras());
		} else if(codigo == ACTIVITY_CALCULADORA){
			Log.i(CATEGORIA, "Calc voltou");
			Bundle params = it != null ? it.getExtras(): null;
			if (params != null) {
				Log.i(CATEGORIA, "Calc params: " + params.keySet());
				Toast.makeText(this, ">> " + params.keySet(),Toast.LENGTH_SHORT).show();
			} else {
				Log.i(CATEGORIA, "Calc no params");
			}
		}
	}
	
	protected void onStart() {
		super.onStart();
		Log.i(CATEGORIA, "onStart() chamado.");
	}

	protected void onRestart() {
		super.onRestart();
		Log.i(CATEGORIA, "onRestart() chamado.");
	}

	protected void onResume() {
		super.onResume();
		Log.i(CATEGORIA, "onResume() chamado.");
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(CATEGORIA, "onSaveInstanceState() chamado.");
	}

	protected void onPause() {
		super.onPause();
		Log.i(CATEGORIA, "onPause() chamado.");
	}

	protected void onStop() {
		super.onStop();
		Log.i(CATEGORIA, "onStop() chamado.");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.i(CATEGORIA, "onDestroy() chamado.");
	}
}