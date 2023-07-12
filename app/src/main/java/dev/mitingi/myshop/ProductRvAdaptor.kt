package dev.mitingi.myshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import dev.mitingi.myshop.databinding.ProductlistBinding

class ProductRvAdaptor ( var productList: List<Products>):RecyclerView.Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var binding=ProductlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
var product=productList[position]
        var binding=holder.binding
         binding.ivimage1.toString()
         binding.tvtitle1.text=product.title
       binding.tvdescription.text=product.category
       binding.tvprice1.text=product.price.toString()
      binding.tvStock.text= product.stock.toString()


        Picasso.get()
            .load(product.thumbnail)
            .into(binding.ivimage1)




    }

    override fun getItemCount(): Int {
      return productList.size
    }

}
class ProductViewHolder(var binding: ProductlistBinding ):ViewHolder(binding.root){


}
