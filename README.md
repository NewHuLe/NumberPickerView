# NumberPickerView  
<div align=center>
[![](https://jitpack.io/v/NewHuLe/NumberPickerView.svg)](https://jitpack.io/#NewHuLe/NumberPickerView)
<div align=center>
[![](https://github.com/NewHuLe/NumberPickerView/blob/master/author.svg)](https://www.jianshu.com/u/e87d858e89a4)
</br>
仿商城添加商品数量，数量加减选择器，支持手动输入
## 功能简介
```
1. 仿购物车添加删除商品
2. 支持手动输入数量
3. 支持库存数量的最值监听
4. 支持输入框及按钮的样式自定义
```
## 废话不多说，先看效果图
 ![image](https://github.com/NewHuLe/NumberPickerView/blob/master/screenshoot.png)
 
## 使用方法
project工程目录build.gradle添加依赖
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
app项目的目录build.gradle添加依赖
```
dependencies {
	        implementation 'com.github.NewHuLe:NumberPickerView:v1.1'
	}
```
## 支持的自定义属性
```
<resources>
    <declare-styleable name="NumberButton">
        <attr name="editable" format="boolean"/>  //输入框是否就可以编辑
        <attr name="buttonWidth" format="dimension" />  // 按钮的宽度
        <attr name="editextWidth" format="dimension" />  // 输入框的宽度
        <attr name="textSize" format="dimension"/>  // 字体大小
        <attr name="textColor" format="color"/>  // 字体颜色
        <attr name="backgroud" format="reference"/>  // 整体框的背景
        <attr name="individer" format="reference"/>  // 内部垂直分割线
        <attr name="addBackground" format="reference"/>  //左边按钮样式
        <attr name="subBackground" format="reference"/>  //右边按钮样式
    </declare-styleable>
```
    
## Xml定义
```
     <cn.com.cesgroup.numpickerview.NumberPickerView
        android:id="@+id/purchase_num3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="40dp"
        app:addBackground="@color/colorPrimary"
        app:backgroud="@color/colorAccent"
        app:buttonWidth="40dp"
        app:editable="true"
        app:editextWidth="120dp"
        app:individer="@drawable/divider_horizontal2"
        app:subBackground="@color/colorPrimary"
        app:textColor="@android:color/black"
        app:textSize="14sp" />
```
    
## 使用方法
```
        NumberPickerView numberPickerView1 = (NumberPickerView) findViewById(R.id.purchase_num1);
        numberPickerView1.setMaxValue(40) //最大输入值，也就是限量，默认无限大
                .setCurrentInventory(150) // 当前的库存
                .setMinDefaultNum(1)  // 最小限定量
                .setCurrentNum(20)  // 当前数量
                .setmOnClickInputListener(new NumberPickerView.OnClickInputListener() {
            @Override
            public void onWarningForInventory(int inventory) {
                Toast.makeText(MainActivity.this,"超过最大库存",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onWarningMinInput(int minValue) {
                Toast.makeText(MainActivity.this,"低于最小设定值",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onWarningMaxInput(int maxValue) {
                Toast.makeText(MainActivity.this,"超过最大限制量",Toast.LENGTH_SHORT).show();
            }
        });
 ```
        
