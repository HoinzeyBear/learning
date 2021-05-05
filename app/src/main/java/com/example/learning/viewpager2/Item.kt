package com.example.learning.viewpager2

data class Item(var colorId: Int, var itemNumber: String)


object Items {

    private val colors = intArrayOf(
            android.R.color.holo_green_dark,
            android.R.color.holo_red_light,
            android.R.color.holo_blue_dark,
            android.R.color.holo_purple
    )

    var list: ArrayList<Item>? = null
        get() {

            if (field != null)
                return field

            field = ArrayList()
            for (i in colors.indices) {

                val colorId = colors[i]
                val item = Item(colorId, "Item $i")
                field!!.add(item)
            }

            return field
        }
}
