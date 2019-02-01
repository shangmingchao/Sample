package cn.frank.sample;

import android.app.Application;

import cn.frank.sample.repository.RepoRepository;

public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public RepoRepository getRepoRepository() {
        return RepoRepository.getInstance();
    }
}
