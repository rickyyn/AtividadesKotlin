package br.edu.fatecpg.appui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.catalogoprodutoui.R

class ProdutoAdapter(private var listaProdutos: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProduto: ImageView = view.findViewById(R.id.img_produto)
        val txtNome: TextView = view.findViewById(R.id.txt_nome)
        val txtPreco: TextView = view.findViewById(R.id.txt_preco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProdutos[position]
        holder.txtNome.text = produto.nome
        holder.txtPreco.text = "R$ ${"%.2f".format(produto.preco)}"
        holder.imgProduto.setImageResource(produto.imagemResId)
    }

    override fun getItemCount(): Int = listaProdutos.size

    fun atualizarLista(novaLista: List<Produto>) {
        listaProdutos = novaLista
        notifyDataSetChanged()
    }
}
