package br.livro.android.cap5.intent;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import br.livro.android.cap5.R;

/**
 * Exemplo de ListActivity que utiliza o SimpleCursorAdapter
 * para enviar os dados do Cursor de contatos para uma view definida em XML
 * 
 * @author ricardo
 *
 */
public class EscolherContato_Activity2 extends ListActivity {
	private ListAdapter adapter;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        //Recupera o cursor dos contatos
        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        startManagingCursor(c);

        //Listar o nome e telefone do contato
        String[] campos = new String[]{ContactsContract.Contacts.DISPLAY_NAME};
        int[] ids = new int[]{R.id.nome};

        //Informe o adapter para ligar os valores ao XML da View
        adapter = new SimpleCursorAdapter(this, R.layout.layout_contatos, c, campos, ids);

        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //Recupera o cursor na posição selecionada
        Cursor c = (Cursor) adapter.getItem(position);

        //Lê o Nome do contato
        String nome = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));

        //Cria o bundle para retornar o nome...
        Bundle params = new Bundle();
        params.putString("nome",nome);

        Intent itRetorno = new Intent();
        itRetorno.putExtras(params);

        setResult(RESULT_OK, itRetorno);

        //Termina esta Activity retornando o resultado
        finish();
    }
}
