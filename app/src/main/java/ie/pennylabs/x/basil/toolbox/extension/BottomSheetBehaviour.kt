package ie.pennylabs.x.basil.toolbox.extension

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior

fun <V : View> BottomSheetBehavior<V>.expand() {
  if (state != BottomSheetBehavior.STATE_EXPANDED) {
    state = BottomSheetBehavior.STATE_EXPANDED
  }
}