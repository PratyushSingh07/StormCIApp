package dev.danascape.stormci.adapters.team.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.danascape.stormci.R
import dev.danascape.stormci.models.team.Team

class TeamListFragmentAdapter(private val context: Context, private val mCoreTeam: MutableList<Team>, private val mRowLayout: Int) : RecyclerView.Adapter<TeamListFragmentAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
        return TeamViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val url = mCoreTeam[position].image
        if(url == null) {
        } else {
            Picasso.get()
                    .load(url)
                    .into(holder.image)
        }
        holder.name.text = mCoreTeam[position].name
        holder.title.text = mCoreTeam[position].title
        holder.github.text = "Github"
        holder.linkedin.text = "Linkedin"
//        holder.github.text = mCoreTeam[position].github
//        holder.linkedin.text = mCoreTeam[position].linkedin

        holder.github.setOnClickListener {
            Toast.makeText(context, "Clicked on Github Profile Link", Toast.LENGTH_SHORT).show()
        }

        holder.linkedin.setOnClickListener {
            Toast.makeText(context, "Clicked on LinkedIn Profile Link", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return mCoreTeam.size
    }

    class TeamViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
        val name: TextView = itemView.findViewById<View>(R.id.tvName) as TextView
        val title: TextView = itemView.findViewById<View>(R.id.tvTitle) as TextView
        val image: ImageView = itemView.findViewById<ImageView>(R.id.imgProfile) as ImageView
        val github: TextView = itemView.findViewById<View>(R.id.tvGithub) as TextView
        val linkedin: TextView = itemView.findViewById<View>(R.id.tvLinkedin) as TextView
    }
}