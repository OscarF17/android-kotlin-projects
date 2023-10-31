package alanis.jorge.apiactivity

import alanis.jorge.apiactivity.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var  adapter: PostAdapter
    private val postList = mutableListOf<Post>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("LOG_OSCAR", "app prendio")
        initRecyclerView()
        getData()
        // TODO: Inicializar Retrofit, hacer la llamada y configurar el adaptador
    }

    private fun initRecyclerView() {
        adapter = PostAdapter(postList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.i("LOG_OSCAR", "try")
                val call = getRetrofit().create(JsonPlaceholderApi::class.java)
                    .getPosts("https://jsonplaceholder.typicode.com/posts")
                val posts = call.body()
                runOnUiThread {
                    if(call.isSuccessful) {
                        postList.clear()
                        if (posts != null) {
                            |postList.addAll(posts)
                        }
                        adapter.notifyDataSetChanged()
                    }
                }
                Log.i("LOG_OSCAR", "${call}")
                Log.i("LOG_OSCAR", "${call.body()}")
            }
            catch (e: Exception) {
                runOnUiThread {
                    Log.i("LOG_OSCAR", "ALGO SALIO MAL")
                }
            }
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/posts/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}