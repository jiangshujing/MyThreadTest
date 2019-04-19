package com.jsj.mythreadtest.callback;

import android.content.Context;
import android.content.ContextWrapper;

import com.jsj.mythreadtest.callback.OnUpdaterRequestBeforeListener;

import java.util.Collections;

public class UpdateContext {

    protected OnUpdaterRequestBeforeListener updaterRequestBeforeListener;


    public void addUpdaterRequestBeforeListener(OnUpdaterRequestBeforeListener listener) {
        updaterRequestBeforeListener = listener;
    }
}
