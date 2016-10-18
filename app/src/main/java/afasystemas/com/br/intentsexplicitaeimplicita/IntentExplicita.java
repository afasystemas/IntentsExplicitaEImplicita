package afasystemas.com.br.intentsexplicitaeimplicita;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

public class IntentExplicita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_explicita);

        ImageView i = (ImageView) findViewById(R.id.imagem);

        if(getIntent().hasExtra("imagem")) {
            Bitmap _bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("imagem"), 0, getIntent().getByteArrayExtra("imagem").length);
            i.setImageBitmap(_bitmap);
            System.out.println(getIntent().getByteArrayExtra("imagem"));
            Toast.makeText(IntentExplicita.this, "Imagem Recebida na Intent Explicita", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(IntentExplicita.this, "Imagem Nao encontrada", Toast.LENGTH_SHORT).show();
        }

    }
}
