package com.telco.operator.telcoservices.util;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import com.telco.operator.telcoservices.util.RestListMessage;

public final class TelcoUtil {

	static public Pageable buildPageable(int pageNumber, int pageSize, String orderByProperty, String orderByDir) {
        Sort.Direction orderByDirection = null;
        if (orderByProperty != null && !orderByProperty.isEmpty()) {
            try {
                orderByDirection = Sort.Direction.fromString(orderByDir);
            } catch (Exception e) {
                orderByDirection = Sort.Direction.ASC;
            }
        }

        return orderByDirection == null ?  PageRequest.of(pageNumber - 1, pageSize)
                : PageRequest.of(pageNumber - 1, pageSize, JpaSort.unsafe(orderByDirection, orderByProperty));
    }

    static public <T, A> RestListMessage<A> convertPageToList(Page<T> page, List<A> list) {
        RestListMessage<A> message = new RestListMessage<A>();

        message.setContent(list);
        message.setCurrentPage(page.getNumber() + 1);
        message.setTotalElements(page.getTotalElements());
        message.setTotalPages(page.getTotalPages());

        return message;
    }
    
}
