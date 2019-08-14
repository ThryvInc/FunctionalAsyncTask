package co.lithobyte.functionalasync

import android.os.AsyncTask

open class FunctionalAsyncTask<T>(val bgFunction: (() -> T),
                                  val returnFunction: ((T) -> Unit),
                                  val preFunction: () -> Unit = {}):
    AsyncTask<Void, Void, T>() {
    override fun onPreExecute() {
        super.onPreExecute()
        preFunction()
    }

    override fun doInBackground(vararg params: Void?): T {
        return bgFunction()
    }

    override fun onPostExecute(result: T) {
        super.onPostExecute(result)
        returnFunction(result)
    }
}