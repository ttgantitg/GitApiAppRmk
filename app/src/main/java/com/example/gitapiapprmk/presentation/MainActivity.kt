package com.example.gitapiapprmk.presentation

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gitapiapprmk.App
import com.example.gitapiapprmk.databinding.ActivityMainBinding
import com.example.gitapiapprmk.domain.GitRepoState
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var gitReposViewModel: GitReposViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var gitReposAdapter: GitReposAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as App).getComponent()?.inject(this)
        gitReposViewModel = ViewModelProvider(this, viewModelFactory).get(GitReposViewModel::class.java)

        gitReposAdapter = GitReposAdapter()
        binding.gitReposRv.apply {
            adapter = gitReposAdapter
        }

        binding.btnCheck.setOnClickListener {
            hideKeyboard(this)
            gitReposViewModel.loadUserGitRepos(binding.userEt.text.toString()).observe(this, {
                when (it) {
                    is GitRepoState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        gitReposAdapter.submitList(it.data)
                        binding.gitReposRv.visibility = View.VISIBLE
                    }
                    is GitRepoState.Error -> {
                        binding.gitReposRv.visibility = View.GONE
                        binding.progressBar.visibility = View.GONE
                    }
                    is GitRepoState.EmptyList -> {
                        binding.gitReposRv.visibility = View.GONE
                        binding.progressBar.visibility = View.GONE
                    }
                    is GitRepoState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            })
        }
    }

    private fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}