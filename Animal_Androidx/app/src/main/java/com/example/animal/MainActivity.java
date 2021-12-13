package com.example.animal;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFrg1();


    }

    private void showFrg1() {
        FrgMH001 frg1 = new FrgMH001();
        frg1.setAnimalTypeArrayList(iconlist());
        showFrg(frg1);
    }

    public void showFrg(Fragment frg) {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_main, frg, null).commit();
    }

    /**
     *  phương thức iconlist dùng để tạo ra danh sách animal gồm thông tin bitmap và titile của icon
     * */
    public ArrayList<com.example.animal.AnimalType> iconlist(){

        int[] animalGroupID = {R.string.folder_icon_bird, R.string.folder_icon_mammal, R.string.folder_icon_sea};
        String[] assetFileName;
        ArrayList<com.example.animal.AnimalType> animalTypeArrayList = new ArrayList<>();

        try {
            for (int idStringResource : animalGroupID) {
                String assetFolderName = getString(idStringResource);
                //Duyệt qua tất cả các file trong assetFolderName và gán tất cả tên file vào string array
                assetFileName = getApplicationContext().getAssets().list(assetFolderName);

                for (String imageFileName : assetFileName) {
                    //tên file có cấu trúc là ic_[filename].png
                    //Vì vậy title sẽ lấy subString từ index 3 đến index của phần tử dấu .
                    String title = imageFileName.substring(3, imageFileName.indexOf("."));

                    //tạo path đến vị trí lưu file bitmap
                    String path = assetFolderName + "/" + imageFileName;

                    //input file bitmap
                    Bitmap bitmapStream = BitmapFactory.decodeStream(getApplicationContext().getAssets().open(path));

                    //gán giá trị title và bitmap vào 1 phần tử arraylist <animaltype>
                    AnimalType iconInfo = new AnimalType(title,bitmapStream,null,null);
                    animalTypeArrayList.add(iconInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animalTypeArrayList;
    }


}