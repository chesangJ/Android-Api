package dev.mitingi.myshop

data class ProductsResponse(
    var products: List<Products>,
    var total:Int,
    var skip:Int,
    var limit:Int

)
