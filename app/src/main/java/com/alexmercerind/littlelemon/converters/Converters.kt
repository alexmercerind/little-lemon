import com.alexmercerind.littlelemon.api.dto.MenuItem
import com.alexmercerind.littlelemon.db.entities.CacheMenuItem

fun MenuItem.toCacheMenuItem() = CacheMenuItem(id, title, description, price, image, category)

fun CacheMenuItem.toMenuItem() = MenuItem(id, title, description, price, image, category)
