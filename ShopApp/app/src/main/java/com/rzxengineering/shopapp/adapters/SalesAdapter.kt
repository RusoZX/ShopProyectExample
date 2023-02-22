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

class SalesAdapter (private val salesList:ArrayList<SaleOrRestock>, val c: Context,
                    adapOnSaleListener: OnSaleListener):
    RecyclerView.Adapter<SalesAdapter.MyViewHolder>() {

    var adapOnSaleListener= adapOnSaleListener

    class MyViewHolder(v: View, onBuyAndRestocksListener: OnSaleListener): RecyclerView.ViewHolder(v),
        View.OnClickListener {
        var image: ImageView
        var nameTv: TextView
        var quantityTv: TextView
        var dateTv: TextView
        var buyerName: TextView
        var viewHolderOnSaleListener: OnSaleListener

        init {
            this.viewHolderOnSaleListener = onBuyAndRestocksListener
            image = v.findViewById(R.id.saleCardImageView)
            nameTv= v.findViewById(R.id.saleCardNameTv)
            quantityTv = v.findViewById(R.id.saleCardQuantityTv)
            dateTv = v.findViewById(R.id.saleCardDateTv)
            buyerName= v.findViewById(R.id.saleCardBuyerNameTv)
            v.setOnClickListener(this)
        }
        override fun onClick(v: View?){

            viewHolderOnSaleListener.onSaleClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val inflate = LayoutInflater.from(parent.context)
        val v= inflate.inflate(R.layout.sale_card, parent, false)
        return MyViewHolder(v,adapOnSaleListener)
    }

    override fun getItemCount(): Int {
        return salesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var res: Resources = c.resources
        val item = salesList[position]

        var bmp = BitmapFactory.decodeByteArray(item.image, 0, item.image.size)

        holder.nameTv.text= String.format(res.getString(R.string.nameInsert),item.name)

        holder.quantityTv.text= String.format(res.getString(R.string.quantityShp),item.quantity)
        holder.dateTv.text= String.format(res.getString(R.string.dateIns),item.date)
        holder.buyerName.text = String.format(res.getString(R.string.buyerName),item.buyerName)
        holder.image.setImageBitmap(bmp)
        }

    interface OnSaleListener{
        fun onSaleClick(position:Int)
    }

}