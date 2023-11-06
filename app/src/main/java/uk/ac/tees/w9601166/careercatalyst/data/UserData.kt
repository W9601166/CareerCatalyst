package uk.ac.tees.w9601166.careercatalyst.data

data class UserData (
    val name:String?,
    val age: Int?,
    val favoriteFood:List<String>?
) {
    //Note: this is needed to read the data from the firebase database
    //firebase database throws this exception: UserData does not define a no-argument constructor
    constructor() : this(null, null, null)
}
