package com.hikarirms.retail.common.utils;

import com.hikarirms.retail.common.dto.BasePageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

public class PageableUtil {

    public static Pageable generatePageable(BasePageRequest request) {
        int pageNumber = request.getPageNumber() - 1;
        int pageSize = request.getPageSize();
        String sortSource = request.getSort();

        if (sortSource == null || sortSource.isBlank())
            return PageRequest.of(pageNumber, pageSize);

        return PageRequest.of(pageNumber, pageSize, generateSort(request.getSort()));
    }

    public static Sort generateSort(String sortSource) {
        if (sortSource == null || sortSource.isBlank())
            throw new IllegalArgumentException("sortSource can not be blank or null");

        String[] sortList = sortSource.trim().split(",");
        List<Sort.Order> orders = Arrays.stream(sortList)
                .map(s -> {
                    String[] parts = s.trim().split(" ");

                    String propertyName = parts[0];
                    Sort.Direction sortDirection = Sort.Direction.ASC;
                    Sort.NullHandling nullHandling = Sort.NullHandling.NATIVE;
                    boolean ignoreCase = true;

                    if (parts.length > 1 && parts[1].equalsIgnoreCase("desc")) {
                        sortDirection = Sort.Direction.DESC;
                    }
                    if (parts.length > 2) {
                        if (parts[2].equalsIgnoreCase("nulls_first"))
                            nullHandling = Sort.NullHandling.NULLS_FIRST;
                        else if (parts[2].equalsIgnoreCase("nulls_last"))
                            nullHandling = Sort.NullHandling.NULLS_LAST;
                    }

                    return new Sort.Order(sortDirection, propertyName, ignoreCase, nullHandling);
                })
                .toList();

        return Sort.by(orders);
    }

}
