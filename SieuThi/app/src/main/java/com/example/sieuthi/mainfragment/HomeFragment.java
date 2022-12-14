package com.example.sieuthi.mainfragment;

import static com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sieuthi.R;
import com.example.sieuthi.banner.Banner;
import com.example.sieuthi.banner.BannerAdapter;
import com.example.sieuthi.category.Category;
import com.example.sieuthi.category.CategoryHighlightAdapter;
import com.example.sieuthi.newsfeed.Newsfeed;
import com.example.sieuthi.newsfeed.NewsfeedAdapter;
import com.example.sieuthi.product.Product;
import com.example.sieuthi.product.ProductInCartAdapter;
import com.example.sieuthi.product.ProductInCategoryAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    Context context;
    View view;

    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        context = view.getContext();

        sharedPreferences = getActivity().getSharedPreferences("dataLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Banner
        RecyclerView rcvBanner = (RecyclerView) view.findViewById(R.id.recyclerViewBanner);
        setRecyclerViewBanner(rcvBanner);

        // 3 danh m???c sp n???i b???t: b??n ch???y, h??ng m???i, t???t c??? sp
        RecyclerView rcvCatedoryHighlight = (RecyclerView) view.findViewById(R.id.recyclerViewListHighlight);
        setRecyclerViewCategoryHighlight(rcvCatedoryHighlight);

        // tin t???c
        RecyclerView rcvNewsfeed = (RecyclerView) view.findViewById(R.id.recyclerViewNewsfeed);
        setRecyclerViewNewsfeed(rcvNewsfeed, 5);    // Hi???n t???i ??a 5 tin t???c

        // Khung search t??m ki???m s???n ph???m
        TextView tvSearch = (TextView) view.findViewById(R.id.textViewSearch);
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogSearch();
            }
        });

        // Gi??? h??ng
        ImageView imgCart = (ImageView) view.findViewById(R.id.imageViewCart);
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogCart();
            }
        });

        // 4 Button ??i???u h?????ng ?????u ti??n --> m??? fragment/dialog t????ng ???ng
        ImageButton btnSanPham = (ImageButton) view.findViewById(R.id.imageButtonSanPham);
        btnSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageButton btnHotline = (ImageButton) view.findViewById(R.id.imageButtonHotline);
        btnHotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tedPermission();
            }
        });

        ImageButton btnBangTin = (ImageButton) view.findViewById(R.id.imageButtonBangTin);
        btnBangTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNewsfeedCT();
            }
        });

        ImageButton btnCuaHang = (ImageButton) view.findViewById(R.id.imageButtonCuaHang);
        btnCuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogStore();
            }
        });

        // s??? ki???n click xem th??m tin t???c
        TextView tvXemThem = (TextView) view.findViewById(R.id.textViewNewsSeeMore);
        tvXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNewsfeedCT();
            }
        });

        return view;
    }

    public void showDialogSearch() {
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

        // search view filter
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

    private void tedPermission() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                openIntentCallPhone();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(context, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        TedPermission.create()
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check();
    }

    private void openIntentCallPhone() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + String.valueOf(R.string.store_hotline)));
        startActivity(intent);
    }

    private void showDialogStore() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = layoutInflater.inflate(R.layout.bottom_sheet_store, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(viewDialog);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) viewDialog.getParent());
        bottomSheetBehavior.setState(STATE_EXPANDED);
        bottomSheetDialog.show();

        CircleImageView circleImageView = (CircleImageView) viewDialog.findViewById(R.id.circleImageViewClose);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
    }

    private void showDialogCart() {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = layoutInflater.inflate(R.layout.layout_cart, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(viewDialog);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) viewDialog.getParent());
        bottomSheetBehavior.setState(STATE_EXPANDED);

        // Ki???m tra ???? ????ng nh???p ch??a
        RelativeLayout layoutChuaDangnhap = (RelativeLayout) viewDialog.findViewById(R.id.layoutCartChuaDangNhap);
        RelativeLayout layoutDaDangnhap = (RelativeLayout) viewDialog.findViewById(R.id.layoutCartDaDangNhap);
        if(!checkLogin()) {    // Ch??a ????ng nh???p
            layoutChuaDangnhap.setVisibility(View.VISIBLE);
            layoutDaDangnhap.setVisibility(View.INVISIBLE);
        } else {    // ???? ????ng nh???p
            layoutChuaDangnhap.setVisibility(View.INVISIBLE);
            layoutDaDangnhap.setVisibility(View.VISIBLE);

            // recycler view
            RecyclerView rcvListCart = (RecyclerView) viewDialog.findViewById(R.id.recyclerViewList);
            List<Product> listProductInCart = new ArrayList<>(getDataProductInCart());
            ProductInCartAdapter productInCartAdapter = new ProductInCartAdapter(context, listProductInCart);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

            rcvListCart.setAdapter(productInCartAdapter);
            rcvListCart.setLayoutManager(linearLayoutManager);

            // C???p nh???t t???ng ti???n
            TextView tvClickTT = (TextView) viewDialog.findViewById(R.id.textViewClickTongTien);
            TextView tvTongTien = (TextView) viewDialog.findViewById(R.id.textViewTongTien);

            tvClickTT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int money = 0;
                    for(Product product : getDataProductInCart()) {
                        money += product.getPrice() * product.getQuantity();
                    }
                    tvTongTien.setText(editPrice(productInCartAdapter.getTongTien()));
                }
            });
        }

        // back
        ImageView imgBack = (ImageView) viewDialog.findViewById(R.id.imageViewBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        // ?????t h??ng => hi???n th??? giao di???n ?????t h??ng
        Button btnDatHang = (Button) viewDialog.findViewById(R.id.buttonDatHang);
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogDatHang(bottomSheetDialog);
            }
        });

        bottomSheetDialog.show();

    }

    private boolean checkLogin() {
        String username = sharedPreferences.getString("username", "");
        if(username == null || username.length() == 0) {
            return false;
        }
        return true;

    }

    private void showDialogDatHang(BottomSheetDialog bottomSheetDialogParent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = layoutInflater.inflate(R.layout.layout_order_now, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(viewDialog);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) viewDialog.getParent());
        bottomSheetBehavior.setState(STATE_EXPANDED);
        bottomSheetDialog.show();

        // ki???m tra ????ng nh???p => t??? ?????ng c???p nh???t th??ng tin ?????t h??ng
        EditText edtHoTen = (EditText) viewDialog.findViewById(R.id.editTextHoTen);
        EditText edtSDT = (EditText) viewDialog.findViewById(R.id.editTextSDT);
        EditText edtDiaChi = (EditText) viewDialog.findViewById(R.id.editTextDiaChi);
        EditText edtGhiChu = (EditText) viewDialog.findViewById(R.id.editTextGhiChu);

        if(checkLogin()) {
            edtHoTen.setText(sharedPreferences.getString("hoten", ""));
            edtSDT.setText(sharedPreferences.getString("sdt", ""));
        }

        // back
        ImageView imgBack = (ImageView) viewDialog.findViewById(R.id.imageViewBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        // ?????t h??ng: validate
        TextView tvDatHang = (TextView) viewDialog.findViewById(R.id.textViewDatHang);
        tvDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtHoTen.getText().toString().trim().length() == 0 || edtSDT.getText().toString().trim().length() == 0
                        || edtDiaChi.getText().toString().trim().length() == 0) {
                    Toast.makeText(context, "Vui l??ng ??i???n ?????y ????? th??ng tin ?????t h??ng!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "?????t h??ng th??nh c??ng!", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                    bottomSheetDialogParent.dismiss();
                }

            }
        });

    }

    String editPrice(int price) {
        String sPrice = price + "";
        for(int i=sPrice.length() - 3; i>0; i -= 3) {
            sPrice = sPrice.substring(0, i) + "," + sPrice.substring(i, sPrice.length());
        }
        return sPrice + "??";
    }

    private void showDialogNewsfeedCT() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = layoutInflater.inflate(R.layout.layout_newsfeed_ct, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(viewDialog);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) viewDialog.getParent());
        bottomSheetBehavior.setState(STATE_EXPANDED);

        RecyclerView rcvNewsfeedCT = (RecyclerView) viewDialog.findViewById(R.id.recyclerViewNewsfeedCT);
        setRecyclerViewNewsfeed(rcvNewsfeedCT, -1);

        ImageView imgCart = (ImageView) viewDialog.findViewById(R.id.imageViewCart);
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogCart();
            }
        });

        ImageView imgBack = (ImageView) viewDialog.findViewById(R.id.imageViewBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.cancel();
            }
        });

        bottomSheetDialog.show();
    }

    public void setRecyclerViewNewsfeed(RecyclerView rcvNewsfeed, int slMax) {

        // init
        List<Newsfeed> listNewsfeed = new ArrayList<>(getDataNewsfeed());
        NewsfeedAdapter newsfeedAdapter = new NewsfeedAdapter(context, listNewsfeed);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        if(slMax != -1) {
            newsfeedAdapter.setSlMax(slMax);
        }

        // set up
        rcvNewsfeed.setAdapter(newsfeedAdapter);
        rcvNewsfeed.setLayoutManager(linearLayoutManager);

    }

    public void setRecyclerViewCategoryHighlight(RecyclerView rcvCatedory) {

        // init
        List<Product> listProduct = new ArrayList<>(getDataProduct());
        List<Category> listCategory = new ArrayList<>(getDataCategoryHighlight(listProduct));
        CategoryHighlightAdapter categoryAdapter = new CategoryHighlightAdapter(context, listCategory);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        // set up
        rcvCatedory.setAdapter(categoryAdapter);
        rcvCatedory.setLayoutManager(linearLayoutManager);

    }

    public void setRecyclerViewBanner(RecyclerView rcvBanner) {

        // init
        List<Banner> listBanner = new ArrayList<>(getDataBanner());
        BannerAdapter bannerAdapter = new BannerAdapter(context, listBanner);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        // set up
        rcvBanner.setAdapter(bannerAdapter);
        rcvBanner.setLayoutManager(linearLayoutManager);

    }

    // Get Database

    private List<Product> getDataProduct() {
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? t??m Kokomi", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? xa?? H???o H???o", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? Ommi", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? Omachi", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? ph??? Cung ????nh", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? ph??? b?? Vifon", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? ph??? g?? Vifon", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? ph??? v???t Hi???u L???n", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? th???t b??", 10));
        listProduct.add(new Product("", R.drawable.product1, 5000, "M?? tr???ng x??c x??ch", 10));
        return listProduct;

    }

    private List<Banner> getDataBanner() {
        List<Banner> listBanner = new ArrayList<>();

        listBanner.add(new Banner(R.drawable.banner));
        listBanner.add(new Banner(R.drawable.banner));
        listBanner.add(new Banner(R.drawable.banner));
        listBanner.add(new Banner(R.drawable.banner));
        listBanner.add(new Banner(R.drawable.banner));
        listBanner.add(new Banner(R.drawable.banner));
        listBanner.add(new Banner(R.drawable.banner));
        listBanner.add(new Banner(R.drawable.banner));
        return listBanner;
    }

    private List<Category> getDataCategoryHighlight(List<Product> listProduct) {

        List<Category> listCategory = new ArrayList<>();
//        listCategory.add(new Category("", String.pa, "H??ng m???i v???", listProduct));
//        listCategory.add(new Category("", R.drawable.category1,"B??n ch???y", listProduct));
//        listCategory.add(new Category("", R.drawable.category1,"T???t c??? s???n ph???m", listProduct));
        return listCategory;
    }

    private List<Newsfeed> getDataNewsfeed() {
        List<Newsfeed> listNewsfeed = new ArrayList<>();

        String strContentTest = getResources().getString(R.string.large_text);
        listNewsfeed.add(new Newsfeed(R.drawable.banner, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.news1, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.banner, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.news1, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.banner, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.news1, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.banner, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.news1, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.banner, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));
        listNewsfeed.add(new Newsfeed(R.drawable.news1, "Ng??y h???i gi???m gi?? s??n sale th??? ga", "25/03/2022",
                "T??? ng??y 25.03-31.03, ch???t ????n ngay h??ng tr??m m???t h??ng v???i gi?? si??u r???", strContentTest));

        return listNewsfeed;
    }

    private List<Product> getDataProductInCart() {
        List<Product> listProductInCart = new ArrayList<>();

        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));
        listProductInCart.add(new Product("", R.drawable.product1, 5000, "M?? t??m H???o H???o chua cay", 10));

        return listProductInCart;
    }

}