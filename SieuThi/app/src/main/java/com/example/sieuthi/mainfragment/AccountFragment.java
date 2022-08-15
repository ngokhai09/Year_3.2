package com.example.sieuthi.mainfragment;

import static com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sieuthi.MainActivity;
import com.example.sieuthi.R;
import com.example.sieuthi.notification.Notification;
import com.example.sieuthi.notification.NotificationAdapter;
import com.example.sieuthi.support.Support;
import com.example.sieuthi.support.SupportAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountFragment extends Fragment {

    Context context;
    View view;

    RelativeLayout layoutDaDangNhap;
    LinearLayout layoutChuaDangNhap;
    ImageView imgDangXuat;

    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);
        context = view.getContext();

        sharedPreferences = getActivity().getSharedPreferences("dataLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        layoutChuaDangNhap = view.findViewById(R.id.layoutChuaDangNhap);
        layoutDaDangNhap = view.findViewById(R.id.layoutDaDangNhap);
        imgDangXuat = view.findViewById(R.id.imageViewDangXuat);

        // recycler view hỗ trợ
        ArrayList<Support> listSupport = new ArrayList<>(getDataSupport());

        RecyclerView rcv = (RecyclerView) view.findViewById(R.id.recyclerView);
        SupportAdapter supportAdapter = new SupportAdapter(context, listSupport);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        rcv.setAdapter(supportAdapter);
        rcv.setLayoutManager(linearLayoutManager);

        // hiển thị layout thay đổi thông tin/ layout đăng nhập, đăng ký
        setLayoutLogin();

        // click thay đổi thông tin khi đã đăng nhập
        layoutDaDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogUpdateUser();
            }
        });

        // đăng nhập
        

        // đăng ký

        // đăng xuất
        imgDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("username");
                editor.commit();
                setLayoutLogin();
            }
        });

        // lịch sử đơn hàng


        // cửa hàng
        RelativeLayout layoutAddress = (RelativeLayout) view.findViewById(R.id.layoutAddress);
        layoutAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogStore();
            }
        });

        // hotline
        RelativeLayout layoutHotline = (RelativeLayout) view.findViewById(R.id.layoutHotline);
        layoutHotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tedPermission();
            }
        });

        return view;
    }

    private void showDialogUpdateUser() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = layoutInflater.inflate(R.layout.layout_infomation, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(viewDialog);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) viewDialog.getParent());
        bottomSheetBehavior.setState(STATE_EXPANDED);
        bottomSheetDialog.show();

        // ánh xạ
        EditText edtHoTen = (EditText) viewDialog.findViewById(R.id.editTextHoTen);
        EditText edtNgaySinh = (EditText) viewDialog.findViewById(R.id.editTextNgaySinh);
        EditText edtEmail = (EditText) viewDialog.findViewById(R.id.editTextEmail);
        EditText edtSDT = (EditText) viewDialog.findViewById(R.id.editTextSDT);
        RadioButton rdNu = (RadioButton) viewDialog.findViewById(R.id.gioiTinhNu);
        RadioButton rdNam = (RadioButton) viewDialog.findViewById(R.id.gioiTinhNam);
        TextView tvCapNhat = (TextView) viewDialog.findViewById(R.id.textViewCapNhat);

        // hiển thị thông tin sẵn có
        edtHoTen.setText(sharedPreferences.getString("hoten", ""));
        edtNgaySinh.setText(sharedPreferences.getString("ngaysinh", ""));
        edtEmail.setText(sharedPreferences.getString("email", ""));
        edtSDT.setText(sharedPreferences.getString("sdt", ""));

        if(sharedPreferences.getString("gioitinh", "").equals("nam")) {
            rdNam.setChecked(true);
            rdNu.setChecked(false);
        } else if(sharedPreferences.getString("gioitinh", "").equals("nu")) {
            rdNu.setChecked(true);
            rdNam.setChecked(false);
        }

        // back
        ImageView imgBack = (ImageView) viewDialog.findViewById(R.id.imageViewBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        // cập nhật thông tin
        //.......
    }

    private void setLayoutLogin() {
        if(checkLogin()) {
            // Đã đăng nhập
            layoutChuaDangNhap.setVisibility(View.INVISIBLE);
            layoutDaDangNhap.setVisibility(View.VISIBLE);
            imgDangXuat.setVisibility(View.VISIBLE);

            TextView tvTen = (TextView) view.findViewById(R.id.textViewTen);
            TextView tvSdt = (TextView) view.findViewById(R.id.textViewSdt);
            tvTen.setText(sharedPreferences.getString("hoten", ""));
            tvSdt.setText(sharedPreferences.getString("sdt", ""));
        } else {
            // Chưa đăng nhập
            layoutChuaDangNhap.setVisibility(View.VISIBLE);
            layoutDaDangNhap.setVisibility(View.INVISIBLE);
            imgDangXuat.setVisibility(View.INVISIBLE);
        }
    }

    private boolean checkLogin() {
        String username = sharedPreferences.getString("username", "");
        if(username == null || username.length() == 0) {
            return false;
        }
        return true;

    }

    private List<Support> getDataSupport() {
        ArrayList<Support> listSupport = new ArrayList<>();
        String[] strTen = getResources().getStringArray(R.array.title_support);
        String[] strND = getResources().getStringArray(R.array.nd_support);

        for(int i=0, j=strTen.length; i<j; i++) {
            listSupport.add(new Support(R.drawable.ic_home, strTen[i], strND[i]));
        }

        return listSupport;
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

}