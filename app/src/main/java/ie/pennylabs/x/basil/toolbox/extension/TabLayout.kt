package ie.pennylabs.x.basil.toolbox.extension

import com.google.android.material.tabs.TabLayout

private typealias OnTabReselected = (tab: TabLayout.Tab) -> Unit
private typealias OnTabUnselected = (tab: TabLayout.Tab) -> Unit
private typealias OnTabSelected = (tab: TabLayout.Tab) -> Unit

fun TabLayout.addOnTabSelectedListener(
  onReselected: OnTabReselected? = null,
  onUnselected: OnTabUnselected? = null,
  onSelected: OnTabSelected? = null
): TabLayout.OnTabSelectedListener {

  val listener = object : TabLayout.OnTabSelectedListener {
    override fun onTabReselected(tab: TabLayout.Tab) {
      onReselected?.invoke(tab)
    }

    override fun onTabUnselected(tab: TabLayout.Tab) {
      onUnselected?.invoke(tab)
    }

    override fun onTabSelected(tab: TabLayout.Tab) {
      onSelected?.invoke(tab)
    }
  }
  addOnTabSelectedListener(listener)
  return listener
}

fun TabLayout.doOnTabReselected(action: OnTabReselected): TabLayout.OnTabSelectedListener {
  return addOnTabSelectedListener(onReselected = action)
}

fun TabLayout.doOnTabUnseleted(action: OnTabUnselected): TabLayout.OnTabSelectedListener {
  return addOnTabSelectedListener(onUnselected = action)
}

fun TabLayout.doOnTabSelected(action: OnTabSelected): TabLayout.OnTabSelectedListener {
  return addOnTabSelectedListener(onSelected = action)
}