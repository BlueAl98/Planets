package com.example.planets.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planets.PlanetData
import com.example.planets.PlanetDetail
import com.example.planets.R
import kotlinx.android.synthetic.main.item_recycler.view.*

class MyAdapter(var planet:List<PlanetData>): RecyclerView.Adapter<MyAdapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title = view.title
        var planetimg = view.planet_img
        var galaxy = view.galaxy
        var gravity = view.gravity
        var distance = view.distance



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        var dummyImage : Int?=null


        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, PlanetDetail::class.java)
            intent.putExtra("data",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)
        }


        holder.title.text = planet[position].title
        holder.distance.text = planet[position].distance+" m km"
        holder.galaxy.text = planet[position].galaxy
        holder.gravity.text = planet[position].gravity+" m/s"


        when(planet[position].title!!.toLowerCase())
        {
            "mars" -> {
                dummyImage = R.drawable.ic_mars
            }
            "neptune" -> {
                dummyImage = R.drawable.ic_neptune
            }
            "earth" -> {
                dummyImage = R.drawable.ic_earth
            }
            "venus" -> {
                dummyImage = R.drawable.ic_venus
            }
            "uranus" -> {
                dummyImage = R.drawable.ic_uranus
            }
            "jupiter" -> {
                dummyImage = R.drawable.ic_jupiter
            }
            "saturn" -> {
                dummyImage = R.drawable.ic_saturn
            }
            "mercury" -> {
                dummyImage = R.drawable.ic_mercury
            }
            "sun" -> {
                dummyImage = R.drawable.ic_sun
            }

            "moon" -> {
                dummyImage = R.drawable.ic_moon
            }


        }

        holder.planetimg.setImageResource(dummyImage!!)

    }

    override fun getItemCount(): Int {
        return planet.size
    }

}


