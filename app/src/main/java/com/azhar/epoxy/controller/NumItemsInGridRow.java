package com.azhar.epoxy.controller;

import com.airbnb.epoxy.EpoxyModel;

/**
 * @ref: https://github.com/airbnb/epoxy/wiki/Grid-Support
 */
public class NumItemsInGridRow implements EpoxyModel.SpanSizeOverrideCallback {

    public final int numItemsForCurrentScreen;

    /** Specify how many items to show per grid row on phone. Tablet will show more items per row according to a default ratio. */
    public static NumItemsInGridRow setItemCountInRow(int numItemsPerRowOnPhone) {
        return new NumItemsInGridRow(numItemsPerRowOnPhone);
    }

    public NumItemsInGridRow(int countItems) {
        numItemsForCurrentScreen = countItems;
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        if (totalSpanCount % numItemsForCurrentScreen != 0) {
            throw new IllegalStateException(
                    "Total Span Count of : " + totalSpanCount + " can not evenly fit: " + numItemsForCurrentScreen + " cards per row");
        }

        return totalSpanCount / numItemsForCurrentScreen;
    }
}
