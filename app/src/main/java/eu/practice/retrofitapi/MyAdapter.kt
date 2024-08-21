package eu.practice.retrofitapi

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter (val context: Activity , val productArrayList: List<Product> )
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {
    class MyViewHolder( itemView : View) : RecyclerView.ViewHolder(  itemView) {

        val title : TextView
        val image :ShapeableImageView
        val price :TextView

        init {
            title = itemView.findViewById(R.id.prodName)
            image = itemView.findViewById(R.id.productImage)
            price = itemView.findViewById(R.id.productPrice)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem , parent , false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.price.text = "${currentItem.price} $"
        // image view , how to show the image in the image view if the image is in the url , 3rd party library
        // picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image)


    }


}