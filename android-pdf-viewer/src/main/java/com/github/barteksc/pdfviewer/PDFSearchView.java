package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.util.AttributeSet;

import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.shockwave.pdfium.util.SizeF;

import java.util.ArrayList;

public class PDFSearchView extends PDFView {



    /**
     * Construct the initial view
     *
     * @param context
     * @param set
     */
    public PDFSearchView(Context context, AttributeSet set) {
        super(context, set);
        highlights = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
    }

    @Override
    public Configurator fromUri(Uri uri) {
        Configurator configurator = super.fromUri(uri);
        return configurator;
    }

    public void searchInPage(String text){
        highlights.clear();
        ArrayList<RectF> a;
        if (getCurrentPage() == 1){
            a = pdfFile.testOne("Programming Guide", 1);
            highlights.addAll(a);
            a = pdfFile.testOne("Copyright", 1);
            highlights.addAll(a);
            a = pdfFile.testOne("prior written permission", 1);
            highlights.addAll(a);
            a = pdfFile.testOne("South Wales (UNSW)", 1);
            highlights.addAll(a);
            a = pdfFile.testOne("Sam Leffler and Copyright", 1);
            highlights.addAll(a);
            a = pdfFile.testOne("copyright notice appears in all copies. This software is provided \"as is\" without express or im-plied warranty, and with no claim as to its suitability for any", 1);
            highlights.addAll(a);
        }


        if ( text != null && text.length() > 0 ){
            a = pdfFile.testOne(text, getCurrentPage());
            highlights.addAll(a);
        }

        redraw();

        //pdfFile.searchInPage(text, getCurrentPage());
    }
}
