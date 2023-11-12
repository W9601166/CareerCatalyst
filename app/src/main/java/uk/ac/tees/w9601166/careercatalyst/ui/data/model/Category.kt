package uk.ac.tees.w9601166.careercatalyst.ui.data.model

import uk.ac.tees.w9601166.careercatalyst.R


data class Category(
    val id: Int,
    val title: String,
    val imageResId: Int
) {
    companion object {
        fun getCategories(): List<Category> {
            return listOf(
                Category(
                    1, "SPORTS", R.drawable.sports
                ),
                Category(
                    2, "MUSIC", R.drawable.music
                ), Category(
                    3, "MOVIES", R.drawable.movies
                ), Category(
                    4, "IT", R.drawable.it
                ), Category(
                    5, "LEGAL ADVISOR", R.drawable.legal
                )
            )
        }

        fun getCategoryImageByCategoryId(catId : Int) : Int {
          return  when(catId){
              1 -> R.drawable.sports
              2 -> R.drawable.music
              3 -> R.drawable.movies
              else -> R.drawable.sports
          }
        }

    }
}