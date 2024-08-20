package com.example.wallpaperapp_activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class imageRecycleViewAdapter(private var dataSet: Array<String>) :
        RecyclerView.Adapter<imageRecycleViewAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder)
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView
            val imageVew : ImageView

            init {
                // Define click listener for the ViewHolder's View
                textView = view.findViewById(R.id.textView)
                imageVew = view.findViewById(R.id.imageView)
            }
        }

    fun setItems(dataSet: Array<String>){
        this.dataSet = dataSet
        notifyDataSetChanged()
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
            viewHolder.textView.text = dataSet[position]

            //Here we can assign the images
//            viewHolder.imageVew.
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

    }
