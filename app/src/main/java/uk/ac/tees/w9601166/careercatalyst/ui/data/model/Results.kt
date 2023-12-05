package uk.ac.tees.w9601166.careercatalyst.ui.data.model

import com.google.gson.annotations.SerializedName

data class Results(
  @SerializedName("results" ) var results: ArrayList<Job> = arrayListOf()

)
