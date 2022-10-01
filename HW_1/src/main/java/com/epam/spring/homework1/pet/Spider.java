package com.epam.spring.homework1.pet;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class Spider implements Animal {

}
