package com.platform.mocklearn.common;

import com.platform.mocklearn.model.request.BasePageRequest;
import org.apache.ibatis.session.RowBounds;

public class RowBoundsConverter {
    public static RowBounds convert(BasePageRequest basePagingRequest) {
        int offset = basePagingRequest.getItemsPerPage() * (basePagingRequest.getPage() - 1);
        int limit = basePagingRequest.getItemsPerPage();
        return new RowBounds(offset, limit);
    }
}
