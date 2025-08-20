package jp.wasabeef.example.glide;

import android.content.res.Resources;

/**
 * Copyright (C) 2020 Wasabeef
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class Ext {
    public static float getPx(float dp) {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }

    public static int getPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}