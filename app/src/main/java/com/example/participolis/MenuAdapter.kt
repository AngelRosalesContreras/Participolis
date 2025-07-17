// MenuAdapter.kt
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.participolis.InfoLugares
import com.example.participolis.MenuItem
import com.example.participolis.R

class MenuAdapter(private val context: Context, private val menuItems: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        val currentMenuItem = menuItems[position]
        holder.menuIcon.setImageResource(currentMenuItem.icon)
        holder.menuTitle.text = currentMenuItem.title

        // Agregar listener de clics
        holder.itemView.setOnClickListener {
            // Obtener el elemento del menú seleccionado
            val selectedMenuItem = menuItems[position]
            // Iniciar el activity correspondiente
            val intent = Intent(context, InfoLugares::class.java)
            // Puedes pasar datos adicionales al activity si es necesario
            intent.putExtra("menuItemTitle", selectedMenuItem.title)
            intent.putExtra("menuItemImage", selectedMenuItem.icon) // Aquí agregamos la imagen
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = menuItems.size

    inner class MenuItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menuIcon: ImageView = itemView.findViewById(R.id.imageViewMenuIcon)
        val menuTitle: TextView = itemView.findViewById(R.id.textViewMenuTitle)
    }
}
