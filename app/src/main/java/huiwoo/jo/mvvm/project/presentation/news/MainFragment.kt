package huiwoo.jo.mvvm.project.presentation.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import huiwoo.jo.mvvm.project.R
import huiwoo.jo.mvvm.project.data.network.RetrofitObject
import huiwoo.jo.mvvm.project.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.newsData.observe(viewLifecycleOwner) {
            // fetched data
            binding.recyclerview.submitList(it)
        }
    }

    override fun onDestroyView() {
        // fragment 와 fragment view -> Fragment
        _binding = null
        super.onDestroyView()
    }
}

