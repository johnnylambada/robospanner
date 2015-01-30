package johnnylambada.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import johnnylambada.R;

/**
 * Created by john on 11/25/14.
 */
public class SquareImageView extends ImageView {

    private boolean matchWidthToHeight = false;
    private boolean matchHeightToWidth = false;

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        populateAttributes(attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        populateAttributes(attrs);
    }

    private void populateAttributes(AttributeSet attrs) {
        TypedArray a = getContext().getTheme()
            .obtainStyledAttributes(attrs, R.styleable.SquareImageView, 0, 0);
        try {
            matchWidthToHeight = a.getBoolean(R.styleable.SquareImageView_matchWidthToHeight, false);
            matchHeightToWidth = a.getBoolean(R.styleable.SquareImageView_matchHeightToWidth, false);
        } finally {
            a.recycle();
        }
    }

    public void setMatchWidthToHeight(boolean val){matchWidthToHeight=val;}
    public void setMatchHeightToWidth(boolean val){matchHeightToWidth=val;}

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (matchWidthToHeight) {
            setMeasuredDimension(getMeasuredHeight(), getMeasuredHeight());
        } else if (matchHeightToWidth) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        }
    }
}
