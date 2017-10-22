package kisdmathbasics.edwardadmin.com.kidsmathbasics.model;

/**
 * Created by EdwardAdmin on 2017/10/22.
 */

public class MathItemModel {

    private String mNumberFirstText;
    private String mNumberSecondText;
    private String mNumberThirdText;
    private String mSymbolFirstText;
    private String mSymbolSecondText;
    private String mAnswerText;


    public MathItemModel (String numberFirstText,String numberSecondText,String numberThirdText,String symbolFirstText,String symbolSecondText) {
        this.mNumberFirstText = numberFirstText;
        this.mNumberSecondText = numberSecondText;
        this.mNumberThirdText = numberThirdText;
        this.mSymbolFirstText = symbolFirstText;
        this.mSymbolSecondText = symbolSecondText;
    }

    public String getmNumberFirstText() {
        return mNumberFirstText;
    }

    public String getmNumberSecondText() {
        return mNumberSecondText;
    }

    public String getmNumberThirdText() {
        return mNumberThirdText;
    }

    public String getmSymbolFirstText() {
        return mSymbolFirstText;
    }

    public String getmSymbolSecondText() {
        return mSymbolSecondText;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
