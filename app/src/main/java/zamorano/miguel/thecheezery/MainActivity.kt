package zamorano.miguel.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val boton: Button = findViewById(R.id.botonp);
        boton.setOnClickListener({
            val intent: Intent = Intent(this,HomeActivity::class.java);
            startActivity(intent);
        });
    }
}
