package zamorano.miguel.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.item_product.view.*


class ProductsActivity : AppCompatActivity() {
    var productosAdapter: ProductAdapter? = null
    var productos =  ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val bundle = intent.extras
        if(bundle!=null){
            when(bundle.getString("type")){
                "coldDrinks" -> {
                    cargarColdDrinks()
                    title_products.setImageResource(R.drawable.cold_drinks)
                }
                "hotDrinks" -> {
                    cargarHotDrinks()
                    title_products.setImageResource(R.drawable.hot_drinks)
                }
                "sweets" -> {
                    cargarSweets()
                    title_products.setImageResource(R.drawable.sweets)
                }
                "salties" -> {
                    cargarSalties()
                    title_products.setImageResource(R.drawable.salties)
                }
                "combos" -> {
                    // cargarCombos()
                    // title_products.setImageResource(R.drawable.combos)
                    title_products.setImageResource(R.drawable.title)

                }
                "personalized" -> {
                    // cargarPersonalized()
                    // title_products.setImageResource(R.drawable.personalized)
                    title_products.setImageResource(R.drawable.title)

                }
            }

        }

        productosAdapter = ProductAdapter(this,productos)
        products_list.adapter = productosAdapter


    }

    fun cargarColdDrinks(){
        productos.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5))
        productos.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6))
        productos.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3))
        productos.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4))
        productos.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7))
        productos.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7))
    }

    fun cargarHotDrinks() {
        productos.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6))
        productos.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5))
        productos.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4))
        productos.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6))
        productos.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7))
        productos.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2))
    }

    fun cargarSweets() {
        productos.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6))
        productos.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3))
        productos.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4))
        productos.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6))
        productos.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7))
        productos.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6))
    }

    fun cargarSalties() {
        productos.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6))
        productos.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5))
        productos.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread served warmed by grilling.", 4))
        productos.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6))
        productos.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.", 7))

    }


    class ProductAdapter: BaseAdapter {
        var context: Context? =null
        var products =  ArrayList<Product>()

        constructor(context: Context, products: ArrayList<Product>){
            this.context = context
            this.products = products
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod= products[position]
            var inflator = LayoutInflater.from(context)
            var vista = inflator.inflate(R.layout.item_product, null)

//            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            var vista = inflator.inflate(R.layout.item_product, null)
            vista.product_image.setImageResource(prod.image)
            vista.product_name.setText(prod.name)
            vista.product_description.setText(prod.description)
            vista.product_price.setText("$${prod.price}")
/*
            vista.image_movie_cell.setOnClickListener{
                var intento = Intent(context, MovieDetail::class.java)
                intento.putExtra("titulo",cd.titulo)
                intento.putExtra("sinopsis",cd.sinopsis)
                intento.putExtra("header",cd.header)
                intento.putExtra("image",cd.image)
                context!!.startActivity(intento)
            }
*/
            return vista

        }

        override fun getItem(position: Int): Any {
            return products[position]
        }

        override fun getItemId(position: Int): Long {
            return 1
        }

        override fun getCount(): Int {
            return products.size
        }

    }


}
