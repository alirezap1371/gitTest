package github.test.myapplication

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task = getDataFromNet(object : TaskListner {
            override fun onResult(result: String) {
                Toast.makeText(applicationContext,result,Toast.LENGTH_SHORT).show()
            }
        }).execute()
        var test=findViewById(R.id.test) as TextView
        test.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()

        })
    }
    interface TaskListner
    {
       public fun onResult(result:String)
    }
    class getDataFromNet( task:TaskListner): AsyncTask<Void, String, Any>()
    {
        override fun doInBackground(vararg params: Void?): Any {
            return "salam"
        }


        var x:TaskListner
        init {
           x=task
        }


        override fun onPostExecute(result: Any?) {
            super.onPostExecute(result)
            x.onResult(result.toString())
        }

    }

}
