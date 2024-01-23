package huiwoo.jo.mvvm.project.presentation.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import huiwoo.jo.mvvm.project.R
import huiwoo.jo.mvvm.project.databinding.FragmentMainNewsBinding
import huiwoo.jo.mvvm.project.presentation.adapter.NewsAdapter

class MainFragment : Fragment() {
    private var _binding: FragmentMainNewsBinding? = null
    private val binding: FragmentMainNewsBinding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_news, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupAdapter()
        setupDataBinding()
    }

    private fun setupAdapter() {
        adapter = NewsAdapter()
        binding.rvNews.apply {
            this.adapter = this@MainFragment.adapter
            this.layoutManager = LinearLayoutManager(requireActivity())
            this.setHasFixedSize(true)
        }
    }

    private fun setupDataBinding() {
        viewModel.newsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

