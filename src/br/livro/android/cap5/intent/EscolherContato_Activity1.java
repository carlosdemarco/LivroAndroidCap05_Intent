package br.livro.android.cap5.intent;

import br.livro.android.cap5.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * Exemplo que utiliza uma Intent para abrir uma outra Activity
 * 
 * A segunda Activity exibe uma lista com os contatos.
 * 
 * O contato escolhido é exibido aqui.
 * 
 * @author ricardo
 * 
 */
public class EscolherContato_Activity1 extends Activity implements OnClickListener {

	private static final String CATEGORIA = "livro";
	private static final int BUSCA_CONTATO = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tela_visualizar_contatos);

		Button b = (Button) findViewById(R.id.botaoOk);
		b.setOnClickListener(this);
	}

	public void onClick(View view) {
		Intent it = new Intent(this, EscolherContato_Activity2.class);

		//Envia a mensagem/solicitação "Intent" para o sistema operacional
		startActivityForResult(it,BUSCA_CONTATO);
	}

	@Override
	protected void onActivityResult(int codigo, int resultado, Intent it) {
		super.onActivityResult(codigo, resultado, it);

		if (codigo == BUSCA_CONTATO) {

			if(it == null){
				Toast.makeText(this, "Nenhum contato", Toast.LENGTH_SHORT).show();
				return;
			}

			Bundle params = it.getExtras();

			String nome = params.getString("nome");
			Log.i(CATEGORIA,"Nome: " + nome);

			//exibe um alerta com o contato escolhido
			Toast.makeText(this, "Você escolheu: " + nome,Toast.LENGTH_SHORT).show();
		}
	}
}