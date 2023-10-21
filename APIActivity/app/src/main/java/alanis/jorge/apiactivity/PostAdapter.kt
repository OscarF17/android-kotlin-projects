package alanis.jorge.apiactivity

import alanis.jorge.apiactivity.databinding.ItemPostBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    // TODO: Define el ViewHolder y los métodos necesarios para el adaptador

    inner class PostViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.postUserId.text = "UserID: ${post.userId}"
            binding.postId.text = "PostID: ${post.id}"
            binding.postTitle.text = "Title: ${post.title}"
            binding.postBody.text = "Body: ${post.body}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(layoutInflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = posts[position]
        holder.bind(item)
    }
}