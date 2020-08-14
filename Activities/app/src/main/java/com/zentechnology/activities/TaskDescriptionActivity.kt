package com.zentechnology.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_task_description.*

class TaskDescriptionActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TASK_DESCRIPTION = "task"

        fun newIntent(context: Context) = Intent(context, TaskDescriptionActivity::class.java)

        fun getNewTask(data: Intent?): String? = data?.getStringExtra(TaskDescriptionActivity.EXTRA_TASK_DESCRIPTION)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_description)
    }

    fun doneClicked(view: View) {
        val taskDescription = descriptionText.text.toString()

        if(!taskDescription.isEmpty()) {
            val result = Intent()
            result.putExtra(EXTRA_TASK_DESCRIPTION, taskDescription)
            setResult(Activity.RESULT_OK, result)
        }else {
            setResult(Activity.RESULT_CANCELED)
        }

        finish()
    }
}
