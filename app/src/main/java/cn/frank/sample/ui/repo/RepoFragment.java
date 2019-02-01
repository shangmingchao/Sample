package cn.frank.sample.ui.repo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import cn.frank.sample.R;
import cn.frank.sample.vo.Repo;

public class RepoFragment extends Fragment {

    private static final String ARG_USER_ID = "user_id";

    private RepoViewModel viewModel;
    private TextView repoTextView;

    public RepoFragment() {

    }

    public static RepoFragment newInstance(String userId) {
        RepoFragment fragment = new RepoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_ID, userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_repo, container, false);
        repoTextView = (TextView) rootView.findViewById(R.id.repo);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            String userId = args.getString(ARG_USER_ID);
            viewModel = ViewModelProviders.of(this).get(RepoViewModel.class);
            viewModel.init(userId);
            viewModel.getRepo().observe(this, new Observer<List<Repo>>() {
                @Override
                public void onChanged(List<Repo> repos) {
                    StringBuilder builder = new StringBuilder();
                    if (repos != null) {
                        for (Repo repo : repos) {
                            builder.append(repo.getFull_name()).append("\n");
                        }
                    }
                    repoTextView.setText(builder);
                }
            });
        }
    }

}
