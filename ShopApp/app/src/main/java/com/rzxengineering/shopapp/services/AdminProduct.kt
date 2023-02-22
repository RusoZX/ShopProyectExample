package com.rzxengineering.shopapp.services

import android.util.Log
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.objects.ProductShoppingList
import com.rzxengineering.shopapp.objects.ServerResponse
import com.rzxengineering.shopapp.objects.ShoppingListRequest
import generated.*
import io.grpc.ManagedChannel

class AdminProduct {
    var channel : ManagedChannel = Conexion().channel!!
    fun giveProduct(id:Int): Product{
        var stub= serviceProductGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionProduct.newBuilder().setIdProduct(id).build()
        var response = stub.giveResponseProduct(request)
        var product= Product(0,-1,-1,"",-1f,-1,-1,
            -1,-1, ByteArray(1),"", false
        )
        if(response.statusCodeValue==1)
            product.statusCode=1
        else {
            product.id = response.id
            product.owner = response.owner
            product.name=response.name
            product.price=response.price
            product.unitsInExistence=response.unitsInExistence
            product.unitsSold=response.unitsSold
            product.sale=response.sale
            product.format= response.formatValue
            product.image= response.image.toByteArray()
            product.category= response.category
        }
        return product
    }
    fun giveProducts(quantity:Int, sortingMode:Int, search:String, idUser: Int):ArrayList<Product>{
        Log.d("Ihave a problem","i dont know where it is")
        var stub= serviceProductsGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionProducts.newBuilder()
            .setQuantity(quantity)
            .setSortingModeValue(sortingMode)
            .setSearch(search)
            .setIdUser(idUser)
            .build()
        Log.d("Ihave a problem","i dont know where it 1")
        var result= stub.giveResponseProducts(request)
        var array= ArrayList<Product>()
        if (result.statusCodeValue==1){
            var product= Product(1,-1,-1,"",-1f,-1,
                -1, -1,-1,ByteArray(1),"", false)
            product.statusCode=1
            array.add(product)
        }else
            for(product in result.productsList){
                Log.d("Ihave a problem","i dont know where it 2")
                array.add(
                Product(0,product.id,product.owner,product.name,product.price,
                product.unitsInExistence,product.unitsSold,product.sale,product.formatValue,
                    product.image.toByteArray(), product.category, product.liked)
            )
        }

        return array
    }
    fun giveProductsPartner(quantity:Int, sortingMode:Int, search:String, idUser: Int):ArrayList<Product>{
        var stub= serviceProductsOwnerGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionProductsOwner.newBuilder()
            .setQuantity(quantity)
            .setSortingModeValue(sortingMode)
            .setSearch(search)
            .setIdOwner(idUser)
            .build()
        var result= stub.giveResponseProductsOwner(request)
        var array= ArrayList<Product>()
        if (result.statusCodeValue==1){
            var product= Product(1,-1,-1,"",-1f,-1,
                -1, -1,-1,ByteArray(1),"", false)
            product.statusCode=1
            array.add(product)
        }else
            for(product in result.productsList){
                array.add(
                    Product(0,product.id,product.owner,product.name,product.price,
                        product.unitsInExistence,product.unitsSold,product.sale,product.formatValue,
                        product.image.toByteArray(), product.category, product.liked)
                )
            }

        return array
    }
    fun addProduct(product:Product):ServerResponse{
        var stub = serviceAddProductGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionAddProduct.newBuilder()
            .setName(product.name)
            .setPrice(product.price)
            .setUnitsExistence(product.unitsInExistence)
            .setOwner(product.owner)
            .setImagePath("")
            .setCategory(product.category)
            .build()

        var response = stub.giveResponseAddProduct(request)
        return ServerResponse(response.statusCodeValue)
    }
    fun updateProduct(product: Product):ServerResponse{
        var stub = serviceUpdateProductGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionUpdateProduct.newBuilder()
            .setIdProduct(product.id)
            .setName(product.name)
            .setPrice(product.price)
            .setSale(product.sale)
            .build()
        var response = stub.giveResponseUpdateProduct(request)
        return ServerResponse(response.statusCodeValue)
    }
    fun giveCategories(change: Boolean):ArrayList<String>{
        var stub= serviceCategoriesGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionCategories.newBuilder().build()
        var response = stub.giveResponseCategories(request)
        var list :ArrayList<String> = ArrayList()
        for(string in response.categoriesList)
            list.add(string)
        return list
    }
    fun addToShoppingList(request:ShoppingListRequest): ServerResponse{
        var stub = serviceAddShoppingListGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionAddShoppingList.newBuilder()
            .setIdUser(request.idUser)
            .setIdProduct(request.idProduct)
            .setQuantity(request.quantity)
            .build()
        var response = stub.giveResponseAddShoppingList(request)
        return ServerResponse(response.statusCodeValue)
    }
    fun getShoppingList(idUser:Int):ArrayList<ProductShoppingList>{
        var stub = serviceShoppingListGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionShoppingList.newBuilder().setIdUser(idUser).build()
        var response= stub.giveResponseShoppingList(request)
        var result = ArrayList<ProductShoppingList>()
        for(product in response.productsList)
            result.add(ProductShoppingList(response.statusCodeValue,product.id,product.owner,
            product.name,product.price,product.unitsInExistence,product.unitsSold,product.sale,
            product.formatValue,product.image.toByteArray(),product.category,product.liked,
                product.quantity))
        return result
    }
}