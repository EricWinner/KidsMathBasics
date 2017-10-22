package kisdmathbasics.edwardadmin.com.kidsmathbasics.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;
import java.util.Map;

import kisdmathbasics.edwardadmin.com.kidsmathbasics.R;
import kisdmathbasics.edwardadmin.com.kidsmathbasics.model.MathItemModel;
import kisdmathbasics.edwardadmin.com.kidsmathbasics.view.MathCardView;
import kisdmathbasics.edwardadmin.com.kidsmathbasics.view.MathItemView;

/**
 * Created by EdwardAdmin on 2017/10/22.
 */

public class MathViewAdapter extends RecyclerView.Adapter<MathViewAdapter.ViewHolder> {

    private Map<Integer,List<MathItemModel>> mMathData;
    private Context mContext;
    private MathCardView mMathCardView;

    private int[] colors = {0xff01a3a1, 0xff91bbeb, 0xff01b1bf, 0xffff9d62, 0xff2d3867, 0xffee697e};//颜色组

    public void initMathData(Map<Integer,List<MathItemModel>> data) {
        this.mMathData = data;
    }

    public MathViewAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mMathCardView = new MathCardView(mContext);
        ViewHolder holder = new ViewHolder(mMathCardView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List<MathItemModel> model = mMathData.get(position);

        MathItemModel mathItemModel1 = model.get(0);
        holder.mathItemView1.setNumberFirstText(mathItemModel1.getmNumberFirstText());
        holder.mathItemView1.setNumberSecondText(mathItemModel1.getmNumberSecondText());
        holder.mathItemView1.setNumberThirdText(mathItemModel1.getmNumberThirdText());
        holder.mathItemView1.setSymbolFirstText(mathItemModel1.getmSymbolFirstText());
        holder.mathItemView1.setSymbolSecondText(mathItemModel1.getmSymbolSecondText());

        MathItemModel mathItemModel2 = model.get(1);
        holder.mathItemView2.setNumberFirstText(mathItemModel2.getmNumberFirstText());
        holder.mathItemView2.setNumberSecondText(mathItemModel2.getmNumberSecondText());
        holder.mathItemView2.setNumberThirdText(mathItemModel2.getmNumberThirdText());
        holder.mathItemView2.setSymbolFirstText(mathItemModel2.getmSymbolFirstText());
        holder.mathItemView2.setSymbolSecondText(mathItemModel2.getmSymbolSecondText());

        MathItemModel mathItemModel3 = model.get(2);
        holder.mathItemView3.setNumberFirstText(mathItemModel3.getmNumberFirstText());
        holder.mathItemView3.setNumberSecondText(mathItemModel3.getmNumberSecondText());
        holder.mathItemView3.setNumberThirdText(mathItemModel3.getmNumberThirdText());
        holder.mathItemView3.setSymbolFirstText(mathItemModel3.getmSymbolFirstText());
        holder.mathItemView3.setSymbolSecondText(mathItemModel3.getmSymbolSecondText());

        MathItemModel mathItemModel4 = model.get(3);
        holder.mathItemView4.setNumberFirstText(mathItemModel4.getmNumberFirstText());
        holder.mathItemView4.setNumberSecondText(mathItemModel4.getmNumberSecondText());
        holder.mathItemView4.setNumberThirdText(mathItemModel4.getmNumberThirdText());
        holder.mathItemView4.setSymbolFirstText(mathItemModel4.getmSymbolFirstText());
        holder.mathItemView4.setSymbolSecondText(mathItemModel4.getmSymbolSecondText());

        MathItemModel mathItemModel5 = model.get(4);
        holder.mathItemView5.setNumberFirstText(mathItemModel5.getmNumberFirstText());
        holder.mathItemView5.setNumberSecondText(mathItemModel5.getmNumberSecondText());
        holder.mathItemView5.setNumberThirdText(mathItemModel5.getmNumberThirdText());
        holder.mathItemView5.setSymbolFirstText(mathItemModel5.getmSymbolFirstText());
        holder.mathItemView5.setSymbolSecondText(mathItemModel5.getmSymbolSecondText());

        holder.mathItemView1.setCurrentColor(colors[position % 6]);
        holder.mathItemView2.setCurrentColor(colors[position % 6]);
        holder.mathItemView3.setCurrentColor(colors[position % 6]);
        holder.mathItemView4.setCurrentColor(colors[position % 6]);
        holder.mathItemView5.setCurrentColor(colors[position % 6]);

        ((MathCardView) holder.itemView).changeTheme(colors[position % 6]);
    }

    @Override
    public int getItemCount() {
        return mMathData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout top;
        MathItemView mathItemView1;
        MathItemView mathItemView2;
        MathItemView mathItemView3;
        MathItemView mathItemView4;
        MathItemView mathItemView5;

        ImageView center;
        EditText comment;

        ViewHolder(View view) {
            super(view);
            top = (RelativeLayout) view.findViewById(R.id.top);
            center = (ImageView) view.findViewById(R.id.center);
            comment = (EditText) view.findViewById(R.id.comment);
            mathItemView1 = (MathItemView) view.findViewById(R.id.mathItem1);
            mathItemView2 = (MathItemView) view.findViewById(R.id.mathItem2);
            mathItemView3 = (MathItemView) view.findViewById(R.id.mathItem3);
            mathItemView4 = (MathItemView) view.findViewById(R.id.mathItem4);
            mathItemView5 = (MathItemView) view.findViewById(R.id.mathItem5);
        }
    }
}
