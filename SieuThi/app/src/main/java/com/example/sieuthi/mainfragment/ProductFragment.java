package com.example.sieuthi.mainfragment;

import static com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sieuthi.ApiService;
import com.example.sieuthi.MainActivity;
import com.example.sieuthi.R;
import com.example.sieuthi.category.Category;
import com.example.sieuthi.category.CategoryAdapter;
import com.example.sieuthi.category.CategoryHighlightAdapter;
import com.example.sieuthi.product.Product;
import com.example.sieuthi.product.ProductInCartAdapter;
import com.example.sieuthi.product.ProductInCategoryAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {

    Context context;
    View view;

    SharedPreferences sharedPreferences;
    List<Category> listCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product, container, false);
        context = view.getContext();

        sharedPreferences = getActivity().getSharedPreferences("dataLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        setRecyclerViewListHighlight();

        setRecyclerViewCategory();

        // Khung search tìm kiếm sản phẩm
        TextView tvSearch = (TextView) view.findViewById(R.id.textViewSearch);
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogSearch();
            }
        });

        // Giỏ hàng
        ImageView imgCart = (ImageView) view.findViewById(R.id.imageViewCart);
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogCart();
            }
        });

        return view;
    }

    private void showDialogCart() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = layoutInflater.inflate(R.layout.layout_cart, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(viewDialog);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) viewDialog.getParent());
        bottomSheetBehavior.setState(STATE_EXPANDED);

        // Kiểm tra đã đăng nhập chưa
        String username = sharedPreferences.getString("username", "");
        RelativeLayout layoutChuaDangnhap = (RelativeLayout) viewDialog.findViewById(R.id.layoutCartChuaDangNhap);
        RelativeLayout layoutDaDangnhap = (RelativeLayout) viewDialog.findViewById(R.id.layoutCartDaDangNhap);
        if(username == null || username.length() == 0) {    // Chưa đăng nhập
            layoutChuaDangnhap.setVisibility(View.VISIBLE);
            layoutDaDangnhap.setVisibility(View.INVISIBLE);
        } else {    // Đã đăng nhập
            layoutChuaDangnhap.setVisibility(View.INVISIBLE);
            layoutDaDangnhap.setVisibility(View.VISIBLE);

            // recycler view
            RecyclerView rcvListCart = (RecyclerView) viewDialog.findViewById(R.id.recyclerViewList);
            List<Product> listProductInCart = new ArrayList<>(getDataProductInCart());
            ProductInCartAdapter productInCartAdapter = new ProductInCartAdapter(context, listProductInCart);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

            rcvListCart.setAdapter(productInCartAdapter);
            rcvListCart.setLayoutManager(linearLayoutManager);
        }

        // back
        ImageView imgBack = (ImageView) viewDialog.findViewById(R.id.imageViewBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.show();
    }

    private List<Product> getDataProductInCart() {
        List<Product> listProductInCart = new ArrayList<>();

        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));

        return listProductInCart;
    }

    private void showDialogSearch() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = layoutInflater.inflate(R.layout.layout_search, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(viewDialog);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) viewDialog.getParent());
        bottomSheetBehavior.setState(STATE_EXPANDED);
        bottomSheetDialog.show();

        // recycler view
        RecyclerView rcvListProduct = (RecyclerView) viewDialog.findViewById(R.id.recyclerViewSearch);
        List<Product> listProduct = new ArrayList<>(getDataProduct());
        ProductInCategoryAdapter productInCategoryAdapter = new ProductInCategoryAdapter(context, listProduct);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        rcvListProduct.setAdapter(productInCategoryAdapter);
        rcvListProduct.setLayoutManager(linearLayoutManager);

        // button back
        ImageView imgBack = (ImageView) viewDialog.findViewById(R.id.imageViewBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

//         search view filter
        SearchView searchView = (SearchView) viewDialog.findViewById(R.id.searchViewTop);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                productInCategoryAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    public void setRecyclerViewCategory() {
        ArrayList<Category> listCategory = new ArrayList<>(getDataCategory());

        // init
        RecyclerView rcvCatedory = (RecyclerView) view.findViewById(R.id.recyclerViewListCategory);
        CategoryAdapter categoryAdapter = new CategoryAdapter(context, listCategory);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);

        // set up
        rcvCatedory.setAdapter(categoryAdapter);
        rcvCatedory.setLayoutManager(gridLayoutManager);

    }

    private List<Category> getDataCategory() {
        // Add database
        ArrayList<Product> listProduct = new ArrayList<>(getDataProduct());

        List<Category> listCategory = new ArrayList<>();

        ApiService.apiService.getListCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Toast.makeText(context, "Call Api Success", Toast.LENGTH_SHORT).show();
                for(Category category : response.body()) {
                    listCategory.add(new Category(category.getId(), category.getImgPhoto(), category.getName()));
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(context, "Call Api Error", Toast.LENGTH_SHORT).show();
            }
        });

        return listCategory;
    }

    private List<Product> getDataProduct() {
        ArrayList<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "Mì tôm Hảo Hảo chua cay", 10));
        return listProduct;
    }


    public void setRecyclerViewListHighlight() {

        // Add database
        ArrayList<Product> listProduct = new ArrayList<>(getDataProduct());

        ArrayList<Category> listCategory = new ArrayList<>();
//        listCategory.add(new Category("", R.drawable.category1,"Hàng mới về", listProduct));
//        listCategory.add(new Category("", R.drawable.category1,"Bán chạy", listProduct));
//        listCategory.add(new Category("", R.drawable.category1,"Tất cả sản phẩm", listProduct));

        // init
        RecyclerView rcvCatedory = (RecyclerView) view.findViewById(R.id.recyclerViewListHighlight);
        CategoryHighlightAdapter categoryAdapter = new CategoryHighlightAdapter(context, listCategory);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        // set up
        rcvCatedory.setAdapter(categoryAdapter);
        rcvCatedory.setLayoutManager(linearLayoutManager);

    }
}