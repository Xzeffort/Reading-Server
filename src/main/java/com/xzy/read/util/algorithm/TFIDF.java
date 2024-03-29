package com.xzy.read.util.algorithm;

import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

/**
 * @author XieZhongYi
 * 2020/04/13 11:41
 */
public class TFIDF {

    public static Result split(String text)
    {
        return ToAnalysis.parse(text);
    }


    public static List<Keyword> getTFIDE(String title, String content, int keyNums)
    {
        // String
        // sentence="我今天很开心，所以一口气买了好多东西。然而我一不小心把本月预算透支了，现在有很不开心了，因为后面的日子得吃土了！";
        KeyWordComputerSub kwc = new KeyWordComputerSub(keyNums);
        return kwc.computeArticleTfidf(title, content);
    }

    public static List<Keyword> getTFIDE(String content,int keyNums)
    {
        KeyWordComputerSub kwc = new KeyWordComputerSub(keyNums);
        return kwc.computeArticleTfidf(content);
    }

}
