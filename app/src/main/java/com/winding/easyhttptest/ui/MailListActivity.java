package com.winding.easyhttptest.ui;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.winding.easyhttptest.R;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by 刘少帅 on 2017/9/27
 */

public class MailListActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_list);


    }

    public void intoMailList(View view) {
        getPhoneContacts();
    }

    /**获取库Phon表字段**/

    /**联系人显示名称**/
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;

    /**电话号码**/
    private static final int PHONES_NUMBER_INDEX = 1;

    /**头像ID**/
    private static final int PHONES_PHOTO_ID_INDEX = 2;

    /**联系人的ID**/
    private static final int PHONES_CONTACT_ID_INDEX = 3;


    /**联系人名称**/
    private ArrayList<String> mContactsName = new ArrayList<String>();

    /**联系人头像**/
    private ArrayList<String> mContactsNumber = new ArrayList<String>();

    /**联系人头像**/
    private ArrayList<Bitmap> mContactsPhonto = new ArrayList<Bitmap>();
    private static final String[] PHONES_PROJECTION = new String[]{
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID};

    /**得到手机通讯录联系人信息**/
    private void getPhoneContacts() {
        ContentResolver resolver = getContentResolver();

// 获取手机联系人
        Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);


        if (phoneCursor != null) {
            while (phoneCursor.moveToNext()) {

                //得到手机号码
                String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
                //当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;

                //得到联系人名称
                String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);

                //得到联系人ID
                Long contactid = phoneCursor.getLong(PHONES_CONTACT_ID_INDEX);

                //得到联系人头像ID
                Long photoid = phoneCursor.getLong(PHONES_PHOTO_ID_INDEX);

                //得到联系人头像Bitamp
                Bitmap contactPhoto = null;

                //photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
                if (photoid > 0) {
                    Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactid);
                    InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(resolver, uri);
                    contactPhoto = BitmapFactory.decodeStream(input);
                } else {
                    contactPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.img);
                }
                Log.e(TAG, "getPhoneContacts: " + contactName + "|||" + phoneNumber);
                mContactsName.add(contactName);
                mContactsNumber.add(phoneNumber);
                mContactsPhonto.add(contactPhoto);
            }

            phoneCursor.close();
        }
    }

    public void intoMailListReturn(View view) {

//        Intent i = new Intent(Intent.ACTION_PICK);
//        i.setType("vnd.android.cursor.dir/phone");
//        startActivityForResult(i, 2);

        Intent i = new Intent();
        i.setAction(Intent.ACTION_PICK);
        i.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case RESULT_OK:
                switch (requestCode) {
                    case 2:
                        if (data == null) {
                            return;
                        }
                        String phoneNumber = null;
                        Uri contactData = data.getData();
                        if (contactData == null) {
                            return;
                        }
                        Cursor cursor = managedQuery(contactData, null, null, null, null);
                        if (cursor.moveToFirst()) {
//                  String name = cursor.getString(cursor
//                          .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                            String hasPhone = cursor
                                    .getString(cursor
                                            .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                            String id = cursor.getString(cursor
                                    .getColumnIndex(ContactsContract.Contacts._ID));
                            if (hasPhone.equalsIgnoreCase("1")) {
                                hasPhone = "true";
                            } else {
                                hasPhone = "false";
                            }
                            if (Boolean.parseBoolean(hasPhone)) {
                                Cursor phones = getContentResolver().query(
                                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                        null,
                                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                                + " = " + id, null, null);
                                while (phones.moveToNext()) {
                                    phoneNumber = phones
                                            .getString(phones
                                                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                    setTitle(phoneNumber);
                                }
                                phones.close();
                            }
                        }
                        Log.e(TAG, "onActivityResult: " + phoneNumber);

                        break;
                }
                break;
        }


    }

    public void autoPhone(View view) {
//        //激活可以打电话的组件
//        Intent intent = new Intent();
//        intent.setAction("Android.intent.action.CALL");
//        //intent.addCategory("android.intent.category.DEFAULT");
//        intent.setData(Uri.parse("tel:"+ "18657194104"));
//        startActivity(intent);//方法内部自动添加android.intent.category.DEFAULT

        Uri uri = Uri.parse("tel:18657194104");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }

    public void autoPhone2(View view) {
        Uri uri = Uri.parse("tel:18657194104");
        Intent it = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(it);
//        //告诉系统我要直接拨号了。
//        call(Intent.ACTION_CALL);
    }
    private void call(String action){
        String phone ="18657194104";
        if(phone!=null&&phone.trim().length()>0){
            //这里"tel:"+电话号码 是固定格式，系统一看是以"tel:"开头的，就知道后面应该是电话号码。
            Intent intent = new Intent(action, Uri.parse("tel:" + phone.trim()));
            startActivity(intent);//调用上面这个intent实现拨号
        }else{
            Toast.makeText(this, "电话号码不能为空", Toast.LENGTH_LONG).show();
        }
    }
}
