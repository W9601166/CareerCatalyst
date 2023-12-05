package uk.ac.tees.w9601166.careercatalyst.ui.data.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.Results
import okhttp3.Credentials
import okhttp3.Interceptor

class BasicAuthInterceptor(username: String, password: String): Interceptor {
    private var credentials: String = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", credentials).build()
        return chain.proceed(request)
    }
}

val client: OkHttpClient =  OkHttpClient.Builder()
    .addInterceptor(BasicAuthInterceptor("0e81668a-3a8b-4293-88c4-c0599b49028e",     ""))
    .build()
const val BASE_URL = "https://www.reed.co.uk/"

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface JobsApiService {
    @GET("api/1.0/search?keywords=developer&location=london/")
    suspend fun getJobs(): Results
}

object JobsApi {
    val retrofitService: JobsApiService by lazy {
        retrofit.create(JobsApiService::class.java)
    }
}

enum class JobsApiStatus { LOADING, ERROR, DONE }

