/*
 * Copyright 2014 Blaž Šolar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wefika.horizontalpicker.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wefika.horizontalpicker.HorizontalPicker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<String> dataMale = new ArrayList<>();
    private List<String> dataFemale = new ArrayList<>();
    HorizontalPicker picker;
    HorizontalPicker picker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker = (HorizontalPicker) findViewById(R.id.picker);
        picker1 = (HorizontalPicker) findViewById(R.id.picker1);

        setUpMale(5);
        setUpFemale(5);


        picker.setOnItemSelectedListener(new HorizontalPicker.OnItemSelected() {
            @Override
            public void onItemSelected(int index) {

                setUpFemale(10-(index+1));
                setUpMale(index+1);
            }
        });

        picker1.setOnItemSelectedListener(new HorizontalPicker.OnItemSelected() {
            @Override
            public void onItemSelected(int index) {
                setUpMale(10-(index+1));
                setUpFemale(index+1);
            }
        });
    }

    private void setUpMale(int value) {
        dataMale.clear();
        for (int i = 1; i <= value; i++) {
            dataMale.add(String.valueOf(i));
        }

        CharSequence[] cs = dataMale.toArray(new CharSequence[dataMale.size()]);
        picker.setValues(cs);
    }

    private void setUpFemale(int value) {
        dataFemale.clear();
        for (int i = 1; i <= value; i++) {
            dataFemale.add(String.valueOf(i));
        }

        CharSequence[] cs = dataFemale.toArray(new CharSequence[dataFemale.size()]);
        picker1.setValues(cs);
    }


}
