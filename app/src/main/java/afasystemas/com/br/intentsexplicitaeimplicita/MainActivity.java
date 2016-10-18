package afasystemas.com.br.intentsexplicitaeimplicita;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends  AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                Toast.makeText(MainActivity.this, "Menu Principal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contato:
                Toast.makeText(MainActivity.this, "Contato Selecionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.intentExplicito:

                Intent intent  = new Intent(this.getApplication(),IntentExplicita.class);
                Bitmap _bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.androi);; // your bitmap
                ByteArrayOutputStream _bs = new ByteArrayOutputStream();
                _bitmap.compress(Bitmap.CompressFormat.PNG, 50, _bs);
                intent.putExtra("imagem", _bs.toByteArray());

                startActivity(intent);
                break;
            case R.id.intentImplicito:

                Intent i = new Intent (Intent.ACTION_VIEW , Uri.parse("http://musicadede.github.io/criandopenseclick/"));
                startActivity(i);

                break;
            case R.id.sair:
                Toast.makeText(MainActivity.this, "Saindo da Aplicação", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
