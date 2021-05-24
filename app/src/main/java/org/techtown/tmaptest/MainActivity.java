package org.techtown.tmaptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;
import com.squareup.otto.Subscribe;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TMapGpsManager.onLocationChangedCallback {

    private static final int REQUEST_CODE = 101;
    private ImageButton pro, navi, time;


    private long lastTimeBackPressed;
    String API_Key = "l7xx04eb869c4b064be4904d5fd75d609819";
    double clkLat = 0.0;
    double clkLong = 0.0;

    // T Map View
    TMapView tMapView = null;

    // T Map GPS
    TMapGpsManager tMapGPS = null;

    //길찾기 메뉴로 추가된 코드
    TMapPoint tMapPointStart = null;
    TMapPoint tMapPointEnd = null;
    String Distance = null;
    String Time = null;

    TMapPoint searchPoint = null;

    TMapPOIItem POIItem = new TMapPOIItem();

    ArrayList<String> arrPOI = new ArrayList<>();
    int testNum = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     /*   //DB test
        //DB 생성
        DBHelper helper;
        SQLiteDatabase db;
        helper = new DBHelper(MainActivity.this, "sampledb.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

        //db 값 입력
        ContentValues values = new ContentValues();
        values.put("txt","test");
        db.insert("mytable",null,values);*/


        //길안내 버튼 테스트
       // BusProvider.getInstance().register(this);   // Bus


        // T Map View
        tMapView = new TMapView(this);

        // API Key
        tMapView.setSKTMapApiKey(API_Key);

        //TMapMarkerItem markerItem1 = new TMapMarkerItem();

        //TMapPoint tMapPoint1 = new TMapPoint(37.3004, 127.0358); // 경기대학교 수원캠퍼스

        //fragment를 이용한 메인 버튼 출력
        pro = (ImageButton) findViewById(R.id.pro);
        navi = (ImageButton) findViewById(R.id.navi);
        time = (ImageButton) findViewById(R.id.time);

        //교수님 정보 버튼
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tMapView.removeAllTMapPolyLine(); //다른 버튼 누르면 이전 길찾기 종료
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FragmentProfessor Fpro = new FragmentProfessor();
                transaction.replace(R.id.tmap, Fpro);
                transaction.commit();
            }
        });

        //강의동 리스트
        navi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FragmentLec Flec = new FragmentLec();
                transaction.replace(R.id.tmap, Flec);
                transaction.commit();
            }
        });

        //시간표
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tMapView.removeAllTMapPolyLine(); //다른 버튼 누르면 이전 길찾기 종료
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FragmentTimetable Ftime = new FragmentTimetable();
                transaction.replace(R.id.tmap, Ftime);
                transaction.commit();
            }
        });

        // 마커 아이콘
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.iconfinder_icons_pin);

        //markerItem1.setIcon(bitmap); // 마커 아이콘 지정
        //markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
        //markerItem1.setTMapPoint( tMapPoint1 ); // 마커의 좌표 지정
        //markerItem1.setName(""); // 마커의 타이틀 지정
        //tMapView.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가

        //tMapView.setCenterPoint( 127.0358, 37.3004);

        // Initial Setting
        tMapView.setZoomLevel(17);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);

        // T Map View Using Linear Layout
        FrameLayout linearLayoutTmap = (FrameLayout) findViewById(R.id.tmap);
        linearLayoutTmap.addView(tMapView);

        // Request For GPS permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        // GPS using T Map
        tMapGPS = new TMapGpsManager(this);

        // Initial Setting
        tMapGPS.setMinTime(1000);
        tMapGPS.setMinDistance(10);
        tMapGPS.setProvider(tMapGPS.NETWORK_PROVIDER);
        //tMapGPS.setProvider(tMapGPS.GPS_PROVIDER);

        tMapGPS.OpenGps();


        // 클릭 이벤트 설정
        tMapView.setOnClickListenerCallBack(new TMapView.OnClickListenerCallback() {
            @Override
            public boolean onPressEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint, PointF pointF) {
                //Toast.makeText(getApplicationContext(), tMapPoint.getLatitude() + ", " + tMapPoint.getLongitude(), Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onPressUpEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint, PointF pointF) {
                //Toast.makeText(MapEvent.this, "onPressUp~!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // 롱 클릭 이벤트 설정
        tMapView.setOnLongClickListenerCallback(new TMapView.OnLongClickListenerCallback() {
            @Override
            public void onLongPressEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint) {
                Toast.makeText(getApplicationContext(), tMapPoint.getLatitude() + ", " + tMapPoint.getLongitude(), Toast.LENGTH_SHORT).show();
                TMapMarkerItem markerItem1 = new TMapMarkerItem();

                TMapPoint tMapPoint1 = new TMapPoint(tMapPoint.getLatitude(), tMapPoint.getLongitude()); // 경기대학교 수원캠퍼스

                markerItem1.setIcon(bitmap); // 마커 아이콘 지정
                markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
                markerItem1.setTMapPoint(tMapPoint1); // 마커의 좌표 지정
                markerItem1.setName(""); // 마커의 타이틀 지정
                tMapView.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가

                tMapView.setCenterPoint(tMapPoint.getLongitude(), tMapPoint.getLatitude(), true);
            }
        });

        // 지도 스크롤 종료
        tMapView.setOnDisableScrollWithZoomLevelListener(new TMapView.OnDisableScrollWithZoomLevelCallback() {
            @Override
            public void onDisableScrollWithZoomLevelEvent(float zoom, TMapPoint centerPoint) {

            }
        });

    }
    @Override
    protected void onActivityResult(int requetCode, int resultCode, Intent data) {
        super.onActivityResult(101, resultCode, data);

        if(requetCode == REQUEST_CODE) {
            if(resultCode != Activity.RESULT_OK) {
                return;
            }
            double search_lati = data.getExtras().getDouble("SearchMain_Lati");
            double search_longi = data.getExtras().getDouble("SearchMain_Longi");

            TMapPoint Now = new TMapPoint(tMapGPS.getLocation().getLatitude(), tMapGPS.getLocation().getLongitude());
            searchPoint = new TMapPoint(search_lati, search_longi);
            tMapView.setCenterPoint(search_longi, search_lati, true);
            drawPolyLine(Now, searchPoint);
        }
    }
    @Override
    public void onLocationChange(Location location) {
        tMapView.setLocationPoint(location.getLongitude(), location.getLatitude());
        tMapView.setCenterPoint(location.getLongitude(), location.getLatitude());
    }

    private void drawPolyLine(TMapPoint startPoint, TMapPoint endPoint){

        new Thread(){
            @Override
            public void run(){
                try {
                    TMapPolyLine tMapPolyLine = new TMapData().findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH, startPoint, endPoint);
                    tMapPolyLine.setLineColor(Color.BLUE);
                    tMapPolyLine.setLineWidth(2);
                    tMapView.addTMapPolyLine("Line1", tMapPolyLine);

                    new TMapData().findPathDataAllType(TMapData.TMapPathType.PEDESTRIAN_PATH, startPoint, endPoint, new TMapData.FindPathDataAllListenerCallback(){
                        @Override
                        public void onFindPathDataAll(Document document) {
                            Element root = document.getDocumentElement();
                            NodeList nodeListPlacemark = root.getElementsByTagName("Document");
                            for( int i=0; i< nodeListPlacemark.getLength();i++){

                                NodeList Dis = root.getElementsByTagName("tmap:totalDistance");
                                Distance = Dis.item(0).getChildNodes().item(0).getNodeValue();
                                NodeList time = root.getElementsByTagName("tmap:totalTime");
                                Time = time.item(0).getChildNodes().item(0).getNodeValue();
                                int min = Integer.parseInt(Time)/60;
                                int sec = Integer.parseInt(Time)%60;
                                //TextView text = (TextView)findViewById(R.id.textTest);
                                //text.setText("거리 : " + Distance + "m 시간 : " + min + "분 " + sec + "초");
                                Log.d("debug", "거리 : " + Distance + "m\n시간 : " + min + "분 " + sec + "초");
                            }
                        }//end onFindPathDataAll
                    }); //end findPathDataWithType

                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private void setMultiMarkers(ArrayList<TMapPoint> arrTPoint, ArrayList<String> arrTitle,
                                 ArrayList<String> arrAddress) {
        for (int i = 0; i < arrTPoint.size(); i++) {
            // 마커 아이콘
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.iconfinder_endpoint);

            TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();
            tMapMarkerItem.setIcon(bitmap);

            tMapMarkerItem.setTMapPoint(arrTPoint.get(i));

            tMapView.addMarkerItem("markerItem" + i, tMapMarkerItem);

            //setBalloonView(tMapMarkerItem, arrTitle.get(i), arrAddress.get(i));
        }
    }

    private void setBalloonView(TMapMarkerItem marker, String title, String address) {
        marker.setCanShowCallout(true);

        if (marker.getCanShowCallout()) {
            marker.setCalloutTitle(title);
            marker.setCalloutSubTitle(address);

            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.iconfinder_arrow_down);
            marker.setCalloutRightButtonImage(bitmap);
        }
    }


    private void searchPOI(ArrayList<String> arrPOI) {
        final TMapData tMapData = new TMapData();
        final ArrayList<TMapPoint> arrTMapPoint = new ArrayList<>();
        final ArrayList<String> arrTitle = new ArrayList<>();
        final ArrayList<String> arrAddr = new ArrayList<>();

        for (int i = 0; i < arrPOI.size(); i++) {
            tMapData.findTitlePOI(arrPOI.get(i), new TMapData.FindTitlePOIListenerCallback() {
                @Override
                public void onFindTitlePOI(ArrayList<TMapPOIItem> arrayList) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        TMapPOIItem tMapPOIItem = arrayList.get(j);
                        arrTMapPoint.add(tMapPOIItem.getPOIPoint());
                        arrTitle.add(tMapPOIItem.getPOIName());
                        arrAddr.add(tMapPOIItem.upperAddrName + " " +
                                tMapPOIItem.middleAddrName + " " + tMapPOIItem.lowerAddrName);
                        System.out.println(arrAddr);
                    }
                    setMultiMarkers(arrTMapPoint, arrTitle, arrAddr);
                }
            });
        }
    }
    private void setMultiMarkers(ArrayList<TMapPoint> arrTPoint)
    {
        for( int i = 0; i < arrTPoint.size(); i++ )
        {
            // 마커 아이콘
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.iconfinder_endpoint);

            TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();
            tMapMarkerItem.setIcon(bitmap);

            tMapMarkerItem.setTMapPoint(arrTPoint.get(i));

            tMapView.addMarkerItem("markerItem" + i, tMapMarkerItem);

            //setBalloonView(tMapMarkerItem, arrTitle.get(i), arrAddress.get(i));
        }
    }

