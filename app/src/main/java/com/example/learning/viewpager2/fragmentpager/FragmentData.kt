package com.example.learning.viewpager2.fragmentpager

data class Foo(var itemName: String, var itemDescription: String)


object FooItems {

    private val itemNames = arrayListOf(
            "Fragment 0",
            "Fragment 1",
            "Fragment 2",
            "Fragment 3",
            "Fragment 4",
            "Fragment 5",
            "Fragment 6"
    )

    var list: ArrayList<Foo>? = null
        get() {

            val description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

            if (field != null)
                return field

            field = ArrayList()
            for (i in itemNames.indices) {

                val itemName = itemNames[i]
                val item = Foo(itemName, description)
                field!!.add(item)
            }

            return field
        }
}