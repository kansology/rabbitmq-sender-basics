package com.kansal.rabbitmq.message.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tarunkansal on 2/20/17.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserInfo {
    private final String name;
    private final String guid;
    private final long userId;
    private final String creator;
}
