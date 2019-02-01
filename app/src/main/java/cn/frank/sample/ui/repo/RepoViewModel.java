package cn.frank.sample.ui.repo;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import cn.frank.sample.SampleApp;
import cn.frank.sample.repository.RepoRepository;
import cn.frank.sample.vo.Repo;

public class RepoViewModel extends AndroidViewModel {

    private LiveData<List<Repo>> repo;
    private RepoRepository repoRepository;

    public RepoViewModel(@NonNull Application application) {
        super(application);
        this.repoRepository = ((SampleApp) application).getRepoRepository();
    }

    public void init(String userId) {
        if (this.repo != null) {
            return;
        }
        this.repo = repoRepository.getRepo(userId);
    }

    public LiveData<List<Repo>> getRepo() {
        return repo;
    }
}
