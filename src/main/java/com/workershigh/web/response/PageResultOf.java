package com.workershigh.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PageResultOf<T> {
    Collection<T> items;

    Integer page;

    Integer pageSize;

    long totalRow;

    Integer totalPage;
}
