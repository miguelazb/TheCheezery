package zamorano.miguel.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var intent = Intent(this,ProductsActivity::class.java)
        btn_cold_drinks.setOnClickListener({
            intent.putExtra("type", "coldDrinks")
            startActivity(intent)
        })
        btn_hot_drinks.setOnClickListener({
            intent.putExtra("type", "hotDrinks")
            startActivity(intent)
        })
        btn_sweets.setOnClickListener({
            intent.putExtra("type", "sweets")
            startActivity(intent)
        })
        btn_salties.setOnClickListener({
            intent.putExtra("type", "salties")
            startActivity(intent)
        })
        btn_combos.setOnClickListener({
            intent.putExtra("type", "combos")
            startActivity(intent)
        })
        btn_personalized.setOnClickListener({
            intent.putExtra("type", "personalized")
            startActivity(intent)
        })

    }
}
