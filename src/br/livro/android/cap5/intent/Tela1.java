package br.livro.android.cap5.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tela1 extends Activity implements OnClickListener {
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		// Cria o layout
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layout.setLayoutParams(layoutParams);
		TextView label = new TextView(this);
		label.setText("Exemplo startActivity com um Intent.");
		layout.addView(label, layoutParams);
		Button button = new Button(this);
		button.setText("Clique aqui para abrir outra Activity");
		button.setOnClickListener(this);
		layout.addView(button, layoutParams);
		setContentView(layout);
	}

	public void onClick(View v) {
		Intent it = new Intent(this, Tela2.class);
		startActivity(it);
	}
}
