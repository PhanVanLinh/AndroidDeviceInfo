package toong.vn.androiddeviceinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import toong.vn.androiddeviceinfo.data.model.DensityInfo;
import toong.vn.androiddeviceinfo.data.model.DeviceInfo;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private OneItemTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        ArrayList<DeviceInfo> data = new ArrayList<>();

        // set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OneItemTypeAdapter(this, data);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data.add(DensityInfo.build(this));

        adapter.notifyDataSetChanged();
    }
}
