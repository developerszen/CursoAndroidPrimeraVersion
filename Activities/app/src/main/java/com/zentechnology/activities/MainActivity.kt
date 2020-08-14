package com.zentechnology.activities

import android.app.Activity
import android.app.AlertDialog
import android.content.*
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException
import java.lang.StringBuilder
import java.text.FieldPosition
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val PREFS_TASKS = "prefs_tasks"
    private val KEY_TASKS_LIST = "tasks_list"
    private val ADD_TASK_REQUEST = 1

    private val taskList = mutableListOf<String>()
    private val adapter by lazy { makeAdapter(taskList) }
    private val tickReceiver by lazy { makeBroadCastReceiver() }

    companion object {
        private const val TAG = "MainActivity"

        private fun getCurrentTimeStamp(): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
            val now = Date()
            return sdf.format(now)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskListView.adapter = adapter

        taskListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ -> taskSelected(position) }

        val savedList = getSharedPreferences(PREFS_TASKS, Context.MODE_PRIVATE).getString(KEY_TASKS_LIST, null)

        if(savedList != null) {
            val items = savedList.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            taskList.addAll(items)
        }
    }

    override fun onResume() {
        super.onResume()

        dateTimeTextView.text = getCurrentTimeStamp()

        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_TIME_TICK))
    }

    override fun onPause() {
        super.onPause()

        try {
            unregisterReceiver(tickReceiver)
        } catch (e: IllegalArgumentException) {
            Log.e(TAG, "Time tick Receiver no ha sido registrado")
        }
    }

    override fun onStop() {
        super.onStop()

        val savedList = StringBuilder()
        for (task in taskList) {
            savedList.append(task)
            savedList.append(",")
        }

        getSharedPreferences(PREFS_TASKS, Context.MODE_PRIVATE).edit()
            .putString(KEY_TASKS_LIST, savedList.toString()).apply()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == ADD_TASK_REQUEST) {
            if(resultCode == Activity.RESULT_OK) {
                val task = TaskDescriptionActivity.getNewTask(data)
                task?.let {
                    taskList.add(task)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }


    fun addTaskClicked(view: View) {
        val intent = TaskDescriptionActivity.newIntent(this@MainActivity)
        startActivityForResult(intent, ADD_TASK_REQUEST)
    }

    private fun makeAdapter(list: List<String>): ArrayAdapter<String> =
        ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

    private fun makeBroadCastReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if(intent?.action == Intent.ACTION_TIME_TICK) {
                    dateTimeTextView.text = getCurrentTimeStamp()
                }
            }
        }
    }

    private fun taskSelected(position: Int) = AlertDialog.Builder(this@MainActivity)
        .setTitle("Compra")
        .setMessage(taskList[position])
        .setPositiveButton("Eliminar", {_, _ ->
            taskList.removeAt(position)
            adapter.notifyDataSetChanged()
        })
        .setNegativeButton("Cancelar", { dialog, _ -> dialog.cancel() })
        .create()
        .show()

}
