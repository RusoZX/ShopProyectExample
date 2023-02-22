package com.rzxengineering.shopapp.adapters

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.objects.SaleOrRestock
import kotlin.collections.ArrayList

class BuysAndRestocksAdapter (private val productsList:ArrayList<SaleOrRestock>, val c: Context,
                              adapOnBuyAndRestocksListener: OnBuyAndRestocksListener):
    RecyclerView.Adapter<BuysAndRestocksAdapter.MyViewHolder>() {

    var adapOnBuyListener= adapOnBuyAndRestocksListener

    class MyViewHolder(v: View, onBuyAndRestocksListener: OnBuyAndRestocksListener): RecyclerView.ViewHolder(v),
        View.OnClickListener {
        var image: ImageView
        var nameTv: TextView
        var quantityTv: TextView
        var dateTv: TextView
        var viewHolderOnBuyAndRestocksListener: OnBuyAndRestocksListener

        init {
            this.viewHolderOnBuyAndRestocksListener = onBuyAndRestocksListener
            image = v.findViewById(R.id.buyImageView)
            nameTv= v.findViewById(R.id.buyNameTv)
            quantityTv = v.findViewById(R.id.buyQuantityTv)
            dateTv = v.findViewById(R.id.buyDateTv)
            v.setOnClickListener(this)
        }
        override fun onClick(v: View?){

            viewHolderOnBuyAndRestocksListener.onBuyAndRestockClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val inflate = LayoutInflater.from(parent.context)
        val v= inflate.inflate(R.layout.buy_restock_card, parent, false)
        return MyViewHolder(v,adapOnBuyListener)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var res: Resources = c.resources
        val item = productsList[position]

        var bmp = BitmapFactory.decodeByteArray(item.image, 0, item.image.size)

        holder.nameTv.text= String.format(res.getString(R.string.nameInsert),item.name)

        holder.quantityTv.text= String.format(res.getString(R.string.quantityShp),item.quantity)
        holder.dateTv.text= String.format(res.getString(R.string.dateIns),item.date)
        holder.image.setImageBitmap(bmp)
        //Here we will se if the product is liked by the user and change the liked image


        }

    interface OnBuyAndRestocksListener{
        fun onBuyAndRestockClick(position:Int)
    }

}