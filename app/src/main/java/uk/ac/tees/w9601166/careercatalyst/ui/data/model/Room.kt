package uk.ac.tees.w9601166.careercatalyst.ui.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data  class Room(
    var id: String? = null,
    val title: String? = null,
    val categoryId: Int? = null,
    val description: String? = null,
    val ownerId: String? = null,
) : Parcelable {
    companion object{
       const val COLLECTION_NAME ="Room"
    }
}