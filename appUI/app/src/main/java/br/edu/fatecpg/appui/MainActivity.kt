package br.edu.fatecpg.appui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.catalogoprodutoui.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ProdutoAdapter
    private val todosProdutos = listOf(
        Produto("Smartphone", 1999.90, android.R.drawable.ic_menu_call, "eletronicos"),
        Produto("Notebook", 3500.00, android.R.drawable.ic_menu_gallery, "eletronicos"),
        Produto("Camiseta", 59.90, android.R.drawable.ic_menu_manage, "roupas"),
        Produto("Calça Jeans", 120.00, android.R.drawable.ic_menu_manage, "roupas"),
        Produto("O Senhor dos Anéis", 80.00, android.R.drawable.ic_menu_agenda, "livros"),
        Produto("Dom Casmurro", 30.00, android.R.drawable.ic_menu_agenda, "livros")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0) // Bottom handled by Nav
            insets
        }

        val rvProdutos = findViewById<RecyclerView>(R.id.rv_produtos)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        adapter = ProdutoAdapter(todosProdutos.filter { it.categoria == "eletronicos" })
        rvProdutos.layoutManager = LinearLayoutManager(this)
        rvProdutos.adapter = adapter

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_eletronicos -> {
                    filtrarProdutos("eletronicos")
                    true
                }
                R.id.nav_roupas -> {
                    filtrarProdutos("roupas")
                    true
                }
                R.id.nav_livros -> {
                    filtrarProdutos("livros")
                    true
                }
                else -> false
            }
        }
    }

    private fun filtrarProdutos(categoria: String) {
        val listaFiltrada = todosProdutos.filter { it.categoria == categoria }
        adapter.atualizarLista(listaFiltrada)
    }
}
