package com.gxx.textlayoutapplication.weiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.gxx.textlayoutapplication.R;


/**
 * @date 创建时间:2021/4/27 0027
 * @auther gaoxiaoxiong
 * @Descriptiion TextView左边是其它的
 **/
public class TextViewLeftOtherLayout extends FrameLayout {
    private Context mContext;
    private int leftTextViewWidth = 0;
    private int leftTextViewHeight = 0;
    private int leftTextViewPaddingLeft, leftTextViewPaddingRight, leftTextViewPaddingTop, leftTextViewPaddingBottom = 0;
    private int leftTextViewColor = 0;
    private int leftTextViewTextSize = 12;
    private Drawable leftTextViewBackground = null;
    private int leftTextViewMarinTop = 0;
    private String leftTextViewTextValue = "";

    private int rightTextViewColor = 0;
    private int righhtTextViewTextSize = 16;
    private int rightTextViewMaxLines = 2;
    private String rightTextViewTexTValue = "";

    private int leftRightDistance = 0;
    TextView leftTextView = null;
    TextView rightTextView = null;

    public TextViewLeftOtherLayout(@NonNull Context context) {
        this(context, null);
    }

    public TextViewLeftOtherLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextViewLeftOtherLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        leftTextView = new TextView(mContext);
        rightTextView = new TextView(mContext);
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.TextViewLeftOtherLayout, 0, 0);
        try {
            leftTextViewWidth = typedArray.getDimensionPixelOffset(R.styleable.TextViewLeftOtherLayout_tv_leo_left_width, DensityUtil.getInstance().dip2px(0));
            leftTextViewHeight = typedArray.getDimensionPixelOffset(R.styleable.TextViewLeftOtherLayout_tv_leo_left_height, DensityUtil.getInstance().dip2px(20));
            leftTextViewPaddingLeft = typedArray.getDimensionPixelOffset(R.styleable.TextViewLeftOtherLayout_tv_leo_left_paddingleft, DensityUtil.getInstance().dip2px(5));
            leftTextViewPaddingTop = typedArray.getDimensionPixelOffset(R.styleable.TextViewLeftOtherLayout_tv_leo_left_paddingtop, DensityUtil.getInstance().dip2px(0));
            leftTextViewPaddingRight = typedArray.getDimensionPixelOffset(R.styleable.TextViewLeftOtherLayout_tv_leo_left_paddingright, DensityUtil.getInstance().dip2px(5));
            leftTextViewPaddingBottom = typedArray.getDimensionPixelOffset(R.styleable.TextViewLeftOtherLayout_tv_leo_left_paddingbottom, DensityUtil.getInstance().dip2px(0));
            leftTextViewColor = typedArray.getColor(R.styleable.TextViewLeftOtherLayout_tv_leo_left_textcolor, ContextCompat.getColor(mContext, R.color.white));
            leftTextViewTextSize = typedArray.getInt(R.styleable.TextViewLeftOtherLayout_tv_leo_left_textsize, 12);
            leftTextViewBackground = typedArray.getDrawable(R.styleable.TextViewLeftOtherLayout_tv_leo_left_background);
            leftTextViewMarinTop = typedArray.getDimensionPixelOffset(R.styleable.TextViewLeftOtherLayout_tv_leo_left_margintop, DensityUtil.getInstance().dip2px(3));

            rightTextViewColor = typedArray.getColor(R.styleable.TextViewLeftOtherLayout_tv_leo_right_textcolor, ContextCompat.getColor(mContext, R.color.black_222222));
            righhtTextViewTextSize = typedArray.getInteger(R.styleable.TextViewLeftOtherLayout_tv_leo_right_textsize, 14);
            rightTextViewMaxLines = typedArray.getInteger(R.styleable.TextViewLeftOtherLayout_tv_leo_right_maxlines, 2);

            leftRightDistance = typedArray.getDimensionPixelOffset(R.styleable.TextViewLeftOtherLayout_tv_leo_left_right_distance, DensityUtil.getInstance().dip2px(5));
        } finally {
            typedArray.recycle();
        }

        init();
    }

    private void init() {
        LayoutParams leftTextViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        if (leftTextViewWidth > 0) {
            leftTextViewParams.width = leftTextViewWidth;
        }
        if (leftTextViewHeight > 0) {
            leftTextViewParams.height = leftTextViewHeight;
        }

        if (leftTextViewMarinTop > 0){
            leftTextViewParams.topMargin = leftTextViewMarinTop;
        }

        leftTextView.setPadding(leftTextViewPaddingLeft, leftTextViewPaddingTop, leftTextViewPaddingRight, leftTextViewPaddingBottom);
        leftTextView.setGravity(Gravity.CENTER);
        leftTextView.setTextColor(leftTextViewColor);
        leftTextView.setTextSize(leftTextViewTextSize);
        if (leftTextViewBackground != null) {
            leftTextView.setBackground(leftTextViewBackground);
        } else {
            leftTextView.setBackground(this.getResources().getDrawable(R.drawable.shape_rectangle_solid_ffb400_corner5));
        }
        leftTextView.setLayoutParams(leftTextViewParams);


        LayoutParams rightTextViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightTextView.setTextColor(rightTextViewColor);
        rightTextView.setTextSize(righhtTextViewTextSize);
        rightTextView.setMaxLines(rightTextViewMaxLines);
        rightTextView.setEllipsize(TextUtils.TruncateAt.END);
        rightTextView.setLayoutParams(rightTextViewParams);

        this.addView(leftTextView);
        this.addView(rightTextView);


    }

    /**
     * @date 创建时间:2021/4/27 0027
     * @auther gaoxiaoxiong
     * @Descriptiion 设置左右的文字
     **/
    public void setLeftRightTextValue(String leftTextViewTextValue, String rightTextViewTexTValue) {
        if (TextUtils.isEmpty(leftTextViewTextValue)) {
            leftTextViewTextValue = "";
        }

        if (TextUtils.isEmpty(rightTextViewTexTValue)) {
            rightTextViewTexTValue = "";
        }

        leftTextView.setText(leftTextViewTextValue);
        final SpannableString spannableString = new SpannableString(rightTextViewTexTValue);
        leftTextView.post(new Runnable() {
            @Override
            public void run() {
                int dis = leftRightDistance + leftTextView.getWidth();
                LeadingMarginSpan.Standard what = new LeadingMarginSpan.Standard(dis, 0);
                spannableString.setSpan(what, 0, spannableString.length(), SpannableString.SPAN_INCLUSIVE_INCLUSIVE);
                rightTextView.setText(spannableString);
            }
        });

    }

}
