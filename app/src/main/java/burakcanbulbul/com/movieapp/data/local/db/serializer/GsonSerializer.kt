package burakcanbulbul.com.movieapp.data.local.db.serializer

import com.google.gson.Gson

class GsonSerializer : Serializer<Any> {

    private lateinit var gson: Gson

    fun setGson(gson: Gson): GsonSerializer {
        this.gson = gson
        return this
    }

    override fun deserialize(s: String, type: Class<Any>): Any {
        return gson.fromJson(s,type)
    }

    override fun serialize(instance: Any): String {
        return gson.toJson(instance)
    }

}
