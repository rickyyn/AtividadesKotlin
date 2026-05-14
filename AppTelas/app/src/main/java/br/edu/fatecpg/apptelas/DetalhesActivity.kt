package br.edu.fatecpg.apptelas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvTitulo = findViewById<TextView>(R.id.txvTitulo)
        val txvAutor = findViewById<TextView>(R.id.txvAutor)

        val titulo = intent.getStringExtra("TITULO")
        val autor = intent.getStringExtra("AUTOR")

        txvTitulo.text = titulo
        txvAutor.text = autor
    }
}