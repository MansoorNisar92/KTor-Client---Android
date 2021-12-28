package com.ktor.application.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ktor.application.adapter.PostItemAdapter
import com.ktor.application.databinding.PostsListFragmentBinding
import com.ktor.application.extensions.showSnackBar
import com.ktor.application.viewmodel.PostsViewModel
import kotlinx.coroutines.flow.collectLatest

class PostsListFragment : Fragment() {
    private lateinit var binding: PostsListFragmentBinding
    private val viewModel: PostsViewModel by activityViewModels()

    private lateinit var adapter: PostItemAdapter
    companion object {
        fun newInstance() = PostsListFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PostsListFragmentBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        initializePostsRecyclerView()
        viewModel.fetchPosts()
    }

    private fun setObservers() {
        viewModel.apply {
            progressLiveData.observe(viewLifecycleOwner){
                if (it.getContentIfNotHandled()!=null){
                    if (it.peekContent()){
                        showProgress()
                    }else {
                        hideProgress()
                    }
                }
            }

            errorMessageLiveData.observe(viewLifecycleOwner){
                showSnackBar(it)
            }

            lifecycleScope.launchWhenStarted {
                postsStateFlow.collectLatest {
                    if (it.count() > 0) {
                        handleView(false)
                        adapter.updateList(it)
                    }else{
                        handleView(false)
                    }
                }
            }

        }
        
    }


    private fun initializePostsRecyclerView(){
        adapter = PostItemAdapter(arrayListOf())
        binding.postsRecyclerView.adapter = adapter
    }


    private fun showProgress(){
        binding.progress.visibility = View.VISIBLE
    }

    private fun hideProgress(){
        binding.progress.visibility = View.GONE
    }

    private fun handleView(show:Boolean){
        if (show){
            binding.noPostsTextView.visibility = View.VISIBLE
        }else{
            binding.noPostsTextView.visibility = View.GONE
        }
    }
}