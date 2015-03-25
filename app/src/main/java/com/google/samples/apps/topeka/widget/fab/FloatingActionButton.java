/*
 * Copyright 2014 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.samples.apps.topeka.widget.fab;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.google.samples.apps.topeka.widget.outlineprovider.FabOutlineProvider;
import com.google.samples.apps.topeka.R;

/**
 * Generic implementation of the
 * <a href=
 * "http://www.google.com/design/spec/components/buttons.html#buttons-floating-action-button">
 * floating action button</a>
 * described in the material design guidelines.
 */
public class FloatingActionButton extends ImageView {

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFocusable(true);
        setClickable(true);
        Resources resources = getResources();
        final int fabPadding = resources.getDimensionPixelSize(R.dimen.inset_fab);
        setPadding(fabPadding, fabPadding, fabPadding, fabPadding);
        setOutlineProvider(new FabOutlineProvider());
        setClipToOutline(true);
        setBackgroundResource(R.drawable.fab_background);
        setElevation(resources.getDimension(R.dimen.elevation_fab));
    }
}