package cn.frank.sample.repository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cn.frank.sample.api.GithubService;
import cn.frank.sample.api.ServiceGenerator;
import cn.frank.sample.vo.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoRepository {

    private static RepoRepository sInstance;

    public RepoRepository() {
    }

    public static RepoRepository getInstance() {
        if (sInstance == null) {
            synchronized (RepoRepository.class) {
                if (sInstance == null) {
                    sInstance = new RepoRepository();
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<Repo>> getRepo(String userId) {
        final MutableLiveData<List<Repo>> data = new MutableLiveData<>();
        ServiceGenerator.createService(GithubService.class)
                .listRepos(userId)
                .enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        data.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {

                    }
                });
        return data;
    }

}
