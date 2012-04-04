package br.livro.android.cap5.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.livro.android.cap5.R;

/**
 * Exemplo de Activity que verifica se a Intent que a chamou informou algum parâmetro
 * 
 * @author ricardo
 *
 */
public class ExemploTelaSimNao extends Activity {
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.tela_sim_nao);

		//Sim
		Button sim = (Button) findViewById(R.id.btSim);
		sim.setText("Sim");
		sim.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				//Cria a Intent
				Intent it = new Intent();
				//Seta a mensagem de retorno
				it.putExtra("msg","Clicou em Sim !");
				//Seta o status do resultado e a Intent
				setResult(1,it);
				//Fim desta activity
				finish();
			}});

		//Nao
		Button nao = (Button) findViewById(R.id.btNao);
		nao.setText("Não");
		nao.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				//Cria a Intent
				Intent it = new Intent();
				//Seta a mensagem de retorno
				it.putExtra("msg","Clicou em Não !");
				//Seta o status do resultado e a Intent
				setResult(2,it);
				//Fim desta activity
				finish();
			}});
	}
}