//강의동 좌표
        void getPOIPoint(ArrayList<String> arrPOI, int bldNum) {
        final TMapData tMapData = new TMapData();
        final ArrayList<TMapPoint> arrTMapPoint = new ArrayList<>();
        final ArrayList<String> arrTitle = new ArrayList<>();
        final ArrayList<String> arrAddr = new ArrayList<>();
        TMapPoint Now = new TMapPoint(tMapGPS.getLocation().getLatitude(), tMapGPS.getLocation().getLongitude());

        //for (int i = 0; i < arrPOI.size(); i++) {
        tMapData.findTitlePOI(arrPOI.get(bldNum), new TMapData.FindTitlePOIListenerCallback() {
            @Override
            public void onFindTitlePOI(ArrayList<TMapPOIItem> arrayList) {
                TMapPOIItem tMapPOIItem = arrayList.get(0);
                arrTMapPoint.add(tMapPOIItem.getPOIPoint());
                arrTitle.add(tMapPOIItem.getPOIName());
                arrAddr.add(tMapPOIItem.upperAddrName + " " +
                        tMapPOIItem.middleAddrName + " " + tMapPOIItem.lowerAddrName);
                System.out.println(arrAddr);
                tMapPointEnd = tMapPOIItem.getPOIPoint();
                tMapView.setCenterPoint(tMapPointEnd.getLongitude(), tMapPointEnd.getLatitude(), true);
                setMultiMarkers(arrTMapPoint, arrTitle, arrAddr);
                drawPolyLine(Now, tMapPointEnd);

            }
        });
        //}

        }
    //기타 좌표 수동입력
    void getPoint(ArrayList<TMapPoint> arrPoint, int bldNum){
        final ArrayList<TMapPoint> arrTMapPoint = new ArrayList<>();
        TMapPoint Now = new TMapPoint(tMapGPS.getLocation().getLatitude(), tMapGPS.getLocation().getLongitude());
        arrTMapPoint.add(arrPoint.get(bldNum));
        setMultiMarkers(arrTMapPoint);
        drawPolyLine(Now, arrPoint.get(bldNum));
    }

    @Override
    public void onBackPressed() {

        //프래그먼트 onBackPressedListener사용
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        for (Fragment fragment : fragmentList) {
            if (fragment instanceof onBackPressedListener) {
                ((onBackPressedListener) fragment).onBackPressed();
                return;
            }
        }
        //두 번 클릭시 어플 종료
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish();
            return;
        }

        lastTimeBackPressed = System.currentTimeMillis();
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();


    }

    //강의동 설명에서 길찾기 버튼 눌렀을 때 이벤트
    @Subscribe
    public void LectureRoom(int num) {
        ArrayList<String> arrPOI = new ArrayList<>();
        arrPOI.add("경기대학교 수원캠퍼스 진리관");
        arrPOI.add("경기대학교 수원캠퍼스 성신관");
        arrPOI.add("경기대학교 수원캠퍼스 애경관");
        arrPOI.add("경기대학교 수원캠퍼스 예지관");
        arrPOI.add("경기대학교 수원캠퍼스 덕문관");
        arrPOI.add("경기대학교 수원캠퍼스 광교관");
        arrPOI.add("경기대학교 수원캠퍼스 집현관");
        arrPOI.add("경기대학교 수원캠퍼스 육영관");
        arrPOI.add("경기대학교 수원캠퍼스 종합강의동");
        Log.e("TAG","bus");
        getPOIPoint(arrPOI, num);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        //BusProvider.getInstance().unregister(this);      // Bus
    }


}
