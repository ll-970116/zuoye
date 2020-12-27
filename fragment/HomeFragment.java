package com.example.imitation.fragment;


import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.imitation.R;
import com.example.imitation.adapter.BannerListener;
import com.example.imitation.adapter.BrandListAdapter;
import com.example.imitation.adapter.ChanneGridlayoutper;
import com.example.imitation.adapter.NewGoodsListAdapter;
import com.example.imitation.adapter.ShangPingAdapter;
import com.example.imitation.adapter.ShouFaAdapter;
import com.example.imitation.adapter.SousuoAdapter;
import com.example.imitation.base.BaseFragment;
import com.example.imitation.bean.HomeBean;
import com.example.imitation.constants.IConstants;
import com.example.imitation.presenter.HomePresenterImpl;


public class HomeFragment extends BaseFragment<HomePresenterImpl> implements IConstants.IView {


    private RecyclerView rl;
    private VirtualLayoutManager layoutManager;
    private LinearLayoutHelper linearLayoutHelper;

    private DelegateAdapter adapter;
    private SousuoAdapter sousuoAdapter;
    private LinearLayoutHelper bannerlayoutHelper;
    private BannerListener bannerlistener;
    private GridLayoutHelper gridLayoutHelper;
    private ChanneGridlayoutper channeGridlayoutper;
    private BrandListAdapter brandsList;
    private ShangPingAdapter shangPingAdapter;
    private NewGoodsListAdapter newGoodsListAdapter;
    private ShouFaAdapter shouFaAdapter;


    @Override
    protected int ID() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initData() {


        presenter.getData();


    }

    private void initBannerLinerLayout(HomeBean homeBean) {

        bannerlayoutHelper = new LinearLayoutHelper();
        bannerlayoutHelper.setItemCount(1);
        bannerlayoutHelper.setPadding(20, 20, 20, 20);
        bannerlayoutHelper.setBgColor(0);
        bannerlayoutHelper.setMargin(20, 20, 20, 20);
        bannerlayoutHelper.setAspectRatio(2);

        bannerlistener = new BannerListener(bannerlayoutHelper, homeBean, getActivity());
    }

    @Override
    protected void initView(View view) {
        rl = view.findViewById(R.id.rl);
    }

    private void initSousuoLinerLayout() {

        linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        linearLayoutHelper.setPadding(20, 20, 20, 20);
        linearLayoutHelper.setMargin(20, 20, 20, 20);
        linearLayoutHelper.setBgColor(0);
        linearLayoutHelper.setAspectRatio(10);
        sousuoAdapter = new SousuoAdapter(linearLayoutHelper, getActivity());


    }

    @Override
    protected HomePresenterImpl add() {
        return new HomePresenterImpl();
    }

    @Override
    public void OnSuccess(HomeBean homeBean) {
        layoutManager = new VirtualLayoutManager(getActivity());
        rl.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rl.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        initSousuoLinerLayout();
        initBannerLinerLayout(homeBean);
        initChanneGridlayoutper(homeBean);
        initShangPingLinerLayout(homeBean);
        initBrandList(homeBean);
        iniShouFa();
        initNewGoodsList(homeBean);

        adapter = new DelegateAdapter(layoutManager, true);
        adapter.addAdapter(sousuoAdapter);
        adapter.addAdapter(bannerlistener);

        adapter.addAdapter(channeGridlayoutper);
        adapter.addAdapter(shangPingAdapter);
        adapter.addAdapter(brandsList);
        adapter.addAdapter(shouFaAdapter);
        adapter.addAdapter(newGoodsListAdapter);

        rl.setAdapter(adapter);
    }

    private void iniShouFa() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setBgColor(0);
        linearLayoutHelper.setItemCount(1);
        linearLayoutHelper.setAspectRatio(10);
        linearLayoutHelper.setMargin(10, 10, 10, 10);
        linearLayoutHelper.setPadding(20, 20, 20, 20);

        shouFaAdapter = new ShouFaAdapter(linearLayoutHelper, getActivity());
    }

    private void initNewGoodsList(HomeBean homeBean) {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setItemCount(4);
        gridLayoutHelper.setPadding(20, 20, 20, 20);
        gridLayoutHelper.setMargin(20, 20, 20, 20);
        gridLayoutHelper.setBgColor(0);
        gridLayoutHelper.setAspectRatio(2);

        //  gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setWeights(new float[]{50, 50});
        gridLayoutHelper.setVGap(20);
        gridLayoutHelper.setHGap(20);
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setSpanCount(2);
        newGoodsListAdapter = new NewGoodsListAdapter(gridLayoutHelper, homeBean, getActivity());
    }

    private void initShangPingLinerLayout(HomeBean homeBean) {

        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setBgColor(0);
        linearLayoutHelper.setItemCount(1);
        linearLayoutHelper.setAspectRatio(10);
        linearLayoutHelper.setMargin(10, 10, 10, 10);
        linearLayoutHelper.setPadding(20, 20, 20, 20);
        shangPingAdapter = new ShangPingAdapter(linearLayoutHelper, getActivity());
    }

    private void initBrandList(HomeBean homeBean) {
        gridLayoutHelper = new GridLayoutHelper(4);
        // 公共属性
        gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(0);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(5);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        brandsList = new BrandListAdapter(gridLayoutHelper, homeBean, getActivity());
    }

    private void initChanneGridlayoutper(HomeBean homeBean) {
        gridLayoutHelper = new GridLayoutHelper(5);
        // 公共属性
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(0);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(10);// 设置每行多少个网格
        channeGridlayoutper = new ChanneGridlayoutper(gridLayoutHelper, homeBean, getActivity());
    }

    @Override
    public void onFail(String err) {
        Log.e("TAG", "onFail: " + err);
    }
}