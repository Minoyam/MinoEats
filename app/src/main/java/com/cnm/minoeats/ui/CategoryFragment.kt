package com.cnm.minoeats.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.cnm.minoeats.CustomAdapter
import com.cnm.minoeats.FoodItem
import com.cnm.minoeats.R
import kotlinx.android.synthetic.main.activity_category.*

class CategoryFragment : Fragment(), CustomAdapter.ItemOnClickListener {
    override fun itemOnClick(foodItem: FoodItem) {
        val intent = Intent(context, FoodItemDetailActivity::class.java)
        intent.putExtra(NAME, foodItem)
        startActivityForResult(intent, REQ_SECOND)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_content.run {
            adapter = CustomAdapter(this@CategoryFragment).apply {
                setList(FoodItem.values().toList())

            }
            layoutManager = GridLayoutManager(MainActivity(), 2)
            itemAnimator = null
        }
        bt_button1.setOnClickListener {
            val food = FoodItem.values().toList()
            (rv_content.adapter as CustomAdapter).insertFirst(food.shuffled().first())
            rv_content.layoutManager?.scrollToPosition(0)
        }
        bt_button2.setOnClickListener {
            (rv_content.adapter as CustomAdapter).remove()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_SECOND) {
            if (resultCode == RESULT_OK) {
                val foodItem = data?.getSerializableExtra(NAME) as FoodItem
                (rv_content.adapter as CustomAdapter).remove(foodItem)
            }
        }
    }
    companion object {
        const val REQ_SECOND = 1001
        const val NAME = "FOOD_ITEM"
    }

}
