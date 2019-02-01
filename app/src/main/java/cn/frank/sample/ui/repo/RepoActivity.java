package cn.frank.sample.ui.repo;

import androidx.appcompat.app.AppCompatActivity;
import cn.frank.sample.R;

import android.os.Bundle;

public class RepoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        RepoFragment fragment = (RepoFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = RepoFragment.newInstance("google");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
