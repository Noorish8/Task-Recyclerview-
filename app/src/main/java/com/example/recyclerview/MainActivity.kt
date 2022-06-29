package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.recyclerview.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val i:Int=0
    var list:ArrayList<Model> = ArrayList<Model>()
    val url:String="https://simplifiedcoding.net/demos/view-flipper/heroes.php"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        val request: StringRequest = StringRequest(Request.Method.GET,url, {
                response ->

            Log.e("response>>>>>>",response)
            val jsonObject: JSONObject = JSONObject(response)
            val heroesArray= jsonObject.getJSONArray("heroes")
            for (i in 0 until heroesArray.length()) {
                val jsonObject = heroesArray.getJSONObject(i)
                val name :String=jsonObject.getString("name")
                val imageUrl :String=jsonObject.getString("imageurl")
                val dataModel= Model()
                dataModel.name = name
                dataModel.image = imageUrl
                list.add(dataModel)
            }


            binding.recyclerview.adapter=Adapter(this,list)
        }, {

        })
        val requestQueue= Volley.newRequestQueue(this)
        requestQueue.add(request)





    }
}