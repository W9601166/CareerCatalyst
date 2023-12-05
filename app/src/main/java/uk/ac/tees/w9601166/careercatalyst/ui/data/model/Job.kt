package uk.ac.tees.w9601166.careercatalyst.ui.data.model


import com.google.gson.annotations.SerializedName


data class Job (

  @SerializedName("jobId"               ) var jobId               : Int?    = null,
  @SerializedName("employerId"          ) var employerId          : Int?    = null,
  @SerializedName("employerName"        ) var employerName        : String? = null,
  @SerializedName("employerProfileId"   ) var employerProfileId   : String? = null,
  @SerializedName("employerProfileName" ) var employerProfileName : String? = null,
  @SerializedName("jobTitle"            ) var jobTitle            : String? = null,
  @SerializedName("locationName"        ) var locationName        : String? = null,
  @SerializedName("minimumSalary"       ) var minimumSalary       : Int?    = null,
  @SerializedName("maximumSalary"       ) var maximumSalary       : Int?    = null,
  @SerializedName("currency"            ) var currency            : String? = null,
  @SerializedName("expirationDate"      ) var expirationDate      : String? = null,
  @SerializedName("date"                ) var date                : String? = null,
  @SerializedName("jobDescription"      ) var jobDescription      : String? = null,
  @SerializedName("applications"        ) var applications        : Int?    = null,
  @SerializedName("jobUrl"              ) var jobUrl              : String? = null
)