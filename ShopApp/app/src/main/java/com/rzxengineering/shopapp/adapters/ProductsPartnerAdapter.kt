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
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.objects.Like
import com.rzxengineering.shopapp.viewmodels.LikeViewModel
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import kotlin.collections.ArrayList

class ProductsPartnerAdapter(private val productsList:ArrayList<Product>, val c: Context,
                             adapOnProductPartnerListener: OnProductPartnerListener, idClient:Int, owner:Fragment,
                             viewLyfeCycleOwner: LifecycleOwner):
    RecyclerView.Adapter<ProductsPartnerAdapter.MyViewHolder>() {

    var adapOnProductListener= adapOnProductPartnerListener
    var owner= owner
    var idClient=idClient
    var viewLifecycleOwner= viewLyfeCycleOwner
    lateinit var likeVM: LikeViewModel
    class MyViewHolder(v: View, onProductPartnerListener: OnProductPartnerListener): RecyclerView.ViewHolder(v),
            View.OnClickListener {
        var image: ImageView
        var nameTv: TextView
        var priceTv: TextView
        var saleTv: TextView
        var existenceTv: TextView
        var soldTv: TextView
        var like : ImageView
        var viewHolderOnProductPartnerListener: OnProductPartnerListener

        init {
            this.viewHolderOnProductPartnerListener = onProductPartnerListener
            image = v.findViewById(R.id.productPartnerCardIV)
            nameTv= v.findViewById(R.id.productNamePartnerCardTV)
            priceTv = v.findViewById(R.id.priceProductPartnerCardTV)
            saleTv = v.findViewById(R.id.saleProductPartnerCardTV)
            existenceTv = v.findViewById(R.id.unitsExistencePartnerCardTv)
            soldTv = v.findViewById(R.id.unitsSoldPartnerCardTv)
            like  = v.findViewById(R.id.likeProductPartnerCard)
            v.setOnClickListener(this)
        }
        override fun onClick(v:View?){

                viewHolderOnProductPartnerListener.onProductPartnerClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val inflate = LayoutInflater.from(parent.context)
        val v= inflate.inflate(R.layout.product_partner_card, parent, false)
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
        holder.existenceTv.text= String.format(res.getString(R.string.unitsInExistenceInsert),
            item.unitsInExistence)
        holder.soldTv.text= String.format(res.getString(R.string.unitsSoldInsert),
            item.unitsSold)
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

    interface OnProductPartnerListener{
        fun onProductPartnerClick(position:Int)
    }

}