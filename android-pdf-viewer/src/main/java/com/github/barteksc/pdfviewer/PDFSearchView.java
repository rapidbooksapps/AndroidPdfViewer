package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.util.AttributeSet;

public class PDFSearchView extends PDFView {

    /**
     * Construct the initial view
     *
     * @param context
     * @param set
     */
    public PDFSearchView(Context context, AttributeSet set) {
        super(context, set);
    }

    public void searchInPage(String text){
        pdfFile.searchInPage(text, getCurrentPage());
    }
}
