package com.cnm.minoeats.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cnm.minoeats.FoodItem
import com.cnm.minoeats.R
import kotlinx.android.synthetic.main.activity_order.*

class FoodItemDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val data = intent.getSerializableExtra(CategoryFragment.NAME) as FoodItem
        tv_foodName.text = data.foodName
        iv_foooIamge.setImageResource(data.foodImgResId)

        bt_sale.setOnClickListener {
            val intent = Intent()
            intent.putExtra(CategoryFragment.NAME,data)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


    }


}