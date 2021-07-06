package com.promoclicks.task.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.promoclicks.data.response.HotProductPaidStatu
import com.promoclicks.data.response.Slider
import com.promoclicks.task.R
import com.promoclicks.task.core.BaseActivity
import com.promoclicks.task.core.BaseResponse
import com.promoclicks.task.databinding.ActivityMainBinding
import com.promoclicks.task.ui.home.adapters.offers.OffersAdapter
import com.promoclicks.task.ui.home.adapters.offers.OffersPageListener
import com.promoclicks.task.ui.home.adapters.products.ProductsAdapter
import com.promoclicks.task.ui.home.adapters.products.ProductsClickListener
import com.promoclicks.task.ui.home.adapters.sponsors.SponsorsAdapter
import com.promoclicks.task.ui.home.adapters.vendors.VendorsAdapter
import com.promoclicks.task.util.StateFlowObserver.flowObserver
import com.promoclicks.task.util.ToastUtil.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity(), ProductsClickListener, OffersPageListener {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private val viewModel by viewModels<HomeActivityViewModel>()
    private val offersAdapter by lazy { OffersAdapter(this) }
    private val sponsorsAdapter by lazy { SponsorsAdapter() }
    private val vendorsAdapter by lazy { VendorsAdapter() }
    private val productsAdapter by lazy { ProductsAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
    }

    private fun bindView() {

        binding.run {
            offersAdapter = this@HomeActivity.offersAdapter
            sponsorsAdapter = this@HomeActivity.sponsorsAdapter
            vendorsAdapter = this@HomeActivity.vendorsAdapter
            productsAdapter = this@HomeActivity.productsAdapter
            viewModel = this@HomeActivity.viewModel
            sortIv.setOnClickListener {
                showToast(message = "You CLicked Sort ")
            }
            notificationIv.setOnClickListener { showToast(message = "You CLicked Notifications Button ") }
        }
        flowObserver(
            scope = lifecycleScope,
            flow = viewModel.response,
            result = { response ->
                when (response) {
                    is BaseResponse.Loading -> viewModel.setLoading(response.loading)
                    is BaseResponse.Success -> {
                        viewModel.setLoading(false)
                        vendorsAdapter.submitList(response.data.data?.vendor)
                        productsAdapter.submitList(response.data.data?.hotProductPaidStatus)
                        sponsorsAdapter.submitList(response.data.data?.sponsors)
                        offersAdapter.submitList(response.data.data?.sliders)

                    }
                    is BaseResponse.Error -> {
                        viewModel.setLoading(false)
                        onError(response.throwable)
                    }
                }
            }
        )

    }


    override fun onShopClick(view: View, item: Slider) {
        showToast(message = "You CLicked Shop Now")
    }

    override fun onFabClick(view: View, item: HotProductPaidStatu, position: Int) {
        showToast(message = "You CLicked Favorite Button")

        item.isSelected = !item.isSelected
        productsAdapter.notifyItemChanged(position)
    }

    override fun onItemClick(view: View, item: HotProductPaidStatu) {
        showToast(message = "You CLicked A Product")
    }


}