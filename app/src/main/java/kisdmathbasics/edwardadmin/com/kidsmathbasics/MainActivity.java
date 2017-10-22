package kisdmathbasics.edwardadmin.com.kidsmathbasics;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kisdmathbasics.edwardadmin.com.kidsmathbasics.adapter.MathViewAdapter;
import kisdmathbasics.edwardadmin.com.kidsmathbasics.model.MathItemModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MathViewAdapter mMathViewAdapter;
    private List<MathItemModel> mData = new ArrayList<>();
    private Map<Integer, List<MathItemModel>> mAllDatas = new HashMap<Integer, List<MathItemModel>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main_recyclerview);

        mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerview);
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        Log.d(TAG, "mLinearLayoutManager = " + mLinearLayoutManager);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mMathViewAdapter = new MathViewAdapter(this);
        mRecyclerView.setAdapter(mMathViewAdapter);

        mRecyclerView.addItemDecoration(new SpaceItemDecoration(50));

        initData();
        mMathViewAdapter.notifyDataSetChanged();
    }

    private void initData() {
        for (int index = 0; index < 10; index++) {
            for (int last = 0; last < 5; last++) {
                MathItemModel model = new MathItemModel("10", "20", "30", "+", "-");
                mData.add(model);
            }
            mAllDatas.put(index, mData);
        }
        mMathViewAdapter.initMathData(mAllDatas);
    }


    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = mSpace;
            }
        }

        public SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
    }
}
