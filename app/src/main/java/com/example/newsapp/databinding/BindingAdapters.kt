package com.example.newsapp.databinding

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.squareup.picasso.Picasso

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
    val itemDecoration = DividerItemDecoration(view.context, LinearLayout.VERTICAL)
    view.addItemDecoration(itemDecoration)
}

@BindingAdapter("text")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}

@BindingAdapter("img")
fun loadImage(imageView: ImageView, imageURL: String?) {
    if (imageURL != null) {
        Picasso.with(imageView.context).load(imageURL).into(imageView)
    } else {
        Picasso.with(imageView.context).load(R.drawable.android3).into(imageView)
    }
}