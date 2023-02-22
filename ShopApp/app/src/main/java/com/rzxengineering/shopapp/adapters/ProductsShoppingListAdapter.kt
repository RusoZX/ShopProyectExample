package com.rzxengineering.shopapp.adapters

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.objects.Like
import com.rzxengineering.shopapp.objects.ProductShoppingList
import com.rzxengineering.shopapp.viewmodels.LikeViewModel
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import kotlin.collections.ArrayList

class ProductsShoppingListAdapter(private val productsList:ArrayList<ProductShoppingList>, val c: Context,
                                  adapOnProductListener: OnProductListener, idClient:Int, owner:Fragment,
                                  viewLyfeCycleOwner: LifecycleOwner):
    RecyclerView.Adapter<ProductsShoppingListAdapter.MyViewHolder>() {

    var adapOnProductListener= adapOnProductListener
    var owner= owner
    var idClient=idClient
    var viewLifecycleOwner= viewLyfeCycleOwner
    lateinit var likeVM: LikeViewModel
    lateinit var isLikedList: ArrayList<Boolean>
    class MyViewHolder(v: View, onProductListener: OnProductListener): RecyclerView.ViewHolder(v),
            View.OnClickListener {
        var image: ImageView
        var nameTv: TextView
        var priceTv: TextView
        var saleTv: TextView
        var like : ImageView
        var quantity: TextView
        var finalPrice: TextView
        var viewHolderOnProductListener: OnProductListener

        init {
            this.viewHolderOnProductListener = onProductListener
            image = v.findViewById(R.id.productShpCardIV)
            nameTv= v.findViewById(R.id.productNameShpCardTV)
            priceTv = v.findViewById(R.id.priceProductShpCardTV)
            saleTv = v.findViewById(R.id.saleProductShpCardTV)
            like  = v.findViewById(R.id.likeProductShpCard)
            quantity = v.findViewById(R.id.quantityProductShpTv)
            finalPrice=v.findViewById(R.id.finalPriceProductShpTv)
            v.setOnClickListener(this)
        }
        override fun onClick(v:View?){

                viewHolderOnProductListener.onProductClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val inflate = LayoutInflater.from(parent.context)
        val v= inflate.inflate(R.layout.product_shopping_list_card, parent, false)
        return MyViewHolder(v,adapOnProductListener)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var res: Resources= c.resources
        val item = productsList[position]

        var bmp = BitmapFactory.decodeByteArray(item.image, 0, item.image.size)

        holder.nameTv.text= String.format(res.getString(R.string.blankInsert),item.name)
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        holder.priceTv.text= String.format(res.getString(R.string.priceInsert),df.format(item.price*
                (1.00-item.sale/100)))
        holder.saleTv.text= String.format(res.getString(R.string.saleInsert),item.sale)
        holder.quantity.text = String.format(res.getString(R.string.quantityShp),item.quantity)
        holder.finalPrice.text = String.format(res.getString(R.string.finalPrice), df.format(
            (item.price* (1.00-item.sale/100))*item.quantity))
        holder.image.setImageBitmap(bmp)
        //Here we will se if the product is liked by the user and change the liked image

        if(item.isLiked) {
            holder.like.setImageDrawable(res.getDrawable(R.drawable.fav_full))
            holder.like.contentDescription="liked"
        }else{
            holder.like.setImageDrawable(res.getDrawable(R.drawable.fav_empty))
            holder.like.contentDescription="notLiked"
        }
        //Here we will set a like if a user clicks the like image
        holder.like.setOnClickListener(){
            var calendar = Calendar.getInstance()
            likeVM= ViewModelProvider(owner)[LikeViewModel::class.java]
            if(item.isLiked)
            likeVM.setId(Like(0,idClient, item.id, "${calendar.get(Calendar.YEAR)}-" +
                    "${calendar.get(Calendar.MONTH)}-${calendar.get(Calendar.DAY_OF_MONTH)}"))
            else {
                likeVM.setId(
                    Like(
                        1, idClient, item.id, "${calendar.get(Calendar.YEAR)}-" +
                                "${calendar.get(Calendar.MONTH)}-${calendar.get(Calendar.DAY_OF_MONTH)}"
                    )
                )
                Log.d("Paso por este aro papa","Likeado")
            }
            likeVM.response.observe(viewLifecycleOwner){
                Log.d("--likeado---",item.id.toString()+"-"+it.response.toString())
                if(it.response==0&&item.isLiked) {
                    holder.like.setImageDrawable(res.getDrawable(R.drawable.fav_empty))
                    holder.like.contentDescription="notLiked"
                }else if(it.response==4){
                    holder.like.setImageDrawable(res.getDrawable(R.drawable.fav_full))
                    holder.like.contentDescription="liked"
                }else
                    alert(res.getString(R.string.alertServerError))
            }
        }
    }

    fun alert(msj:String?){
        val alert = AlertDialog.Builder(c)
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(msj)
        alert.setPositiveButton(R.string.back) { dialogInterface, i ->

        }
        alert.show()
    }

    interface OnProductListener{
        fun onProductClick(position:Int)
    }

}