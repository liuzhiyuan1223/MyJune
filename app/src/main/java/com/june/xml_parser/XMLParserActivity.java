package com.june.xml_parser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;

import com.june.R;
import com.june.xml_parser.model.City;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLParserActivity extends AppCompatActivity {

    private static final String TAG = "july5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_m_l_parser);

        click(null);
    }

    List<City> cityList;

    public void click(View v){
        //获取到src文件夹下的资源文件ClassLoader.getResourceAsStream.返回的是InputStream类型的。
        InputStream is = getClassLoader().getResourceAsStream("weather.xml"); //注释：暂时没有走通，这里拿到的是null

        //拿到pull解析器对象XmlPullParser是一个接口，不可以new
        XmlPullParser xp = Xml.newPullParser();
        //初始化
        try {
            xp.setInput(is, "utf-8");//初始化，设置文件的位置流对象（解析目标文件对象）和解析编码格式

            //获取当前节点的事件类型，因为pull解析是从xml文件第一行头节点往下解析的，“指针”往下移动，标签（节点）不同，事件类型就不同。
            //通过事件类型的判断，我们可以知道当前节点是什么节点，从而确定我们应该做什么操作
            int type = xp.getEventType();
            City city = null;
            while(type != XmlPullParser.END_DOCUMENT){//xp.END_DOCUMENT
                //根据节点的类型，要做不同的操作
                switch (type) {
                    case XmlPullParser.START_TAG:

                        // 获取当前节点的名字
                        if("weather".equals(xp.getName())){

                            //创建city集合对象，用于存放city的javabean
                            cityList = new ArrayList<City>();
                        }
                        else if("city".equals(xp.getName())){

                            //创建city的javabean对象
                            city = new City();
                        }
                        else if("name".equals(xp.getName())){

                            // 获取当前节点的下一个节点的[文本]
                            String name = xp.nextText();
                            city.setName(name);
                        }
                        else if("temp".equals(xp.getName())){
                            //				获取当前节点的下一个节点的文本
                            String temp = xp.nextText();
                            city.setTemp(temp);
                        }
                        else if("pm".equals(xp.getName())){
                            //				获取当前节点的下一个节点的文本
                            String pm = xp.nextText();
                            city.setPm(pm);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("city".equals(xp.getName())){
                            //把city的javabean放入集合中。三个城市city，解析完一个城市就把那个城市实例放到集合里面去。
                            cityList.add(city);
                        }
                        break;

                }

                //把指针移动到下一个节点，并返回该节点的事件类型
                type = xp.next();
            }

            for (City c : cityList) {
//                System.out.println(c.toString());
                Log.d(TAG, "c.toString(): " + c.toString());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}