package dev.mitingi.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.LinearLayoutManager
import dev.mitingi.myshop.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var productRvAdaptor: ProductRvAdaptor
    var productList:List<Products> = emptyList()

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productRvAdaptor= ProductRvAdaptor(emptyList())
        binding.rvProducts.adapter=productRvAdaptor
    }

    override fun onResume() {
        super.onResume()
        fetchProducts()
    }
    fun fetchProducts(){
var apiclient=ApiClient.buildClient(ApiInterface::class.java)
        var request =apiclient.getProducts()
        request.enqueue(object:Callback<ProductsResponse>{
            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>) {

                if (response.isSuccessful){

                    var products=response.body()?.products
                    var productRvAdaptor=ProductRvAdaptor(products?: emptyList())
                    binding.rvProducts.layoutManager=GridLayoutManager(this@MainActivity,2)
                    binding.rvProducts.adapter=productRvAdaptor

                    Toast.makeText(baseContext,"fetched ${products?.size} products",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })


    }
}