package ie.pennylabs.x.basil.feature.recipe.detail.directions

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import ie.pennylabs.x.basil.R

class DirectionsPage(context: Context) : FrameLayout(context) {
  init {
    LayoutInflater.from(context).inflate(R.layout.page_directions, this, true)
  }
}