package com.diaolizhi.simpleblog.domain;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/17 12:04
 */
public class MyPageInfo {

    private boolean hasPrePage;
    private boolean hasNextPage;
    private int[] navNums;
    private int prePage;
    private int nextPage;
    private int currentNum;

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int[] getNavNums() {
        return navNums;
    }

    public void setNavNums(int[] navNums) {
        this.navNums = navNums;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }
}
