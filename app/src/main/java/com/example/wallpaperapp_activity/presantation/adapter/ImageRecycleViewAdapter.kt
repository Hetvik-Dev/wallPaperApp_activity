package com.example.wallpaperapp_activity.presantation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp_activity.R
import com.example.wallpaperapp_activity.domain.entities.wallpaperLink

class imageRecycleViewAdapter(private var dataSet: List<wallpaperLink>) :
        RecyclerView.Adapter<imageRecycleViewAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder)
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imageVew : ImageView

            init {
                // Define click listener for the ViewHolder's View
                imageVew = view.findViewById(R.id.imageView)
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.text_row_item, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element

            //Here assigned the images
                Glide.with( viewHolder.imageVew.context )
                    .load( dataSet[position].wallpaperLink )
                    .into(viewHolder.imageVew);
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

    }
