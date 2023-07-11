package dev.mitingi.myshop

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("/product")
    fun getProducts():Call<ProductsResponse>
    @GET("/product/{id}")
    fun getProductById(@Path("id") productsId:Int):Call<Products>
    @POST("/product/{id}")
    fun getProductsById(@Body products: Products):Call<Products>

}